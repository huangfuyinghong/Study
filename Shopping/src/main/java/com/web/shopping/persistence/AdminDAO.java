package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.AdminVO;

public interface AdminDAO {

	// ADMIN 전체리스트 
	public abstract List<AdminVO> select();
	
	// 회원정보 보기  
	public abstract AdminVO select(String aID);
	
	// 로그인 아이디 비밀번호 확인 
	public abstract AdminVO selectLogin(AdminVO vo);


	
} // end AdminnDAO
