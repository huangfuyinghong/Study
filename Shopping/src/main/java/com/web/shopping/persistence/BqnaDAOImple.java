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
//- ���� ����(Persistence Layer)�� DB ���� ����� ���
//- Spring Component bean���� �����
//- ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//root-context.xml�� bean���� ����ؾ���
//- <context:component-scan ... />

public class BqnaDAOImple implements BqnaDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BqnaDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.BqnaMapper";
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<BqnaVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml�� id�� ��Ī
	}

	@Override
	public BqnaVO select(int bqID) {
		LOGGER.info("select() ȣ�� : bqID = " + bqID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bqID", bqID);
	}

	@Override
	public int insert(BqnaVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(BqnaVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int bqID) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", bqID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<BqnaVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<BqnaVO> select(String bqWRITER) {
		LOGGER.info("select() ȣ�� : bqWRITER = " + bqWRITER);
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
