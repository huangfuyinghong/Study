package com.spring.board.persistence;

import java.util.List;

import com.spring.board.domain.BoardVO;
import com.spring.board.pageutil.PageCriteria;

public interface BoardDAO {
	
	public abstract int insertBoard(BoardVO vo) throws Exception; // �Խñ� �ۼ�

	public abstract List<BoardVO> selectBoard() throws Exception; // ��ü ����Ʈ
	public abstract BoardVO selectBoard(int bNo) throws Exception; // �Խñ� ���� ���� 
	
	public abstract int updateBoard(BoardVO vo) throws Exception; // �Խñ� ���� 
	public abstract int deleteBoard(int bNo) throws Exception; // �Խ��� ����
	
	public abstract int getTotalNumsOfRecords() throws Exception; // ��ü �Խñ� ���� 
	public abstract List<BoardVO> select(PageCriteria criteria); // �Խ��� ������ ���� 
	
} // end BoardDAO 
