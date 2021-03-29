package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface SellerService {

	public abstract int create(SellerVO vo);                    // 회원가입 
	public abstract int sidCheck(String sID);              // 회원가입 아이디 중복 체크  
	public abstract int snameCheck(String sNAME);          // 회원가입 상호명 중복 체크 
	public abstract List<SellerVO> read();                      // 전체리스트 
	public abstract SellerVO read(String sID);                  // 회원정보 선택 
	public abstract int update(SellerVO vo);                    // 회원정보 수정
	public abstract void delete(SellerVO vo);                     // 회원정보 탈퇴  
	public abstract SellerVO readLogin(SellerVO vo);            // 로그인  
	public abstract int getTotalNumsOfRecords();                // 회원 수 확인  
	public abstract List<SellerVO> read(PageCriteria criteria); // 페이지 설정 
	
} // end SellerService 
