package com.web.shopping.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;

@Repository // @Component
//- ���� ����(Persistence Layer)�� DB ���� ����� ���
//- Spring Component bean���� �����
//- ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//root-context.xml�� bean���� ����ؾ���
//- <context:component-scan ... />

public class SqnaDAOImple implements SqnaDAO {

	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SqnaDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.SqnaMapper";
	
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ� ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
		@Autowired
		private SqlSession sqlSession;
		
	
	@Override
	public List<SqnaVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml�� id�� ��Ī
	}
	@Override
	public SqnaVO select(int sqID) {
		LOGGER.info("select() ȣ�� : sqID = " + sqID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_sqID", sqID);
	}
	@Override
	public int insert(SqnaVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	@Override
	public int update(SqnaVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	@Override
	public int delete(int sqID) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", sqID);
	}
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}
	@Override
	public List<SqnaVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}
	@Override
	public List<SqnaVO> select(String sqWRITER) {
		LOGGER.info("select() ȣ�� : sqWRITER = " + sqWRITER);
		sqWRITER = "%" + sqWRITER + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_sqWRITER", sqWRITER);
	}
	@Override
	public List<SqnaVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_sqTITLE_sqCONTENT", keyword);
	}
	@Override
	public int updateReplyCOUNT(int amount, int sqID) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("sqID", sqID);
		return sqlSession.update(NAMESPACE + ".update_replyCOUNT", args);
	}
	@Override
	public SqnaVO sqnaselect(SqnaVO sqWRITER) {
		LOGGER.info("sqnaselect() ȣ�� : sqWRITER = " + sqWRITER);
		return sqlSession.selectOne(NAMESPACE + ".select_by_mysqWRITER", sqWRITER);
		
	}
	
} // end SqnaDAOImple
