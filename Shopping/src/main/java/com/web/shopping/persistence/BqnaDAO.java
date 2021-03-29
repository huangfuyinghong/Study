package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.pageutil.PageCriteria;


public interface BqnaDAO {

	public abstract List<BqnaVO> select();
	public abstract BqnaVO select(int bqID);
	public abstract int insert(BqnaVO vo);
	public abstract int update(BqnaVO vo);
	public abstract int delete(int bqID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<BqnaVO> select(PageCriteria criteria);
	public abstract List<BqnaVO> select(String bqWRITER);
	public abstract List<BqnaVO> selectByTitleOrContent(String keyword);
	public abstract int updateReplyCOUNT(int amount, int qnaID);
	
} // end BqnaDAO