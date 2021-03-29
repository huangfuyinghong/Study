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
		LOGGER.info("create() ȣ��");
		// ȸ������ �� ��й�ȣ ��ȣȭ �ڵ�  
		String sPW = passwordEncoder.encode(vo.getsPW());
		vo.setsPW(sPW);
		
		return dao.insert(vo);
	}
	
	@Override
	public int sidCheck(String sID) {
		LOGGER.info("sidCheck() ȣ��");
		return dao.sidCheck(sID);
	}

	@Override
	public int snameCheck(String sNAME) {
		LOGGER.info("snameCheck() ȣ��");
		return dao.snameCheck(sNAME);
	}

	@Override
	public List<SellerVO> read() {
		LOGGER.info("read() ȣ��");
		return dao.select();
	}

	@Override
	public SellerVO read(String sID) {
		LOGGER.info("read() ȣ�� : sID = " + sID);
		return dao.select(sID);
	}

	@Override
	public int update(SellerVO vo) {
		LOGGER.info("update() ȣ��");
		return dao.update(vo);
	}

	@Override
	public void delete(SellerVO vo) {
		LOGGER.info("delete() ȣ��");
		dao.delete(vo);
	}

	@Override
	public SellerVO readLogin(SellerVO vo) {
		LOGGER.info("readLogin() ȣ�� : vo = " + vo);
		return dao.selectLogin(vo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<SellerVO> read(PageCriteria criteria) {
		LOGGER.info("read() ȣ�� : page = " + criteria.getPage());
		return dao.select(criteria);
	}


	
} // end SellerServiceImple
