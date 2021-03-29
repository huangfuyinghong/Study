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

import com.web.shopping.domain.SellerVO;
import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.SqnaService;

@Controller
@RequestMapping(value ="/")  // url : /shopping/
public class SqnaController {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SqnaController.class);

	@Autowired
	private SqnaService sqnaService;
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	
	@GetMapping(value={"admin/seller_qna_list"})
	public void sqnaList( Model model, Integer page, Integer perPage) {
		
		LOGGER.info("list 호출");
		LOGGER.info("page = " + page + ", perpage = " + perPage);
		
		// Paging 처리 
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		List<SqnaVO> list = sqnaService.read(criteria);
		model.addAttribute("sqnaList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(sqnaService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} // end list()

	
// ---------------------------------------------------------------------------------
	
	@GetMapping(value={"seller/sqna_list"})
	public void mysqnaList(@RequestParam("sID") String sqWRITER, Model model, Integer page, Integer perPage,  HttpServletRequest req) {
		
		LOGGER.info("list 호출");
		LOGGER.info("page = " + page + ", perpage = " + perPage);
		LOGGER.info("@RequestParam(\"sID\") String sqWRITER : " + sqWRITER);
	
		
		// Paging 처리 
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		List<SqnaVO> list = sqnaService.read(criteria);
		List<SqnaVO> mylist = sqnaService.read(sqWRITER);
		model.addAttribute("mysqnaList", mylist);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(sqnaService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		model.addAttribute("sqWRITER", sqWRITER);
	} // end list()

	
// ---------------------------------------------------------------------------------
	
	@GetMapping(value={"seller/sqna_detail", "admin/seller_qna_detail"})
	public void sqnaDetailGET(int sqID, Model model, @ModelAttribute("page") int page) { 
		LOGGER.info("detail() 호출 : sqID = " + sqID);
		SqnaVO vo = sqnaService.read(sqID);
		model.addAttribute("sqnaVO", vo);
	} // end detailGET

// ---------------------------------------------------------------------------------
	
	@GetMapping("seller/sqna_update")
	public void updateGET(int sqID, Model model, @ModelAttribute("page") int page) { 
		LOGGER.info("update() 호출 : sqID = " + sqID);
		SqnaVO vo = sqnaService.read(sqID);
		model.addAttribute("sqnaVO", vo);
	} // end updateGET
	
	@PostMapping("seller/sqna_update")
	public String updatePOST(int sqID, SqnaVO vo, int page, MultipartFile[] files) { 
		LOGGER.info("updatePOST() 호출 : sqID = " + vo.getSqID());
		SqnaVO sqvo = sqnaService.read(sqID);
		LOGGER.info("sqna update : sqFILE = " + sqvo.getSqFILE());
		
		for (int i = 0; i < files.length; i++) {
			if(files[i].getOriginalFilename() != "") {
			String saveName = vo.getSqID() + "_qna_seller_" + files[i].getOriginalFilename();
			File target = new File(uploadPath, saveName);

			try {
				FileCopyUtils.copy(files[i].getBytes(), target);
				LOGGER.info("licence 파일 저장 성공");

			} catch (IOException e) {
				LOGGER.error("licence 파일 저장 실패");
			}
			vo.setSqFILE(saveName);
			}
			if(files[i].getOriginalFilename() == ""){ 
				String saveName = sqvo.getSqFILE();
				vo.setSqFILE(saveName);
			}
		
		}
		
		int result = sqnaService.update(vo);
		if(result == 1) { 
			return "redirect:/seller/sqna_detail?sqID=" + sqID + "&page=" + page;
		} else { 
			return "redirect:/seller/sqna_update?sqID=" + vo.getSqID();
		}
	} // end updatePOST

// ---------------------------------------------------------------------------------
	
	@GetMapping("seller/sqna_delete")
	public String delete(int sqID, int page, HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		String sID = (String) session.getAttribute("sID");

		HttpSession session = req.getSession();
		LOGGER.info("delete() 호출 : sqID = " + sqID);
		SellerVO svo = (SellerVO) session.getAttribute("seller");
		String sID = svo.getsID();
		LOGGER.info("delete() 호출 : sID = " + sID);
		
		int result = sqnaService.delete(sqID);
		if(result == 1) {
			return "redirect:/seller/sqna_list?sID=" + sID;
		} else { 
			return "redirect:/seller/sqna_detail?sqID=" + sqID + "&page=" + page;
		}
	} // end delete
	
	// ---------------------------------------------------------------------------------
	
	@GetMapping("seller/sqna_register")
	public void sqnaRegisterGet() {
		LOGGER.info("registerGET() 호출");
	} // end registerGet
	
	// ---------------------------------------------------------------------------------

	@PostMapping("seller/sqna_register")
	public String sqnaRegisterPOST(SqnaVO vo, MultipartFile[] files, RedirectAttributes reAttr) {
		// RedirectAttributes : 재경로 위치에 속성값을 전송하는 객체
		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());

		for (int i = 0; i < files.length; i++) {
			files[i].getOriginalFilename();
			String saveName = vo.getSqID() + "_qna_seller_" + files[i].getOriginalFilename();
			File target = new File(uploadPath, saveName);

			try {
				FileCopyUtils.copy(files[i].getBytes(), target);
				LOGGER.info("licence 파일 저장 성공");

			} catch (IOException e) {
				LOGGER.error("licence 파일 저장 실패");
			}
			vo.setSqFILE(saveName);
		}

		int result = sqnaService.create(vo);
		System.out.println();
		// "insert_result"의 키이름을 가진 데이터 전송
		if (result == 1) { // DB insert 성공
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/seller/sqna_list?sID=" + vo.getSqWRITER(); // /bqna/list 결로로 이동(get) 방식
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/seller/sqna_register";
		}
	} // end registerPOST
	
} // end SqnaController
