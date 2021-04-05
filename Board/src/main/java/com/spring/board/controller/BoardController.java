package com.spring.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.board.domain.BoardVO;
import com.spring.board.service.BoardService;


@Controller
@RequestMapping(value = "/") // url : /shopping/
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
	}
	
	
} // end BoardController 
