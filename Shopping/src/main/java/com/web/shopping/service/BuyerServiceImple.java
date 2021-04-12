package com.web.shopping.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.BuyerDAO;

@Service
public class BuyerServiceImple implements BuyerService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BuyerServiceImple.class);
	
	@Autowired
	private BuyerDAO dao;
	@Inject
	PasswordEncoder passwordEncoder;

	@Override
	public int create(BuyerVO vo) {
		LOGGER.info("create() 호출");
		// 회원가입 시 비밀번호 암호화 코드
//		String bPW = passwordEncoder.encode(vo.getbPW());
//		vo.setbPW(bPW);
		return dao.insert(vo);
	}
	
	@Override
	public int bidCheck(String bID) {
		LOGGER.info("bidCheck() 호출");
		return dao.bidCheck(bID);
	}


	@Override
	public List<BuyerVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}

	@Override
	public BuyerVO read(String bID) {
		LOGGER.info("read() 호출 : bID = " + bID);
		return dao.select(bID);
	}

	@Override
	public int update(BuyerVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public void delete(BuyerVO vo) {
		LOGGER.info("delete() 호출");
		dao.delete(vo);
	}

	@Override
	public BuyerVO readLogin(BuyerVO vo) {
		LOGGER.info("readLogin() 호출 : bID = " + vo);
		return dao.selectLogin(vo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<BuyerVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}


	
	
} // end BuyerServiceImple
