package com.web.shopping.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.BuyerService;
import com.web.shopping.util.MediaUtil;

@Controller
@RequestMapping(value = "/")
public class BuyerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuyerController.class);

	@Autowired
	private BuyerService buyerService;
	@Inject
	PasswordEncoder passwordEncoder;
	@Resource(name = "uploadPath")
	private String uploadPath;

// --------------------------------------------------------------------------	

	@GetMapping(value = "buyer/main")
	public void main() {
		LOGGER.info("buyer main 페이지 호출()");
	}

// --------------------------------------------------------------------------	
	
	// 로그인
		@GetMapping("/buyer/login")
		public void loginGet(String url, Model model) {
			LOGGER.info("buyer loginGet() 호출");
			model.addAttribute("targetUrl", url); // login.jsp에 url 정보 전송
		}

		// 로그인
		@PostMapping("/buyer/login")
		public String loginPost(BuyerVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr,
				HttpSession session) {
			LOGGER.info("buyer loginPost() 호출");

			BuyerVO bvo = buyerService.readLogin(vo);
			session = req.getSession();

			boolean passMatch = passwordEncoder.matches(vo.getbPW(), bvo.getbPW());

			if (bvo != null && passMatch == true) {

				session.setAttribute("buyer", bvo);
				System.out.print("bID : " + bvo.getbID());
				System.out.print(bvo);
			} else {
				LOGGER.info("result 출력 : " + bvo);
				session.setAttribute("buyer", null);
				rttr.addFlashAttribute("msg", false);
				return "redirect:/buyer/login";
			}
			return "redirect:/buyer/main";
		} // end loginPost

// --------------------------------------------------------------------------

		// 로그아웃
		@RequestMapping(value = "buyer/logout")
		public String buyerlogout(HttpServletRequest req, HttpSession session) {
			LOGGER.info("logout() 호출");

			session = req.getSession();
			session.removeAttribute("buyer");

			return "redirect:/buyer/login";
		}

// --------------------------------------------------------------------------

		// buyer 회원 전체 리스트
		@GetMapping(value = "admin/buyer_list")
		public void list(Model model, Integer page, Integer perPage) {
			LOGGER.info("list 호출");
			LOGGER.info("page = " + page + ", perPage = " + perPage);

			// Paging 처리
			PageCriteria criteria = new PageCriteria();
			if (page != null) {
				criteria.setPage(page);
			}
			if (perPage != null) {
				criteria.setNumsPerPage(perPage);
			}

			List<BuyerVO> list = buyerService.read(criteria);
//			for(BuyerVO vo : list) { // 전체리스트 가져오기  
//			LOGGER.info(vo.toString());
//			}
			model.addAttribute("buyerList", list);

			PageMaker maker = new PageMaker();
			maker.setCriteria(criteria);
			maker.setTotalCount(buyerService.getTotalNumsOfRecords());
			maker.setPageData();
			model.addAttribute("pageMaker", maker);
		} // end list

// --------------------------------------------------------------------------

		// buyer 회원 가입
		@GetMapping("buyer_register")
		public void registerGet() {
			LOGGER.info("buyer registerGET() 호출");
			LOGGER.info("uploadGet() 호출 : " + uploadPath);
			LOGGER.info("uploadAjaxGET() 호출");
		} // end registerGet

		@PostMapping("buyer_register")
		public String registerPOST(BuyerVO vo, MultipartFile[] files, Model model, RedirectAttributes reAttr) { // RedirectAttributes
																												// : 재경로 위치에
																												// // 객체
			LOGGER.info("buyer registerPOST() 호출");
			LOGGER.info(vo.toString());

			for (int i = 0; i < files.length; i++) {

				files[i].getOriginalFilename();
				String saveName = vo.getbID() + "_license_buyer_" + files[i].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("licence 파일 저장 성공");

				} catch (IOException e) {
					LOGGER.error("licence 파일 저장 실패");
				}
				vo.setbLICENSE(saveName);

			}
			
			// 회원가입 시 비밀번호 암호화 코드
			String bPW = passwordEncoder.encode(vo.getbPW());
			vo.setbPW(bPW);

			int result = buyerService.create(vo);
			System.out.println();
			// "insert_result"의 키이름을 가진 데이터 전송
			if (result == 1) { // DB insert 성공
				return "redirect:/buyer/login"; // /buyer/list 결로로 이동(get) 방식
			} else { // DB insert 실패
				return "redirect:/buyer/register";
			}

		} // end registerPOST


		// --------------------------------------------------------------------------

		// 회원 정보 ( 관리자 )
		@GetMapping("admin/buyer_detail")
		public void detailGET(String bID, Model model) {
			LOGGER.info("buyer detail(admin) 호출 : bID = " + bID);
			BuyerVO vo = buyerService.read(bID);
			model.addAttribute("buyerVO", vo);
		} // end detailGET
		
		
			// 회원 정보 수정 (admin)
		@GetMapping("admin/buyer_info_update")
		public void buyerInfoUpdateGET(String bID, Model model, HttpServletRequest req) {
			LOGGER.info("buyer info updateGET(admin) 호출 ");
			BuyerVO vo = buyerService.read(bID);
			LOGGER.info("buyer update vo : " + vo);
			model.addAttribute("buyerVO", vo);

		} // end updateBuyerGET

		@PostMapping("admin/buyer_info_update")
		public String buyerInfoUpdatePOST(String bID, BuyerVO vo, MultipartFile[] files) {
			LOGGER.info("buyer update Post() 호출");
			LOGGER.info("buyer update vo : " + vo);
			LOGGER.info("buyer update : bID = " + vo.getbID());
			BuyerVO bvo = buyerService.read(bID);
			LOGGER.info("seller update : bLICENSE = " + bvo.getbLICENSE());

			for (int i = 0; i < files.length; i++) {

				if (files[i].getOriginalFilename() != "") {
					String saveName = vo.getbID() + "_license_buyer_" + files[i].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("licence 파일 저장 성공");

					} catch (IOException e) {
						LOGGER.error("licence 파일 저장 실패");
					}
					vo.setbLICENSE(saveName);
				}
				if (files[i].getOriginalFilename() == "") {
					String saveName = bvo.getbLICENSE();
					vo.setbLICENSE(saveName);
				}

			}

			int result = buyerService.update(vo);
			if (result == 1) {
				return "redirect:/admin/buyer_detail?bID=" + vo.getbID();
			} else {
				return "redirect:/admin/buyer_info_updateB?bID=" + vo.getbID();
			}
		} // end updateBuyerPOST

// --------------------------------------------------------------------------

		// seller id 중복 체크
		@PostMapping(value = "buyer/bidCheck")
		@ResponseBody // @ResponseBody 서버로 보낸 json데이터를 자바 객체로 매핑하는 어노테이션
		public int bidCheck(@RequestBody String bID) { // @RequestBody 자바 객체를 HTTP 응답 body로 전송하기 위해 사용

			int count = 0;
			count = buyerService.bidCheck(bID);
			return count;
		}

// ---------------------------------------------------------------------------------

		// 회원 정보 (buyer)
		@GetMapping("buyer/info")
		public void infoGET(String bID, Model model, HttpServletRequest req) {
			LOGGER.info("buyer 내 정보 호출");
			LOGGER.info("buyer info 호출 : bID = " + bID);
			BuyerVO vo = buyerService.read(bID);
			model.addAttribute("buyerVO", vo);
		} // end infoGET

// ---------------------------------------------------------------------------------

		// 회원 정보 수정 (buyer)
		@GetMapping("buyer/update")
		public void updateGET(String bID, Model model, HttpServletRequest req) {
			LOGGER.info("buyer updatePOST() 호출 : bID = " + bID);
			BuyerVO vo = buyerService.read(bID);
			LOGGER.info("buyer update vo : " + vo);
			model.addAttribute("buyerVO", vo);
		} // end updateGET

		@PostMapping("buyer/update")
		public String updatePOST(BuyerVO vo, String bID, MultipartFile[] files) {
			LOGGER.info("buyer update Post() 호출");
			LOGGER.info("buyer update vo : " + vo);
			BuyerVO bvo = buyerService.read(bID);
			LOGGER.info("updatePOST() 호출 : bID = " + vo.getbID());
			LOGGER.info("buyer update : bLICENSE = " + bvo.getbLICENSE());

			for (int i = 0; i < files.length; i++) {

				if (files[i].getOriginalFilename() != "") {
					String saveName = vo.getbID() + "_license_buyer_" + files[i].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("licence 파일 저장 성공");

					} catch (IOException e) {
						LOGGER.error("licence 파일 저장 실패");
					}
					vo.setbLICENSE(saveName);
				}
				if (files[i].getOriginalFilename() == "") {
					String saveName = bvo.getbLICENSE();
					vo.setbLICENSE(saveName);
				}

			}

			int result = buyerService.update(vo);
			if (result == 1) {
				return "redirect:/buyer/info?bID=" + vo.getbID();
			} else {
				return "redirect:/buyer/update?bID=" + vo.getbID();
			}
		} // end updatePOST

// ---------------------------------------------------------------------------------	

		// 회원 탈퇴
		@GetMapping("buyer/delete")
		public void delete() {
			LOGGER.info("buyer delete 호출()");
		}

		// 회원 탈퇴
		@PostMapping("buyer/delete")
		public String delete(BuyerVO vo, HttpSession session, HttpServletRequest req, RedirectAttributes rttr) {
			LOGGER.info("post buyer delete");

			session = req.getSession();
			BuyerVO bvo = (BuyerVO) session.getAttribute("buyer");
			LOGGER.info("buyer : " + bvo);

			boolean passMatch = passwordEncoder.matches(vo.getbPW(), bvo.getbPW());

			if (passMatch == false) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:/buyer/delete";
			} else {
				buyerService.delete(vo);
				session.invalidate();
				return "redirect:/buyer/login";
			}
		} // end delete

// ---------------------------------------------------------------------------------

	// 이미지 출력
	@GetMapping("buyer/display")
	public ResponseEntity<byte[]> display(String fileName) throws IOException {
		LOGGER.info("display() 호출");

		ResponseEntity<byte[]> entity = null;
		InputStream in = null;

		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);

		// 파일 확장자
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		LOGGER.info(extension);
		// 응답 헤더(response header)에 Content-Type 설정
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));

		// 데이터 전송
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), // 파일에서 읽은 데이터
				httpHeaders, // 응답 헤더
				HttpStatus.OK);
		return entity;
	}
	
// --------------------------------------------------------------------------------
	


} // end BuyerController
