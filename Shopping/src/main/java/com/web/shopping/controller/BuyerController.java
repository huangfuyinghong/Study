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
		LOGGER.info("buyer main ������ ȣ��()");
	}

// --------------------------------------------------------------------------	
	
	// �α���
		@GetMapping("/buyer/login")
		public void loginGet(String url, Model model) {
			LOGGER.info("buyer loginGet() ȣ��");
			model.addAttribute("targetUrl", url); // login.jsp�� url ���� ����
		}

		// �α���
		@PostMapping("/buyer/login")
		public String loginPost(BuyerVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr,
				HttpSession session) {
			LOGGER.info("buyer loginPost() ȣ��");

			BuyerVO bvo = buyerService.readLogin(vo);
			session = req.getSession();

			boolean passMatch = passwordEncoder.matches(vo.getbPW(), bvo.getbPW());

			if (bvo != null && passMatch == true) {

				session.setAttribute("buyer", bvo);
				System.out.print("bID : " + bvo.getbID());
				System.out.print(bvo);
			} else {
				LOGGER.info("result ��� : " + bvo);
				session.setAttribute("buyer", null);
				rttr.addFlashAttribute("msg", false);
				return "redirect:/buyer/login";
			}
			return "redirect:/buyer/main";
		} // end loginPost

// --------------------------------------------------------------------------

		// �α׾ƿ�
		@RequestMapping(value = "buyer/logout")
		public String buyerlogout(HttpServletRequest req, HttpSession session) {
			LOGGER.info("logout() ȣ��");

			session = req.getSession();
			session.removeAttribute("buyer");

			return "redirect:/buyer/login";
		}

// --------------------------------------------------------------------------

		// buyer ȸ�� ��ü ����Ʈ
		@GetMapping(value = "admin/buyer_list")
		public void list(Model model, Integer page, Integer perPage) {
			LOGGER.info("list ȣ��");
			LOGGER.info("page = " + page + ", perPage = " + perPage);

			// Paging ó��
			PageCriteria criteria = new PageCriteria();
			if (page != null) {
				criteria.setPage(page);
			}
			if (perPage != null) {
				criteria.setNumsPerPage(perPage);
			}

			List<BuyerVO> list = buyerService.read(criteria);
//			for(BuyerVO vo : list) { // ��ü����Ʈ ��������  
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

		// buyer ȸ�� ����
		@GetMapping("buyer_register")
		public void registerGet() {
			LOGGER.info("buyer registerGET() ȣ��");
			LOGGER.info("uploadGet() ȣ�� : " + uploadPath);
			LOGGER.info("uploadAjaxGET() ȣ��");
		} // end registerGet

		@PostMapping("buyer_register")
		public String registerPOST(BuyerVO vo, MultipartFile[] files, Model model, RedirectAttributes reAttr) { // RedirectAttributes
																												// : ���� ��ġ��
																												// // ��ü
			LOGGER.info("buyer registerPOST() ȣ��");
			LOGGER.info(vo.toString());

			for (int i = 0; i < files.length; i++) {

				files[i].getOriginalFilename();
				String saveName = vo.getbID() + "_license_buyer_" + files[i].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("licence ���� ���� ����");

				} catch (IOException e) {
					LOGGER.error("licence ���� ���� ����");
				}
				vo.setbLICENSE(saveName);

			}
			
			// ȸ������ �� ��й�ȣ ��ȣȭ �ڵ�
			String bPW = passwordEncoder.encode(vo.getbPW());
			vo.setbPW(bPW);

			int result = buyerService.create(vo);
			System.out.println();
			// "insert_result"�� Ű�̸��� ���� ������ ����
			if (result == 1) { // DB insert ����
				return "redirect:/buyer/login"; // /buyer/list ��η� �̵�(get) ���
			} else { // DB insert ����
				return "redirect:/buyer/register";
			}

		} // end registerPOST


		// --------------------------------------------------------------------------

		// ȸ�� ���� ( ������ )
		@GetMapping("admin/buyer_detail")
		public void detailGET(String bID, Model model) {
			LOGGER.info("buyer detail(admin) ȣ�� : bID = " + bID);
			BuyerVO vo = buyerService.read(bID);
			model.addAttribute("buyerVO", vo);
		} // end detailGET
		
		
			// ȸ�� ���� ���� (admin)
		@GetMapping("admin/buyer_info_update")
		public void buyerInfoUpdateGET(String bID, Model model, HttpServletRequest req) {
			LOGGER.info("buyer info updateGET(admin) ȣ�� ");
			BuyerVO vo = buyerService.read(bID);
			LOGGER.info("buyer update vo : " + vo);
			model.addAttribute("buyerVO", vo);

		} // end updateBuyerGET

		@PostMapping("admin/buyer_info_update")
		public String buyerInfoUpdatePOST(String bID, BuyerVO vo, MultipartFile[] files) {
			LOGGER.info("buyer update Post() ȣ��");
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
						LOGGER.info("licence ���� ���� ����");

					} catch (IOException e) {
						LOGGER.error("licence ���� ���� ����");
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

		// seller id �ߺ� üũ
		@PostMapping(value = "buyer/bidCheck")
		@ResponseBody // @ResponseBody ������ ���� json�����͸� �ڹ� ��ü�� �����ϴ� ������̼�
		public int bidCheck(@RequestBody String bID) { // @RequestBody �ڹ� ��ü�� HTTP ���� body�� �����ϱ� ���� ���

			int count = 0;
			count = buyerService.bidCheck(bID);
			return count;
		}

// ---------------------------------------------------------------------------------

		// ȸ�� ���� (buyer)
		@GetMapping("buyer/info")
		public void infoGET(String bID, Model model, HttpServletRequest req) {
			LOGGER.info("buyer �� ���� ȣ��");
			LOGGER.info("buyer info ȣ�� : bID = " + bID);
			BuyerVO vo = buyerService.read(bID);
			model.addAttribute("buyerVO", vo);
		} // end infoGET

// ---------------------------------------------------------------------------------

		// ȸ�� ���� ���� (buyer)
		@GetMapping("buyer/update")
		public void updateGET(String bID, Model model, HttpServletRequest req) {
			LOGGER.info("buyer updatePOST() ȣ�� : bID = " + bID);
			BuyerVO vo = buyerService.read(bID);
			LOGGER.info("buyer update vo : " + vo);
			model.addAttribute("buyerVO", vo);
		} // end updateGET

		@PostMapping("buyer/update")
		public String updatePOST(BuyerVO vo, String bID, MultipartFile[] files) {
			LOGGER.info("buyer update Post() ȣ��");
			LOGGER.info("buyer update vo : " + vo);
			BuyerVO bvo = buyerService.read(bID);
			LOGGER.info("updatePOST() ȣ�� : bID = " + vo.getbID());
			LOGGER.info("buyer update : bLICENSE = " + bvo.getbLICENSE());

			for (int i = 0; i < files.length; i++) {

				if (files[i].getOriginalFilename() != "") {
					String saveName = vo.getbID() + "_license_buyer_" + files[i].getOriginalFilename();
					File target = new File(uploadPath, saveName);

					try {
						FileCopyUtils.copy(files[i].getBytes(), target);
						LOGGER.info("licence ���� ���� ����");

					} catch (IOException e) {
						LOGGER.error("licence ���� ���� ����");
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

		// ȸ�� Ż��
		@GetMapping("buyer/delete")
		public void delete() {
			LOGGER.info("buyer delete ȣ��()");
		}

		// ȸ�� Ż��
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

	// �̹��� ���
	@GetMapping("buyer/display")
	public ResponseEntity<byte[]> display(String fileName) throws IOException {
		LOGGER.info("display() ȣ��");

		ResponseEntity<byte[]> entity = null;
		InputStream in = null;

		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);

		// ���� Ȯ����
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		LOGGER.info(extension);
		// ���� ���(response header)�� Content-Type ����
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));

		// ������ ����
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), // ���Ͽ��� ���� ������
				httpHeaders, // ���� ���
				HttpStatus.OK);
		return entity;
	}
	
// --------------------------------------------------------------------------------
	


} // end BuyerController
