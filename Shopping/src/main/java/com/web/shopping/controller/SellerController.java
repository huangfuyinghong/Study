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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.SellerService;
import com.web.shopping.util.MediaUtil;

@Controller
@RequestMapping(value = "/")
public class SellerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	private SellerService sellerService;
	@Inject
	PasswordEncoder passwordEncoder;
	@Resource(name = "uploadPath")
	private String uploadPath;

	// 로그인
	@GetMapping("seller/login")
	public void loginGet(String url, Model model) {
		LOGGER.info("seller loginGet() 호출");
	} // end loginGet

	@PostMapping("seller/login")
	public String loginPost(SellerVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr,
			HttpSession session) {
		LOGGER.info("seller loginPost() 호출");

		SellerVO svo = sellerService.readLogin(vo);
		session = req.getSession();

		boolean passMatch = passwordEncoder.matches(vo.getsPW(), svo.getsPW());

		if (svo != null && passMatch == true) {
//		if (svo != null && passEncoder.matches(vo.getsPW(), svo.getsPW())) {
//		if (svo != null && svo.getsPW().equals(vo.getsPW())) {

			session.setAttribute("seller", svo);
			System.out.print("sID : " + svo.getsID());
			System.out.print(svo);
		} else {
			LOGGER.info("result 출력 : " + svo);
			session.setAttribute("seller", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/seller/login";
		}
		return "redirect:/seller/main";
	} // end loginPost

// ---------------------------------------------------------------------------------

	// 로그아웃
	@GetMapping("seller/logout")
	public String sellerLogout(HttpServletRequest req, HttpSession session) {
		LOGGER.info("sellerLogout() 호출");

		session = req.getSession();
		session.removeAttribute("seller");
		

		return "redirect:/seller/login";
	} // end logout

// ---------------------------------------------------------------------------------

	// 회원가입 get
	@GetMapping("seller_register")
	public void registerGet() {
		LOGGER.info("seller registerGet() 호출");
		LOGGER.info("uploadGet() 호출 : " + uploadPath);
		LOGGER.info("uploadAjaxGET() 호출");
	}

	// 회원가입 post
	@PostMapping("seller_register")
	public String registerPost(SellerVO vo, MultipartFile[] files, Model model) {
		LOGGER.info("seller registerPost() 호출");

		for (int i = 0; i < files.length; i++) {

			files[i].getOriginalFilename();
			if (i == 0) {
				String saveName = vo.getsID() + "_licence_seller_" + files[0].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("licence 파일 저장 성공");

				} catch (IOException e) {
					LOGGER.error("licence 파일 저장 실패");
				}
				vo.setsLICENCE(saveName);
			}

			if (i == 1) {
				String saveName = vo.getsID() + "_bank_seller_" + files[1].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("bank 파일 저장 성공");

				} catch (IOException e) {
					LOGGER.error("bank 파일 저장 실패");
				}
				vo.setsBANK(saveName);
			}
		}
		// 회원가입 시 비밀번호 암호화 코드 
		String bPW = passwordEncoder.encode(vo.getsPW());
		vo.setsPW(bPW);
		 
		int result = sellerService.create(vo);
//		int count = sellerService.sidCheck(vo.getsID());

		if (result == 1) { // DB insert 성공
			return "redirect:/seller/login";
		} else { // DB insert 실패
			return "redirect:/seller/register";
		}
	}

// ---------------------------------------------------------------------------------

	// 회원 정보 ( 관리자 )
	@GetMapping("admin/seller_detail")
	public void detailGET(String sID, Model model) {
		LOGGER.info("detail() 호출 : sID = " + sID);
		SellerVO vo = sellerService.read(sID);
		model.addAttribute("sellerVO", vo);
	} // end detailGET

	// 회원 정보 수정 (admin)
	@GetMapping("admin/seller_info_update")
	public void sellerInfoUpdateGET(String sID, Model model, HttpServletRequest req) {
		LOGGER.info("seller update Get() 호출");
		SellerVO vo = sellerService.read(sID);
		LOGGER.info("seler update vo : " + vo);
		model.addAttribute("sellerVO", vo);
	} // end updateGET

	@PostMapping("admin/seller_info_update")
	public String sellerInfoUpdatePOST(String sID, SellerVO vo, MultipartFile[] files) {
		LOGGER.info("seller update Post() 호출");
		LOGGER.info("seler update vo : " + vo);
		LOGGER.info("seller update : sID = " + vo.getsID());
		SellerVO svo = sellerService.read(sID);
		LOGGER.info("seller update : sLICENCE = " + svo.getsLICENCE());
		LOGGER.info("seller update : sBANK = " + svo.getsBANK());

		for (int i = 0; i < files.length; i++) {

			if (i == 0) {
				if (files[0].getOriginalFilename() != "") {
					String saveName = vo.getsID() + "_licence_seller_" + files[0].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("licence 파일 저장 성공");

					} catch (IOException e) {
						LOGGER.error("licence 파일 저장 실패");
					}
					vo.setsLICENCE(saveName);

				}
				if (files[0].getOriginalFilename() == "") {
					String saveName = svo.getsLICENCE();
					vo.setsLICENCE(saveName);
				}
			}

			if (i == 1) {
				if (files[1].getOriginalFilename() != "") {
					String saveName = vo.getsID() + "_bank_seller_" + files[1].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("bank 파일 저장 성공");
						vo.setsBANK(saveName);
					} catch (IOException e) {
						LOGGER.error("bank 파일 저장 실패");
					}
					vo.setsBANK(saveName);
				}
				if (files[1].getOriginalFilename() == "") {
					String saveName = svo.getsBANK();
					vo.setsBANK(saveName);
				}
			}

		}

		int result = sellerService.update(vo);
		if (result == 1) {
			return "redirect:/admin/seller_detail?sID=" + vo.getsID();
		} else {
			return "redirect:/admin/seller_info_update?sID=" + vo.getsID();
		}
	} // end updatePOST

// ---------------------------------------------------------------------------------

	// 회원 정보 (seller)
	@GetMapping("seller/info")
	public void infoGET(String sID, Model model, HttpServletRequest req) {
		LOGGER.info("seller 내 정보 호출");
		// HttpSession session = req.getSession();
//		String sID = (String) session.getAttribute("sID");
		LOGGER.info("seller info() 호출 : sID = " + sID);
		SellerVO vo = sellerService.read(sID);
		model.addAttribute("sellerVO", vo);
	} // end infoGET

// ---------------------------------------------------------------------------------

	// 회원 정보 수정 (seller)
	@GetMapping("seller/update")
	public void updateGET(String sID, Model model, HttpServletRequest req) {
		LOGGER.info("seller update Get() 호출");
		SellerVO vo = sellerService.read(sID);
		LOGGER.info("seler update vo : " + vo);
		model.addAttribute("sellerVO", vo);
	} // end updateGET

	@PostMapping("seller/update")
	public String updatePOST(String sID, SellerVO vo, MultipartFile[] files) {
		LOGGER.info("seller update Post() 호출");
		LOGGER.info("seler update vo : " + vo);
		LOGGER.info("seller update : sID = " + vo.getsID());
		SellerVO svo = sellerService.read(sID);
		LOGGER.info("seller update : sLICENCE = " + svo.getsLICENCE());
		LOGGER.info("seller update : sBANK = " + svo.getsBANK());

		for (int i = 0; i < files.length; i++) {

			if (i == 0) {
				if (files[0].getOriginalFilename() != "") {
					String saveName = vo.getsID() + "_licence_seller_" + files[0].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("licence 파일 저장 성공");

					} catch (IOException e) {
						LOGGER.error("licence 파일 저장 실패");
					}
					vo.setsLICENCE(saveName);

				}
				if (files[0].getOriginalFilename() == "") {
					String saveName = svo.getsLICENCE();
					vo.setsLICENCE(saveName);
				}
			}

			if (i == 1) {
				if (files[1].getOriginalFilename() != "") {
					String saveName = vo.getsID() + "_bank_seller_" + files[1].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("bank 파일 저장 성공");
						vo.setsBANK(saveName);
					} catch (IOException e) {
						LOGGER.error("bank 파일 저장 실패");
					}
					vo.setsBANK(saveName);
				}
				if (files[1].getOriginalFilename() == "") {
					String saveName = svo.getsBANK();
					vo.setsBANK(saveName);
				}
			}

		}

		int result = sellerService.update(vo);
		if (result == 1) {
			return "redirect:/seller/info?sID=" + vo.getsID();
		} else {
			return "redirect:/seller/update?sID=" + vo.getsID();
		}
	} // end updatePOST

// ---------------------------------------------------------------------------------

	// 회원 탈퇴
	@GetMapping("seller/delete")
	public void delete() {
		LOGGER.info("seller delete 호출()");
	}

	@PostMapping("seller/delete")
	public String delete(SellerVO vo, HttpSession session, HttpServletRequest req, RedirectAttributes rttr) {
		LOGGER.info("post seller delete");

		session = req.getSession();
		SellerVO svo = (SellerVO) session.getAttribute("seller");
		LOGGER.info("seller : " + svo);

		boolean passMatch = passwordEncoder.matches(vo.getsPW(), svo.getsPW());

		if (passMatch == false) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/seller/delete";
		} else {
			sellerService.delete(vo);
			session.invalidate();
			return "redirect:/seller/login";
		}

	} // end delete

// ---------------------------------------------------------------------------------	

	@GetMapping(value = "seller/main")
	public void main() {
		LOGGER.info("seller main 페이지 호출()");
	}

// ---------------------------------------------------------------------------------

	// seller 전체 리스트
	@GetMapping(value = { "seller/list", "admin/seller_list" })
	public void list(Model model, Integer page, Integer perPage) {
		LOGGER.info("seller list 호출");
		LOGGER.info("page = " + page + ", perPage = " + perPage);

		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) {
			criteria.setNumsPerPage(perPage);
		}

		List<SellerVO> list = sellerService.read(criteria);
//		for(SellerVO vo : list) { // 전체리스트 가져오기  
//			LOGGER.info(vo.toString());
//		}
		model.addAttribute("sellerList", list);

		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(sellerService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} // end list()

// ---------------------------------------------------------------------------------

	// seller id 중복 체크
	@PostMapping(value = "seller/sidCheck")
	@ResponseBody // @ResponseBody 서버로 보낸 json데이터를 자바 객체로 매핑하는 어노테이션
	public int sidCheck(@RequestBody String sID) { // @RequestBody 자바 객체를 HTTP 응답 body로 전송하기 위해 사용

		int count = 0;
		count = sellerService.sidCheck(sID);
		return count;
	}

// ---------------------------------------------------------------------------------

	// seller name(상호명) 중복 체크
	@PostMapping(value = "seller/snameCheck")
	@ResponseBody
	public int snameCheck(@RequestBody String sNAME) {

		int count = 0;
		count = sellerService.snameCheck(sNAME);
		return count;
	}

// ---------------------------------------------------------------------------------

	// 이미지 출력
	@GetMapping("seller/display")
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

// ---------------------------------------------------------------------------------
} // end SellerController
