package com.spring.board.persistence;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDAO {
	
	public abstract int insertBoard(BoardVO vo) throws Exception; // �Խñ� �ۼ�

	public abstract List<BoardVO> selectBoard() throws Exception; // ��ü ����Ʈ
	public abstract BoardVO selectBoard(int bNo) throws Exception; // �Խ��� ��ȣ�� ���� 
	
	
	
} // end BoardDAO 
