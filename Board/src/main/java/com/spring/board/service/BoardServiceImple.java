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
//������ �����ӿ�ũ���� ���� ����(Service/Business layer)�� ���۳�Ʈ���� �˷��ִ� ������̼�
public class BoardServiceImple implements BoardService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;

	// �Խñ� �ۼ�  
	@Override
	public int createBoard(BoardVO vo) throws Exception {
		LOGGER.info("createBoard() ȣ��");
		return dao.insertBoard(vo);
	}

	// �Խñ� ��ü ����Ʈ 
	@Override
	public List<BoardVO> readBoard() throws Exception {
		LOGGER.info("readBoard() ��ü����Ʈ ȣ��");
		return dao.selectBoard();
	}

	// �Խ��� ��ȣ�� ���� / �Խñ� ���� Ȯ�� 
	@Override
	public BoardVO readBoard(int bNo) throws Exception {
		LOGGER.info("readBoard() ȣ�� : bNo : " + bNo);
		return dao.selectBoard(bNo);
	}
	
	// �Խñ� ���� 
	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		LOGGER.info("updateBoard() ȣ��");
		return dao.updateBoard(vo);
	}

	// �Խñ� ���� 
	@Override
	public int deleteBoard(int bNo) throws Exception {
		LOGGER.info("delateBoard() ȣ��");
		return dao.deleteBoard(bNo);
	}
	
} // end BoardServiceImple
