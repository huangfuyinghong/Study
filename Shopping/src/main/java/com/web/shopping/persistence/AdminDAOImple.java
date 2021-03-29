package com.web.shopping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.AdminVO;

@Repository
public class AdminDAOImple implements AdminDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(AdminDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.AdminMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AdminVO> select() {
		LOGGER.info("read() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	@Override
	public AdminVO select(String aID) {
		LOGGER.info("read() 호출 : aID = " + aID);
		return sqlSession.selectOne(NAMESPACE + ".select_aID", aID);
	}
	@Override
	public AdminVO selectLogin(AdminVO vo) {
		LOGGER.info("select 호출() : vo = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".select_login", vo);
	}
	

	
	
}// end AdminDAOImple
