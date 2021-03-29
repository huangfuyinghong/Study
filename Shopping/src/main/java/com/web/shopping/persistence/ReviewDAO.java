package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.ReviewVO;
import com.web.shopping.pageutil.PageCriteria;

public interface ReviewDAO {

	public abstract List<ReviewVO> select();
	public abstract ReviewVO select(int rID);
	public abstract int insert(ReviewVO vo);
	public abstract int update(ReviewVO vo);
	public abstract int delete(int rID);
	public abstract int getTotalNumsOfRecords();
	public abstract List<ReviewVO> select(PageCriteria criteria);
	public abstract List<ReviewVO> select(String rWRITER);
	public abstract List<ReviewVO> selectByTitleOrContent(String keyword);
	public abstract int updateReplyCount(int amount, int rID);
	
} // end ReviewDAO
