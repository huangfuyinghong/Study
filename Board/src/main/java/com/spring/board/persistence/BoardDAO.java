package com.spring.board.persistence;

import java.util.List;

import com.spring.board.domain.BoardVO;
import com.spring.board.pageutil.PageCriteria;

public interface BoardDAO {
	
	public abstract int insertBoard(BoardVO vo) throws Exception; // 게시글 작성

	public abstract List<BoardVO> selectBoard() throws Exception; // 전체 리스트
	public abstract BoardVO selectBoard(int bNo) throws Exception; // 게시글 정보 보기 
	
	public abstract int updateBoard(BoardVO vo) throws Exception; // 게시글 수정 
	public abstract int deleteBoard(int bNo) throws Exception; // 게시판 삭제
	
	public abstract int getTotalNumsOfRecords() throws Exception; // 전체 게시글 수량 
	public abstract List<BoardVO> select(PageCriteria criteria); // 게시판 페이지 설정 
	
} // end BoardDAO 
