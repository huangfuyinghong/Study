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
//������ �����ӿ�ũ���� ���� ����(Service/Business layer)�� ���۳�Ʈ���� �˷��ִ� ������̼�

public class BqnaServiceImple implements BqnaService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BqnaServiceImple.class);
	
	@Autowired
	private BqnaDAO dao;

	@Override
	public List<BqnaVO> read() {
		LOGGER.info("read() ȣ��");
		return dao.select();
	}

	@Override
	public BqnaVO read(int bqID) {
		LOGGER.info("read() ȣ�� : bqID = " + bqID);
		return dao.select(bqID);
	}

	@Override
	public int create(BqnaVO vo) {
		LOGGER.info("create() ȣ��");
		return dao.insert(vo);
	}

	@Override
	public int update(BqnaVO vo) {
		LOGGER.info("update() ȣ��");
		return dao.update(vo);
	}

	@Override
	public int delete(int bqID) {
		LOGGER.info("delete() ȣ��");
		return dao.delete(bqID);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<BqnaVO> read(PageCriteria criteria) {
		LOGGER.info("read() ȣ�� : page = " + criteria.getPage());
		return dao.select(criteria);
	}

	@Override
	public List<BqnaVO> read(String bqWRITER) {
		LOGGER.info("read() ȣ�� : bqWRITER = " + bqWRITER);
		return dao.select(bqWRITER);
	}

} // end BqnaServiceImple
