package com.spring.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository // @Component
//- ���� ����(Persistence Layer)�� DB ���� ����� ���
//- Spring Component bean���� �����
//- ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//root-context.xml�� bean���� ����ؾ���
//- <context:component-scan ... />

public class BoardDAOImple implements BoardDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE = 
			"com.spring.board.BoardMapper";
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ�
		// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;
	
	// �Խñ� �ۼ� 
	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		LOGGER.info("insertBoard() ȣ��");
		return sqlSession.insert(NAMESPACE + ".board_insert", vo);
	}

	// �Խñ� ��ü ����Ʈ 
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		LOGGER.info("selectBoard() ��ü ����Ʈ ȣ��");
		return sqlSession.selectList(NAMESPACE + ".board_select_all");
	}

	// �Խ��� ��ȣ�� ����
	@Override
	public BoardVO selectBoard(int bNo) throws Exception {
		LOGGER.info("selectBoard() ȣ�� : bNo = " + bNo);
		return sqlSession.selectOne(NAMESPACE + ".board_select_all", bNo);
	}

	
	
} // end BoardDAOImple
