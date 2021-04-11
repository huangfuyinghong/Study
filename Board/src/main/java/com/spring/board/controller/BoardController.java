package com.spring.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.domain.BoardVO;
import com.spring.board.pageutil.PageCriteria;
import com.spring.board.pageutil.PageMaker;
import com.spring.board.service.BoardService;


@Controller
@RequestMapping(value = "/") // url : /board/
public class BoardController {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	
	// �Խ��� ��ü ����Ʈ  / ����¡ �߰�   
	@GetMapping("board/list")
	public void list(Model model, Integer page, Integer perPage) throws Exception {
		LOGGER.info("board list ȣ��");
		LOGGER.info("page = " + page + ", perPage = " + perPage); 
		
		// paging ó�� 
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) {
			criteria.setNumsPerPage(perPage);
		}
		
		// ��ü ����Ʈ���� ���� �������� ǥ�� �� �Խ���  
		List<BoardVO> list = boardService.readBoard(criteria);
		model.addAttribute("boardList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(boardService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
	} // end list 
	
	// ---------------------------------------------------------
	
	// �Խñ� �ۼ� 
	@GetMapping("board/register")
	public void getRegister() throws Exception {
		LOGGER.info("board register GET ȣ��");
		
	} // end getRegister 
	
	@PostMapping("board/register")
	public String postRegister(BoardVO vo, RedirectAttributes reAttr) throws Exception {
		LOGGER.info("board register POST ȣ��");
		
		int result = boardService.createBoard(vo);
		// "insert_result"�� Ű�̸��� ���� ������ ����
		if (result == 1) { // DB insert ���� 
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/board/list";
		} else { 
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/board/register";
		}
		
	} // end postRegister 
	
	// ---------------------------------------------------------
	
	// �Խù� �� �˻�  
	@GetMapping("board/info")
	public void GetInfo(Model model, @RequestParam("bNo") int bNo ) throws Exception { 
		LOGGER.info("board info ȣ�� : bNo = " + bNo);
		
		BoardVO vo = boardService.readBoard(bNo);
		model.addAttribute("boardVO", vo);
	} // end GetInfo
	
	// ---------------------------------------------------------

	// �Խñ� ���� 
	@GetMapping("board/update")
	public void GetUpdate(Model model, @RequestParam("bNo") int bNo) throws Exception {
		LOGGER.info("Board update GET ȣ�� : bNo =" + bNo);
		
		BoardVO vo = boardService.readBoard(bNo);
		model.addAttribute("boardVO", vo);
		
	} // end GetUpdate


	@PostMapping("board/update")
	public String postUpdate(BoardVO vo) throws Exception {
		LOGGER.info("Board update POST ȣ�� : vo =" + vo);
		
		int result = boardService.updateBoard(vo);
		if (result == 1) {
			return "redirect:/board/info?bNo=" + vo.getbNo();
		} else { 
			return "redirect:/board/update?bNo=" + vo.getbNo();
		}
	}
	
	// ---------------------------------------------------------
	
	// �Խñ� ���� 
	@GetMapping("board/delete")
	public String getDelete(@RequestParam("bNo") int bNo) throws Exception {
		LOGGER.info("delete() ȣ�� : bNo = : " + bNo);
		
		int result = boardService.deleteBoard(bNo);
		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/info?bNo=" + bNo;
		}
	} // end getDelete

	// ---------------------------------------------------------
	
	


} // end BoardController 
