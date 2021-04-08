package com.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.BoardVO;
import com.spring.board.persistence.BoardDAO;

@Service 
// @Component
//스프링 프레임워크에게 서비스 계층(Service/Business layer)의 컴퍼넌트임을 알려주는 어노테이션
public class BoardServiceImple implements BoardService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;

	// 게시글 작성  
	@Override
	public int createBoard(BoardVO vo) throws Exception {
		LOGGER.info("createBoard() 호출");
		return dao.insertBoard(vo);
	}

	// 게시글 전체 리스트 
	@Override
	public List<BoardVO> readBoard() throws Exception {
		LOGGER.info("readBoard() 전체리스트 호출");
		return dao.selectBoard();
	}

	// 게시판 번호로 선택 / 게시글 정보 확인 
	@Override
	public BoardVO readBoard(int bNo) throws Exception {
		LOGGER.info("readBoard() 호출 : bNo : " + bNo);
		return dao.selectBoard(bNo);
	}
	
	// 게시글 수정 
	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		LOGGER.info("updateBoard() 호출");
		return dao.updateBoard(vo);
	}

	// 게시글 삭제 
	@Override
	public int deleteBoard(int bNo) throws Exception {
		LOGGER.info("delateBoard() 호출");
		return dao.deleteBoard(bNo);
	}
	
} // end BoardServiceImple
