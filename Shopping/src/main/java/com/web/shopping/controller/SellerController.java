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

	// �α���
	@GetMapping("seller/login")
	public void loginGet(String url, Model model) {
		LOGGER.info("seller loginGet() ȣ��");
	} // end loginGet

	@PostMapping("seller/login")
	public String loginPost(SellerVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr,
			HttpSession session) {
		LOGGER.info("seller loginPost() ȣ��");

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
			LOGGER.info("result ��� : " + svo);
			session.setAttribute("seller", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/seller/login";
		}
		return "redirect:/seller/main";
	} // end loginPost

// ---------------------------------------------------------------------------------

	// �α׾ƿ�
	@GetMapping("seller/logout")
	public String sellerLogout(HttpServletRequest req, HttpSession session) {
		LOGGER.info("sellerLogout() ȣ��");

		session = req.getSession();
		session.removeAttribute("seller");
		

		return "redirect:/seller/login";
	} // end logout

// ---------------------------------------------------------------------------------

	// ȸ������ get
	@GetMapping("seller_register")
	public void registerGet() {
		LOGGER.info("seller registerGet() ȣ��");
		LOGGER.info("uploadGet() ȣ�� : " + uploadPath);
		LOGGER.info("uploadAjaxGET() ȣ��");
	}

	// ȸ������ post
	@PostMapping("seller_register")
	public String registerPost(SellerVO vo, MultipartFile[] files, Model model) {
		LOGGER.info("seller registerPost() ȣ��");

		for (int i = 0; i < files.length; i++) {

			files[i].getOriginalFilename();
			if (i == 0) {
				String saveName = vo.getsID() + "_licence_seller_" + files[0].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("licence ���� ���� ����");

				} catch (IOException e) {
					LOGGER.error("licence ���� ���� ����");
				}
				vo.setsLICENCE(saveName);
			}

			if (i == 1) {
				String saveName = vo.getsID() + "_bank_seller_" + files[1].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("bank ���� ���� ����");

				} catch (IOException e) {
					LOGGER.error("bank ���� ���� ����");
				}
				vo.setsBANK(saveName);
			}
		}
		// ȸ������ �� ��й�ȣ ��ȣȭ �ڵ� 
		String bPW = passwordEncoder.encode(vo.getsPW());
		vo.setsPW(bPW);
		 
		int result = sellerService.create(vo);
//		int count = sellerService.sidCheck(vo.getsID());

		if (result == 1) { // DB insert ����
			return "redirect:/seller/login";
		} else { // DB insert ����
			return "redirect:/seller/register";
		}
	}

// ---------------------------------------------------------------------------------

	// ȸ�� ���� ( ������ )
	@GetMapping("admin/seller_detail")
	public void detailGET(String sID, Model model) {
		LOGGER.info("detail() ȣ�� : sID = " + sID);
		SellerVO vo = sellerService.read(sID);
		model.addAttribute("sellerVO", vo);
	} // end detailGET

	// ȸ�� ���� ���� (admin)
	@GetMapping("admin/seller_info_update")
	public void sellerInfoUpdateGET(String sID, Model model, HttpServletRequest req) {
		LOGGER.info("seller update Get() ȣ��");
		SellerVO vo = sellerService.read(sID);
		LOGGER.info("seler update vo : " + vo);
		model.addAttribute("sellerVO", vo);
	} // end updateGET

	@PostMapping("admin/seller_info_update")
	public String sellerInfoUpdatePOST(String sID, SellerVO vo, MultipartFile[] files) {
		LOGGER.info("seller update Post() ȣ��");
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
						LOGGER.info("licence ���� ���� ����");

					} catch (IOException e) {
						LOGGER.error("licence ���� ���� ����");
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
						LOGGER.info("bank ���� ���� ����");
						vo.setsBANK(saveName);
					} catch (IOException e) {
						LOGGER.error("bank ���� ���� ����");
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

	// ȸ�� ���� (seller)
	@GetMapping("seller/info")
	public void infoGET(String sID, Model model, HttpServletRequest req) {
		LOGGER.info("seller �� ���� ȣ��");
		// HttpSession session = req.getSession();
//		String sID = (String) session.getAttribute("sID");
		LOGGER.info("seller info() ȣ�� : sID = " + sID);
		SellerVO vo = sellerService.read(sID);
		model.addAttribute("sellerVO", vo);
	} // end infoGET

// ---------------------------------------------------------------------------------

	// ȸ�� ���� ���� (seller)
	@GetMapping("seller/update")
	public void updateGET(String sID, Model model, HttpServletRequest req) {
		LOGGER.info("seller update Get() ȣ��");
		SellerVO vo = sellerService.read(sID);
		LOGGER.info("seler update vo : " + vo);
		model.addAttribute("sellerVO", vo);
	} // end updateGET

	@PostMapping("seller/update")
	public String updatePOST(String sID, SellerVO vo, MultipartFile[] files) {
		LOGGER.info("seller update Post() ȣ��");
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
						LOGGER.info("licence ���� ���� ����");

					} catch (IOException e) {
						LOGGER.error("licence ���� ���� ����");
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
						LOGGER.info("bank ���� ���� ����");
						vo.setsBANK(saveName);
					} catch (IOException e) {
						LOGGER.error("bank ���� ���� ����");
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

	// ȸ�� Ż��
	@GetMapping("seller/delete")
	public void delete() {
		LOGGER.info("seller delete ȣ��()");
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
		LOGGER.info("seller main ������ ȣ��()");
	}

// ---------------------------------------------------------------------------------

	// seller ��ü ����Ʈ
	@GetMapping(value = { "seller/list", "admin/seller_list" })
	public void list(Model model, Integer page, Integer perPage) {
		LOGGER.info("seller list ȣ��");
		LOGGER.info("page = " + page + ", perPage = " + perPage);

		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) {
			criteria.setNumsPerPage(perPage);
		}

		List<SellerVO> list = sellerService.read(criteria);
//		for(SellerVO vo : list) { // ��ü����Ʈ ��������  
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

	// seller id �ߺ� üũ
	@PostMapping(value = "seller/sidCheck")
	@ResponseBody // @ResponseBody ������ ���� json�����͸� �ڹ� ��ü�� �����ϴ� ������̼�
	public int sidCheck(@RequestBody String sID) { // @RequestBody �ڹ� ��ü�� HTTP ���� body�� �����ϱ� ���� ���

		int count = 0;
		count = sellerService.sidCheck(sID);
		return count;
	}

// ---------------------------------------------------------------------------------

	// seller name(��ȣ��) �ߺ� üũ
	@PostMapping(value = "seller/snameCheck")
	@ResponseBody
	public int snameCheck(@RequestBody String sNAME) {

		int count = 0;
		count = sellerService.snameCheck(sNAME);
		return count;
	}

// ---------------------------------------------------------------------------------

	// �̹��� ���
	@GetMapping("seller/display")
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
} // end SellerController
