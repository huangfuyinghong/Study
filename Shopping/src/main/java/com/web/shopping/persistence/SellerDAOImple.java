package com.web.shopping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;

@Repository
public class SellerDAOImple implements SellerDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SellerDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.SellerMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(SellerVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int sidCheck(String sID) {
		System.out.println("===> Mybatis�� idCheck");
		LOGGER.info("sidCheck() ȣ��");
		int result = sqlSession.selectOne(NAMESPACE + ".sidCheck", sID);
		return result;
	}

	@Override
	public int snameCheck(String sNAME) {
		LOGGER.info("snameCheck() ȣ��");
		int result = sqlSession.selectOne(NAMESPACE + ".snameCheck", sNAME);
		return result;
	}
	
	@Override
	public List<SellerVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public SellerVO select(String sID) {
		LOGGER.info("select() ȣ�� : sID = " + sID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_sID", sID);
	}

	@Override
	public int update(SellerVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(SellerVO vo) {
		LOGGER.info("delete() ȣ��");
		sqlSession.delete(NAMESPACE + ".delete", vo);
	}

	@Override
	public SellerVO selectLogin(SellerVO vo) {
		LOGGER.info("select() ȣ�� : vo = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".select_login", vo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<SellerVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<SellerVO> select(int sNO) {
		LOGGER.info("select() ȣ�� : sNO = " + sNO);
//������ ��� �ϸ� ������???		sNO = "%" + sNO + "%";
				return sqlSession.selectList(NAMESPACE + ".select_by_sNO", sNO);
	}

	@Override
	public List<SellerVO> selectByKw(String keyword) {
		LOGGER.info("selectByKw() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_kw", keyword);
	}

	
	
} // end SellerDAOImple 
