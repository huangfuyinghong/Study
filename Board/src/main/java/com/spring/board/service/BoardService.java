package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;
import com.spring.board.pageutil.PageCriteria;

// CRUD(CREAD, READ, UPDATE, DELETE)
public interface BoardService {

	public abstract int createBoard(BoardVO vo) throws Exception; // 게시글 작성
	public abstract List<BoardVO> readBoard() throws Exception; // 게시글 전체 리스트
	public abstract BoardVO readBoard(int bNo) throws Exception; // 게시판 번호로 선택 / 게시글 확인
	public abstract int updateBoard(BoardVO vo) throws Exception; // 게시글 수정
	public abstract int deleteBoard(int bNo) throws Exception; // 게시글 삭제 
	
	public abstract int getTotalNumsOfRecords() throws Exception; // 전체 게시글 수량 
	public abstract List<BoardVO> readBoard(PageCriteria criteria); // // 게시판 페이지 설정

} // end BoardService
