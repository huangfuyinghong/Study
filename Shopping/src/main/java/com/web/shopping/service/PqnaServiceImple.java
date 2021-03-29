package com.web.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.PqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.PqnaDAO;


@Service
public class PqnaServiceImple implements PqnaService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(PqnaServiceImple.class);
	
	@Autowired
	private PqnaDAO dao;

	@Override
	public List<PqnaVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}

	@Override
	public PqnaVO read(int pqID) {
		LOGGER.info("read() 호출 : pqID = " + pqID);
		return dao.select(pqID);
	}

	@Override
	public int create(PqnaVO vo) {
		LOGGER.info("create() 호출");
		return dao.insert(vo);
	}

	@Override
	public int update(PqnaVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int pqID) {
		LOGGER.info("delete() 호출");
		return dao.delete(pqID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<PqnaVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}
} // end PqnaServiceImple
