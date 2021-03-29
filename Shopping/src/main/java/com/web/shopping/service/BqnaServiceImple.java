package com.web.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.BqnaDAO;


@Service // @Component
//스프링 프레임워크에게 서비스 계층(Service/Business layer)의 컴퍼넌트임을 알려주는 어노테이션

public class BqnaServiceImple implements BqnaService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BqnaServiceImple.class);
	
	@Autowired
	private BqnaDAO dao;

	@Override
	public List<BqnaVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}

	@Override
	public BqnaVO read(int bqID) {
		LOGGER.info("read() 호출 : bqID = " + bqID);
		return dao.select(bqID);
	}

	@Override
	public int create(BqnaVO vo) {
		LOGGER.info("create() 호출");
		return dao.insert(vo);
	}

	@Override
	public int update(BqnaVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int bqID) {
		LOGGER.info("delete() 호출");
		return dao.delete(bqID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<BqnaVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}

	@Override
	public List<BqnaVO> read(String bqWRITER) {
		LOGGER.info("read() 호출 : bqWRITER = " + bqWRITER);
		return dao.select(bqWRITER);
	}

} // end BqnaServiceImple
