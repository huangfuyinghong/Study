package com.web.shopping.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.shopping.domain.AdminVO;
import com.web.shopping.service.AdminService;
import com.web.shopping.util.MediaUtil;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// �α��� GET
	@GetMapping("/login")
	public void loginGet(String url, Model model) {
		LOGGER.info("get adminLogin() ȣ��");
		model.addAttribute("targetUrl", url); // login.jsp�� url ���� ����
	}

	// �α��� POST
	@PostMapping("/login")
	public String loginPost(AdminVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr,
			HttpSession session) {
		LOGGER.info("post adminLogin()");

		AdminVO avo = adminService.readLogin(vo);
		session = req.getSession();

		if (avo != null && avo.getaPW().equals(vo.getaPW())) {
			session.setAttribute("admin", avo);
			System.out.println("aID : " + avo.getaID());
			System.out.print(avo);
		} else {
			LOGGER.info("result ��� : " + avo);
			session.setAttribute("admin", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/admin/login";
		}
		return "redirect:/admin/main";

	} // loginPost

// ---------------------------------------------------------------------------------

	@GetMapping("/main")
	public void adminMainGet() {
		LOGGER.info("admin Main get() ȣ��");

	}

// ---------------------------------------------------------------------------------

	// �α׾ƿ�
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpSession session) {
		LOGGER.info("admin logout() ȣ��");

		session = req.getSession();
		session.removeAttribute("admin");

		return "redirect:/admin/login";
	}

// ---------------------------------------------------------------------------------

	// ȸ�� ���� Ȯ��
	@GetMapping("/info")
	public void infoGet(String aID, HttpSession session, Model model) {
		LOGGER.info("admin �� ���� ȣ��");
		LOGGER.info("admin info() ȣ�� : aID = " + aID);
		AdminVO vo = adminService.read(aID);
		model.addAttribute("adminVO", vo);

	} // infoGet

// ---------------------------------------------------------------------------------

	// �̹��� ���
	@GetMapping("/display")
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

// ---------------------------------------------------------------------------------
//	// ȸ�� ���� (seller)
//	@GetMapping("seller_detail")
//	public void detailGET(String sID, Model model) {
//		LOGGER.info("detail() ȣ�� : sID = " + sID);
//		SellerVO vo = sellerService.read(sID);
//		model.addAttribute("sellerVO", vo);
//	} // end detailGET
//	
//	
//	// ȸ�� ���� ���� (seller)
//	@GetMapping("seller_info_update")
//	public void sellerInfoUpdateGET(String sID, Model model, HttpServletRequest req) {
//		LOGGER.info("seller update Get() ȣ��");
//		SellerVO vo = sellerService.read(sID);
//		LOGGER.info("seler update vo : " + vo);
//		model.addAttribute("sellerVO", vo);
//	} // end updateGET
//
//	@PostMapping("seller_info_update")
//	public String sellerInfoUpdatePOST(String sID, SellerVO vo, MultipartFile[] files) {
//		LOGGER.info("seller update Post() ȣ��");
//		LOGGER.info("seler update vo : " + vo);
//		LOGGER.info("seller update : sID = " + vo.getsID());
//		SellerVO svo = sellerService.read(sID);
//		LOGGER.info("seller update : sLICENCE = " + svo.getsLICENCE());
//		LOGGER.info("seller update : sBANK = " + svo.getsBANK());
//
//		for (int i = 0; i < files.length; i++) {
//
//			if (i == 0) {
//				if (files[0].getOriginalFilename() != "") {
//					String saveName = vo.getsID() + "_licence_seller_" + files[0].getOriginalFilename();
//					File target = new File(uploadPath, saveName);
//
//					try {
//						FileCopyUtils.copy(files[i].getBytes(), target);
//						LOGGER.info("licence ���� ���� ����");
//
//					} catch (IOException e) {
//						LOGGER.error("licence ���� ���� ����");
//					}
//					vo.setsLICENCE(saveName);
//
//				}
//				if (files[0].getOriginalFilename() == "") {
//					String saveName = svo.getsLICENCE();
//					vo.setsLICENCE(saveName);
//				}
//			}
//
//			if (i == 1) {
//				if (files[1].getOriginalFilename() != "") {
//					String saveName = vo.getsID() + "_bank_seller_" + files[1].getOriginalFilename();
//					File target = new File(uploadPath, saveName);
//
//					try {
//						FileCopyUtils.copy(files[i].getBytes(), target);
//						LOGGER.info("bank ���� ���� ����");
//						vo.setsBANK(saveName);
//					} catch (IOException e) {
//						LOGGER.error("bank ���� ���� ����");
//					}
//					vo.setsBANK(saveName);
//				}
//				if (files[1].getOriginalFilename() == "") {
//					String saveName = svo.getsBANK();
//					vo.setsBANK(saveName);
//				}
//			}
//
//		}
//
//		int result = sellerService.update(vo);
//		if (result == 1) {
//			return "redirect:/admin/seller_detail?sID=" + vo.getsID();
//		} else {
//			return "redirect:/admin/seller_info_update?sID=" + vo.getsID();
//		}
//	} // end updatePOST

// ---------------------------------------------------------------------------------

	
	
// ---------------------------------------------------------------------------------
	
	
} // end AdminController
