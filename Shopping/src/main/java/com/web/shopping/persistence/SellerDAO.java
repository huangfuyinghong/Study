package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface SellerDAO {

	    // 회원가입 
		public abstract int insert(SellerVO vo);
		// 회원가입 아이디 중복 체크 
		public abstract int sidCheck(String sID);
		// 회원가입 상호명(sNAME) 중복 체크 
		public abstract int snameCheck(String sNAME);
		
		// buyer 전체 리스트 선택  
		public abstract List<SellerVO> select();
		
		// 회원 정보 보기  
		public abstract SellerVO select(String sID);
		
		// 회원 정보 수정 
		public abstract int update(SellerVO vo);
		
		// 회원 정보 탈퇴 
		public abstract void delete(SellerVO vo);
		
		// 로드인 아이디 비밀번호 확인  
		public abstract SellerVO selectLogin(SellerVO vo);
		
		// 전체 buyer 회원 수량 
		public abstract int getTotalNumsOfRecords();
		
		// 한페이지당 몇개의 회원 표시  
		public abstract List<SellerVO> select(PageCriteria criteria);
		
		// 회원 no 선택 시 회원 전체 정보 확인  
		public abstract List<SellerVO> select(int sNO);
		
		// 검색창에 keyword 입력시 유사한 정보 출력
		public abstract List<SellerVO> selectByKw(String keyword);
			
	
} // end SellerDAO
