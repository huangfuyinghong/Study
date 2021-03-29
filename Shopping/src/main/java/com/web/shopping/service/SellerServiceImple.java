package com.web.shopping.service;

import java.util.List;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.SellerDAO;

@Service
public class SellerServiceImple implements SellerService{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SellerServiceImple.class);
	
	@Autowired
	private SellerDAO dao;
	@Inject
	PasswordEncoder passwordEncoder;

	@Override
	public int create(SellerVO vo) {
		LOGGER.info("create() 호출");
		// 회원가입 시 비밀번호 암호화 코드  
		String sPW = passwordEncoder.encode(vo.getsPW());
		vo.setsPW(sPW);
		
		return dao.insert(vo);
	}
	
	@Override
	public int sidCheck(String sID) {
		LOGGER.info("sidCheck() 호출");
		return dao.sidCheck(sID);
	}

	@Override
	public int snameCheck(String sNAME) {
		LOGGER.info("snameCheck() 호출");
		return dao.snameCheck(sNAME);
	}

	@Override
	public List<SellerVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}

	@Override
	public SellerVO read(String sID) {
		LOGGER.info("read() 호출 : sID = " + sID);
		return dao.select(sID);
	}

	@Override
	public int update(SellerVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public void delete(SellerVO vo) {
		LOGGER.info("delete() 호출");
		dao.delete(vo);
	}

	@Override
	public SellerVO readLogin(SellerVO vo) {
		LOGGER.info("readLogin() 호출 : vo = " + vo);
		return dao.selectLogin(vo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<SellerVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}


	
} // end SellerServiceImple
