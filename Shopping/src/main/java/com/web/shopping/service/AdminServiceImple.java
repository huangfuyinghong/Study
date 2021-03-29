package com.web.shopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.AdminVO;
import com.web.shopping.persistence.AdminDAO;

@Service 
public class AdminServiceImple implements AdminService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(AdminServiceImple.class);
	
	@Autowired
	private AdminDAO adminDao;

	@Override
	public List<AdminVO> read() {
		LOGGER.info("read() 호출");
		return adminDao.select();
	}

	@Override
	public AdminVO read(String aID) {
		LOGGER.info("read() 호출 : aID = " + aID);
		return adminDao.select(aID);
	}

	@Override
	public AdminVO readLogin(AdminVO vo) {
		LOGGER.info("readLogin() 호출 : vo = " + vo);
		return adminDao.selectLogin(vo);
	}

} // end AdminServiceImple
