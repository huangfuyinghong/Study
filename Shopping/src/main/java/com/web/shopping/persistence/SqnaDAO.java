package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;

public interface SqnaDAO {

	public abstract List<SqnaVO> select();
	public abstract SqnaVO select(int sqID);
	public abstract SqnaVO sqnaselect(SqnaVO sqWRITER);
	public abstract int insert(SqnaVO vo);
	public abstract int update(SqnaVO vo);
	public abstract int delete(int sqID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<SqnaVO> select(PageCriteria criteria);
	public abstract List<SqnaVO> select(String sqWRITER);
	public abstract List<SqnaVO> selectByTitleOrContent(String keyword);
	public abstract int updateReplyCOUNT(int amount, int qnaID);
	
} // end SqnaDAO 
