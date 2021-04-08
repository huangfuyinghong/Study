package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

// CRUD(CREAD, READ, UPDATE, DELETE)
public interface BoardService {

	public abstract int createBoard(BoardVO vo) throws Exception; // �Խñ� �ۼ�
	public abstract List<BoardVO> readBoard() throws Exception; // �Խñ� ��ü ����Ʈ
	public abstract BoardVO readBoard(int bNo) throws Exception; // �Խ��� ��ȣ�� ���� / �Խñ� Ȯ��
	public abstract int updateBoard(BoardVO vo) throws Exception; // �Խñ� ����
	public abstract int deleteBoard(int bNo) throws Exception; // �Խñ� ���� 
} // end BoardService
