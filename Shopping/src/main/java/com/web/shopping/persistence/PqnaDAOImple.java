package com.web.shopping.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.PqnaVO;
import com.web.shopping.pageutil.PageCriteria;

@Repository // @Component
//- ���� ����(Persistence Layer)�� DB ���� ����� ���
//- Spring Component bean���� �����
//- ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//root-context.xml�� bean���� ����ؾ���
//- <context:component-scan ... />

public class PqnaDAOImple implements PqnaDAO {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(PqnaDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.PqnaMapper";
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ� ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PqnaVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml�� id�� ��Ī
	}

	@Override
	public PqnaVO select(int pqID) {
		LOGGER.info("select() ȣ�� : pqID = " + pqID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_pqID", pqID);
	}

	@Override
	public int insert(PqnaVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(PqnaVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int pqID) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", pqID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<PqnaVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<PqnaVO> select(String pqWRITER) {
		LOGGER.info("select() ȣ�� : pqWRITER = " + pqWRITER);
		pqWRITER = "%" + pqWRITER + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_pqWRITER", pqWRITER);
	}

	@Override
	public List<PqnaVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_pqTITLE_pqCONTENT", keyword);
	}

	@Override
	public int updateReplyCOUNT(int amount, int pqID) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("pqID", pqID);
		return sqlSession.update(NAMESPACE + ".update_replyCOUNT", args);
	}
	
	

} // end PqnaDAOImple
