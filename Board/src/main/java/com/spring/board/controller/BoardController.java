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
import com.spring.board.service.BoardService;


@Controller
@RequestMapping(value = "/") // url : /board/
public class BoardController {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	
	// 게시판 전체 리스트 
	@GetMapping("board/list")
	public void list(Model model) throws Exception {
		LOGGER.info("board list 호출");
		
		List<BoardVO> list = boardService.readBoard();
		model.addAttribute("boardList", list);
		
	} // end list 
	
	// ---------------------------------------------------------
	
	// 게시글 작성 
	@GetMapping("board/register")
	public void getRegister() throws Exception {
		LOGGER.info("board register GET 호출");
		
	} // end getRegister 
	
	@PostMapping("board/register")
	public String postRegister(BoardVO vo, RedirectAttributes reAttr) throws Exception {
		LOGGER.info("board register POST 호출");
		
		int result = boardService.createBoard(vo);
		// "insert_result"의 키이름을 가진 데이터 전송
		if (result == 1) { // DB insert 성공 
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/board/list";
		} else { 
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/board/register";
		}
		
	} // end postRegister 
	
	// ---------------------------------------------------------
	
	// 게시물 상세 검색  
	@GetMapping("board/info")
	public void GetInfo(Model model, @RequestParam("bNo") int bNo ) throws Exception { 
		LOGGER.info("board info 호출 : bNo = " + bNo);
		
		BoardVO vo = boardService.readBoard(bNo);
		model.addAttribute("boardVO", vo);
	} // end GetInfo
	
	// ---------------------------------------------------------

	// 게시글 수정 
	@GetMapping("board/update")
	public void GetUpdate(Model model, @RequestParam("bNo") int bNo) throws Exception {
		LOGGER.info("Board update GET 호출 : bNo =" + bNo);
		
		BoardVO vo = boardService.readBoard(bNo);
		model.addAttribute("boardVO", vo);
		
	} // end GetUpdate


	@PostMapping("board/update")
	public String postUpdate(BoardVO vo) throws Exception {
		LOGGER.info("Board update POST 호출 : vo =" + vo);
		
		int result = boardService.updateBoard(vo);
		if (result == 1) {
			return "redirect:/board/info?bNo=" + vo.getbNo();
		} else { 
			return "redirect:/board/update?bNo=" + vo.getbNo();
		}
	}
	
	// ---------------------------------------------------------
	
	// 게시글 삭제 
	@GetMapping("board/delete")
	public String getDelete(@RequestParam("bNo") int bNo) throws Exception {
		LOGGER.info("delete() 호출 : bNo = : " + bNo);
		
		int result = boardService.deleteBoard(bNo);
		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/info?bNo=" + bNo;
		}
	} // end getDelete




} // end BoardController 
