package com.web.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.BqnaService;

@Controller
@RequestMapping(value = "/") // url : /shopping/bqna/
public class BqnaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BqnaController.class);

	@Autowired
	private BqnaService bqnaService;
	@Resource(name = "uploadPath")
	private String uploadPath;

	@GetMapping(value = {"admin/buyer_qna_list"})
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

		List<BqnaVO> list = bqnaService.read(criteria);
		model.addAttribute("bqnaList", list);

		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(bqnaService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} // end list()

	// ---------------------------------------------------------------------------------

	@GetMapping(value = {"buyer/bqna_list"})
	public void mylist(@RequestParam("bID") String bqWRITER, Model model, Integer page, Integer perPage, HttpServletRequest req) {
		LOGGER.info("list ȣ��");
		LOGGER.info("page = " + page + ", perPage = " + perPage);
		LOGGER.info("String sqWRITER : " + bqWRITER);

		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) {
			criteria.setNumsPerPage(perPage);
		}

		List<BqnaVO> list = bqnaService.read(criteria);
		List<BqnaVO> mylist = bqnaService.read(bqWRITER);
		model.addAttribute("mybqnaList", mylist);

		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(bqnaService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} // end list()

	// ---------------------------------------------------------------------------------

	
	
	@GetMapping("buyer/bqna_register")
	public void bqnaRegisterGet() {
		LOGGER.info("registerGET() ȣ��");

	} // end registerGet

	@PostMapping("buyer/bqna_register")
	public String bqnaRegisterPOST(BqnaVO vo, MultipartFile[] files, RedirectAttributes reAttr) {
		// RedirectAttributes : ���� ��ġ�� �Ӽ����� �����ϴ� ��ü
		LOGGER.info("registerPOST() ȣ��");
		LOGGER.info(vo.toString());

		for (int i = 0; i < files.length; i++) {
			files[i].getOriginalFilename();
			String saveName = vo.getBqID() + "_qna_buyer_" + files[i].getOriginalFilename();
			File target = new File(uploadPath, saveName);

			try {
				FileCopyUtils.copy(files[i].getBytes(), target);
				LOGGER.info("licence ���� ���� ����");

			} catch (IOException e) {
				LOGGER.error("licence ���� ���� ����");
			}
			vo.setBqFILE(saveName);
		}

		int result = bqnaService.create(vo);
		System.out.println();
		// "insert_result"�� Ű�̸��� ���� ������ ����
		if (result == 1) { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/buyer/bqna_list?bID=" + vo.getBqWRITER(); // /bqna/list ��η� �̵�(get) ���
		} else { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/buyer/bqna_register";
		}
	} // end registerPOST

	// ---------------------------------------------------------------------------------

	@GetMapping(value = { "buyer/bqna_detail", "admin/buyer_qna_detail" })
	public void detailGET(int bqID, Model model, @ModelAttribute("page") int page) {
		LOGGER.info("detail() ȣ�� : bqID = " + bqID);
		BqnaVO vo = bqnaService.read(bqID);
		model.addAttribute("bqnaVO", vo);
	} // end detailGET

	// ---------------------------------------------------------------------------------

	@GetMapping("buyer/bqna_update")
	public void updateGET(int bqID, Model model, @ModelAttribute("page") int page) {
		LOGGER.info("update() ȣ�� : bqID = " + bqID);
		BqnaVO vo = bqnaService.read(bqID);
		model.addAttribute("bqnaVO", vo);
	} // end updateGET

	@PostMapping("buyer/bqna_update")
	public String updatePOST(int bqID, BqnaVO vo, int page, MultipartFile[] files) {
		LOGGER.info("updatePOST() ȣ�� : bqID = " + vo.getBqID());
		BqnaVO bqvo = bqnaService.read(bqID);
		LOGGER.info("sqna update : bqFILE = " + bqvo.getBqFILE());

		for (int i = 0; i < files.length; i++) {
			if (files[i].getOriginalFilename() != "") {
				String saveName = vo.getBqID() + "_qna_buyer_" + files[i].getOriginalFilename();
				File target = new File(uploadPath, saveName);

				try {
					FileCopyUtils.copy(files[i].getBytes(), target);
					LOGGER.info("licence ���� ���� ����");

				} catch (IOException e) {
					LOGGER.error("licence ���� ���� ����");
				}
				vo.setBqFILE(saveName);
			}
			if (files[i].getOriginalFilename() == "") {
				String saveName = bqvo.getBqFILE();
				vo.setBqFILE(saveName);
			}

		}

		int result = bqnaService.update(vo);
		if (result == 1) {
			return "redirect:/buyer/bqna_detail?bqID=" + bqID + "&page=" + page;
		} else {
			return "redirect:/buyer/bqna_update?bqID=" + vo.getBqID();
		}
	} // end updatePOST

	// ---------------------------------------------------------------------------------

	@GetMapping("buyer/bqna_delete")
	public String delete(int bqID, int page, HttpServletRequest req) {
		LOGGER.info("delete() ȣ�� : bqID = " + bqID);
		HttpSession session = req.getSession();
		BuyerVO bvo = (BuyerVO) session.getAttribute("buyer");
		String bID = bvo.getbID();
		LOGGER.info("delete() ȣ�� : bID = " + bID);
		
		
		int result = bqnaService.delete(bqID);
		if (result == 1) {
			return "redirect:/buyer/bqna_list?bID=" + bID;
		} else {
			return "redirect:/buyer/bqna_detail?bqID=" + bqID + "&page=" + page;
		}
	} // end delete
	
	
} // end BqnaController
