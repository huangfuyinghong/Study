package com.spring.board.persistence;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDAO {
	
	public abstract int insertBoard(BoardVO vo) throws Exception; // 게시글 작성

	public abstract List<BoardVO> selectBoard() throws Exception; // 전체 리스트
	public abstract BoardVO selectBoard(int bNo) throws Exception; // 게시판 번호로 선택 
	
	
	
} // end BoardDAO 
