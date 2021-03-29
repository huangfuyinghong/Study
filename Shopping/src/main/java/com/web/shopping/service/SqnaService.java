package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;

//CRUD(CREATE, READ, UPDATE, DELETE)
public interface SqnaService {

	public abstract List<SqnaVO> read();
	public abstract SqnaVO read(int sqID);
	public abstract SqnaVO sqnaread(SqnaVO sqWRITER);
	public abstract int create(SqnaVO vo);
	public abstract int update(SqnaVO vo);
	public abstract int delete(int sqID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<SqnaVO> read(PageCriteria criteria);
	public abstract List<SqnaVO> read(String sqWRITER);
	
	
} // end SqnaService
