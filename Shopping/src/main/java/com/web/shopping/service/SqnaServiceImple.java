package com.web.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.SqnaDAO;


@Service 
public class SqnaServiceImple implements SqnaService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SqnaServiceImple.class);
	
	
	@Autowired
	private SqnaDAO dao;


	@Override
	public List<SqnaVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}


	@Override
	public SqnaVO read(int sqID) {
		LOGGER.info("read() 호출 : sqID = " + sqID);
		return dao.select(sqID);
	}


	@Override
	public int create(SqnaVO vo) {
		LOGGER.info("create() 호출");
		return dao.insert(vo);
	}


	@Override
	public int update(SqnaVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}


	@Override
	public int delete(int sqID) {
		LOGGER.info("delete() 호출");
		return dao.delete(sqID);
	}


	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}


	@Override
	public List<SqnaVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}


	@Override
	public SqnaVO sqnaread(SqnaVO sqWRITER) {
		LOGGER.info("read() 호출 : sqWRITER = " + sqWRITER);
		return dao.sqnaselect(sqWRITER);
	}


	@Override
	public List<SqnaVO> read(String sqWRITER) {
		LOGGER.info("read() 호출 : sqWRITER = " + sqWRITER);
		return dao.select(sqWRITER);
	}
	
	
} // end SqnaServiceImple
