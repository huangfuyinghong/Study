package com.web.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.ReviewVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.ReviewDAO;



@Service
public class ReviewServiceImple implements ReviewService {
 
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewServiceImple.class);
	
	@Autowired
	private ReviewDAO dao;

	@Override
	public List<ReviewVO> read() {
		LOGGER.info("read() ȣ��");
		return dao.select();
	}

	@Override
	public ReviewVO read(int rID) {
		LOGGER.info("read() ȣ�� : rID = " + rID);
		return dao.select(rID);
	}

	@Override
	public int create(ReviewVO vo) {
		LOGGER.info("create() ȣ��");
		return dao.insert(vo);
	}

	@Override
	public int update(ReviewVO vo) {
		LOGGER.info("update() ȣ��");
		return dao.update(vo);
	}

	@Override
	public int delete(int rID) {
		LOGGER.info("delete() ȣ��");
		return dao.delete(rID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<ReviewVO> read(PageCriteria criteria) {
		LOGGER.info("read() ȣ�� : page = " + criteria.getPage());
		return dao.select(criteria);
	}
	
} // end ReviewServiceImple
