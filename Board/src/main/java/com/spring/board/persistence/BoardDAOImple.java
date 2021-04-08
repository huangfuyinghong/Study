package com.spring.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository // @Component
//- 영속 계층(Persistence Layer)의 DB 관련 기능을 담당
//- Spring Component bean으로 등록함
//- 스프링 프레임워크가 bean을 생성하기 위해서는
//root-context.xml에 bean으로 등록해야함
//- <context:component-scan ... />

public class BoardDAOImple implements BoardDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE = 
			"com.spring.board.BoardMapper";
	
	// MyBatis의 SqlSession을 사용하기 위해서
		// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;
	
	// 게시글 작성 
	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		LOGGER.info("insertBoard() 호출");
		return sqlSession.insert(NAMESPACE + ".board_insert", vo);
	}

	// 게시글 전체 리스트 
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		LOGGER.info("selectBoard() 전체 리스트 호출");
		return sqlSession.selectList(NAMESPACE + ".board_select_all");
	}

	// 게시글 정보 보기 
	@Override
	public BoardVO selectBoard(int bNo) throws Exception {
		LOGGER.info("selectBoard() 호출 : bNo = " + bNo);
		return sqlSession.selectOne(NAMESPACE + ".board_select_bNo", bNo);
	}

	// 게시글 수정  
	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		LOGGER.info("updateBoard() 호출 : vo = " + vo);
		return sqlSession.update(NAMESPACE + ".board_update", vo);
	}

	// 게시물 삭제 
	@Override
	public int deleteBoard(int bNo) throws Exception {
		LOGGER.info("deleteBoard() 호출");
		return sqlSession.delete(NAMESPACE + ".board_delete", bNo);
	}

	
	
} // end BoardDAOImple
