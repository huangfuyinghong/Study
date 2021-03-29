package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface BuyerDAO {

	// 회원가입 
	public abstract int insert(BuyerVO vo);
	// 회원가입 아이디 중복 체크 
	public abstract int bidCheck(String bID);
	
	// buyer 전체 리스트 선택  
	public abstract List<BuyerVO> select();
	
	// 회원 정보 보기  
	public abstract BuyerVO select(String bID);
	
	// 회원 정보 수정 
	public abstract int update(BuyerVO vo);
	
	// 회원 정보 탈퇴 
	public abstract void delete(BuyerVO vo);
	
	// 로드인 아이디 비밀번호 확인  
	public abstract BuyerVO selectLogin(BuyerVO vo);
	
	// 전체 buyer 회원 수량 
	public abstract int getTotalNumsOfRecords();
	
	// 한페이지당 몇개의 회원 표시  
	public abstract List<BuyerVO> select(PageCriteria criteria);
	
	// 회원 no 선택 시 회원 전체 정보 확인  
	public abstract List<BuyerVO> select(int bNO);
	
	// 검색창에 keyword 입력시 유사한 정보 출력
	public abstract List<BuyerVO> selectByKw(String keyword);


	
	
} // end BuyerDAO
