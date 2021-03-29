package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface BuyerService {
	
	public abstract int create(BuyerVO vo);
	public abstract int bidCheck(String bID);              // 회원가입 아이디 중복 체크 
	public abstract List<BuyerVO> read();
	public abstract BuyerVO read(String bID);
	public abstract int update(BuyerVO vo);
	public abstract void delete(BuyerVO vo);
	public abstract BuyerVO readLogin(BuyerVO vo);
	public abstract int getTotalNumsOfRecords();
	public abstract List<BuyerVO> read(PageCriteria criteria);

} // end BuyerService
