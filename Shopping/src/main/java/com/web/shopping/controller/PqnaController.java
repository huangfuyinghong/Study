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
import com.web.shopping.domain.PqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.pageutil.PageMaker;
import com.web.shopping.service.PqnaService;

@Controller
@RequestMapping(value ="/pqna")  // url : /shopping/pqna/
public class PqnaController {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(PqnaController.class);
	
	@Autowired
	private PqnaService pqnaService;
	
	@GetMapping("/list")
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
		
		List<PqnaVO> list = pqnaService.read(criteria);
		model.addAttribute("pqnaList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(pqnaService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} //  end list()
	
	@GetMapping("/register")
	public void registerGet() { 
		LOGGER.info("registerGET() 호출");
	} // end registerGet 
	
	@PostMapping("/register")
	public String registerPOST(PqnaVO vo, RedirectAttributes reAttr) { 
		// RedirectAttributes : 재경로 위치에 속성값을 전송하는 객체 
		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());
		int result = pqnaService.create(vo);
		System.out.println();
		// "insert_result"의 키이름을 가진 데이터 전송 
		if(result == 1) { // DB insert 성공
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/pqna/list"; // /bqna/list 결로로 이동(get) 방식
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/pqna/register";
		}
	} // end registerPOST
	
	
	@GetMapping("/detail")
	public void detailGET(int pqID, Model model, @ModelAttribute("page") int page) { 
		LOGGER.info("detail() 호출 : pqID = " + pqID);
		PqnaVO vo = pqnaService.read(pqID);
		model.addAttribute("pqnaVO", vo);
	} // end detailGET
	
	@GetMapping("/update")
	public void updateGET(int pqID, Model model, @ModelAttribute("page") int page) { 
		LOGGER.info("update() 호출 : pqID = " + pqID);
		PqnaVO vo = pqnaService.read(pqID);
		model.addAttribute("pqnaVO", vo);
	} // end updateGET

	@PostMapping("/update")
	public String updatePOST(PqnaVO vo, int page) { 
		LOGGER.info("updatePOST() 호출 : pqID = " + vo.getPqID());
		int result = pqnaService.update(vo);
		if(result == 1) { 
			return "redirect:/pqna/list";
		} else { 
			return "redirect:/pqna/update?pqID=" + vo.getPqID();
		}
	} // end updatePOST
	
	
	@GetMapping("/delete")
	public String delete(int pqID) {
		LOGGER.info("delete() 호출 : pqID = " + pqID);
		int result = pqnaService.delete(pqID);
		if(result == 1) {
			return "redirect:/pqna/list";
		} else { 
			return "redirect:/pqna/detail?pqID=" + pqID;
		}
	} // end delete

} // end PqnaController 
