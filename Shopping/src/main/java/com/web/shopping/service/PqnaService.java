package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.PqnaVO;
import com.web.shopping.pageutil.PageCriteria;

//CRUD(CREATE, READ, UPDATE, DELETE)
public interface PqnaService {
	
	public abstract List<PqnaVO> read();
	public abstract PqnaVO read(int pqID);
	public abstract int create(PqnaVO vo);
	public abstract int update(PqnaVO vo);
	public abstract int delete(int pqID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<PqnaVO> read(PageCriteria criteria);

} // end PqnaService
