package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.PqnaVO;
import com.web.shopping.pageutil.PageCriteria;

public interface PqnaDAO {

	public abstract List<PqnaVO> select();
	public abstract PqnaVO select(int pqID);
	public abstract int insert(PqnaVO vo);
	public abstract int update(PqnaVO vo);
	public abstract int delete(int pqID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<PqnaVO> select(PageCriteria criteria);
	public abstract List<PqnaVO> select(String pqWRITER);
	public abstract List<PqnaVO> selectByTitleOrContent(String keyword);
	public abstract int updateReplyCOUNT(int amount, int pqID);
	
} // end PqnaDAO
