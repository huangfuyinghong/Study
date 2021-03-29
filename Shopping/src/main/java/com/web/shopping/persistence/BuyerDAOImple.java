package com.web.shopping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;

@Repository
public class BuyerDAOImple implements BuyerDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BuyerDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.BuyerMapper";
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public int insert(BuyerVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	@Override
	public int bidCheck(String bID) {
		System.out.println("===> Mybatis로 idCheck");
		LOGGER.info("bidCheck() 호출");
		int result = sqlSession.selectOne(NAMESPACE + ".bidCheck", bID);
		return result;
	}
	
	@Override
	public List<BuyerVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public BuyerVO select(String bID) {
		LOGGER.info("select() 호출 : bID = " + bID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bID", bID);
	}

	@Override
	public int update(BuyerVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo); 
	}

	@Override
	public void delete(BuyerVO vo) {
		LOGGER.info("delete() 호출");
		sqlSession.delete(NAMESPACE + ".delete", vo);
	}

	@Override
	public BuyerVO selectLogin(BuyerVO vo) {
		LOGGER.info("selectLogin() 호출 : vo = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".select_login", vo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<BuyerVO> select(PageCriteria criteria) {
		LOGGER.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<BuyerVO> select(int bNO) {
		LOGGER.info("select() 호출 : bNO = " + bNO);
//에러는 어떻게 하면 좋을까???		bNO = "%" + bNO + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_bNO", bNO);
	}

	@Override
	public List<BuyerVO> selectByKw(String keyword) {
		LOGGER.info("selectByKw() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_kw", keyword);
	}




} // end BuyerDAOImple
