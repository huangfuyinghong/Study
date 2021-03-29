package com.web.shopping.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.ReviewVO;
import com.web.shopping.pageutil.PageCriteria;

@Repository // @Component
//- ���� ����(Persistence Layer)�� DB ���� ����� ���
//- Spring Component bean���� �����
//- ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//root-context.xml�� bean���� ����ؾ���
//- <context:component-scan ... />

public class ReviewDAOImple implements ReviewDAO{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.ReviewMapper";
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ� ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReviewVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml�� id�� ��Ī
	}

	@Override
	public ReviewVO select(int rID) {
		LOGGER.info("select() ȣ�� : rID = " + rID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_rID", rID);
	}

	@Override
	public int insert(ReviewVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(ReviewVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int rID) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", rID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<ReviewVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<ReviewVO> select(String rWRITER) {
		LOGGER.info("select() ȣ�� : rWRITER = " + rWRITER);
		rWRITER = "%" + rWRITER + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_rWRITER", rWRITER);
	}

	@Override
	public List<ReviewVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_rTITLE_rCONTENT", keyword);
	}

	@Override
	public int updateReplyCount(int amount, int rID) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("rID", rID);
		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}	

} // end ReviewDAOImple
