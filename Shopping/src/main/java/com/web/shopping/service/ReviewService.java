package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.ReviewVO;
import com.web.shopping.pageutil.PageCriteria;

//CRUD(CREATE, READ, UPDATE, DELETE)
public interface ReviewService {

	public abstract List<ReviewVO> read();
	public abstract ReviewVO read(int qnaID);
	public abstract int create(ReviewVO vo);
	public abstract int update(ReviewVO vo);
	public abstract int delete(int rID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<ReviewVO> read(PageCriteria criteria);
	
} // end ReviewService
