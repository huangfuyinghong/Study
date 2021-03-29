package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.pageutil.PageCriteria;

//CRUD(CREATE, READ, UPDATE, DELETE)
public interface BqnaService {

	public abstract List<BqnaVO> read();
	public abstract BqnaVO read(int bqID);
	public abstract int create(BqnaVO vo);
	public abstract int update(BqnaVO vo);
	public abstract int delete(int bqID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<BqnaVO> read(PageCriteria criteria);
	public abstract List<BqnaVO> read(String bqWRITER);
	
} // end BqnaService
