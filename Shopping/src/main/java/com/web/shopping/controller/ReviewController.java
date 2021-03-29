package com.web.shopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.ReviewVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.ReviewService;



@Controller
@RequestMapping(value ="/review")  // url : /shopping/review/
public class ReviewController {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/list")
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
		
		List<ReviewVO> list = reviewService.read(criteria);
		model.addAttribute("reviewList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(reviewService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} // end list 
	
	
	@GetMapping("/register")
	public void registerGet() { 
		LOGGER.info("registerGET() ȣ��");
	} // end registerGet 
	
	@PostMapping("/register")
	public String registerPOST(ReviewVO vo, RedirectAttributes reAttr) { 
		// RedirectAttributes : ���� ��ġ�� �Ӽ����� �����ϴ� ��ü 
		LOGGER.info("registerPOST() ȣ��");
		LOGGER.info(vo.toString());
		int result = reviewService.create(vo);
		System.out.println();
		// "insert_result"�� Ű�̸��� ���� ������ ���� 
		if(result == 1) { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/review/list"; // /bqna/list ��η� �̵�(get) ���
		} else { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/review/register";
		}
	} // end registerPOST
	
	@GetMapping("/update")
	public void updateGET(int rID, Model model, @ModelAttribute("page") int page) { 
		LOGGER.info("update() ȣ�� : rID = " + rID);
		ReviewVO vo = reviewService.read(rID);
		model.addAttribute("reviewVO", vo);
	} // end updateGET
	
	@PostMapping("/update")
	public String updatePOST(ReviewVO vo, int page) { 
		LOGGER.info("updatePOST() ȣ�� : rID = " + vo.getrID());
		int result = reviewService.update(vo);
		if(result == 1) { 
			return "redirect:/review/list";
		} else { 
			return "redirect:/review/update?rID=" + vo.getrID();
		}
	} // end updatePOST
	
	@GetMapping("/delete")
	public String delete(int rID) {
		LOGGER.info("delete() ȣ�� : rID = " + rID);
		int result = reviewService.delete(rID);
		if(result == 1) {
			return "redirect:/review/list";
		} else { 
			return "redirect:/review/detail?rID=" + rID;
		}
	} // end delete

} // ReviewController
