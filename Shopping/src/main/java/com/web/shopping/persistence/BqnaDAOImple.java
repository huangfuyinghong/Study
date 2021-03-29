package com.web.shopping.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.pageutil.PageCriteria;


@Repository // @Component
//- 영속 계층(Persistence Layer)의 DB 관련 기능을 담당
//- Spring Component bean으로 등록함
//- 스프링 프레임워크가 bean을 생성하기 위해서는
//root-context.xml에 bean으로 등록해야함
//- <context:component-scan ... />

public class BqnaDAOImple implements BqnaDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BqnaDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.BqnaMapper";
	
	// MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<BqnaVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml의 id와 매칭
	}

	@Override
	public BqnaVO select(int bqID) {
		LOGGER.info("select() 호출 : bqID = " + bqID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bqID", bqID);
	}

	@Override
	public int insert(BqnaVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(BqnaVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int bqID) {
		LOGGER.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", bqID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<BqnaVO> select(PageCriteria criteria) {
		LOGGER.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<BqnaVO> select(String bqWRITER) {
		LOGGER.info("select() 호출 : bqWRITER = " + bqWRITER);
		bqWRITER = "%" + bqWRITER + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_bqWRITER", bqWRITER);
	}

	@Override
	public List<BqnaVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_bqTITLE_bqCONTENT", keyword);
	}

	@Override
	public int updateReplyCOUNT(int amount, int bqID) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("bqID", bqID);
		return sqlSession.update(NAMESPACE + ".update_replyCOUNT", args);
	}

	
} // end BqnaDAOImple
