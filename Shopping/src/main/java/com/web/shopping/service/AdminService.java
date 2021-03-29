package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.AdminVO;


//CRUD(CREATE, READ, UPDATE, DELETE)
public interface AdminService {
	
	public abstract List<AdminVO> read();
	
	public abstract AdminVO read(String aID);

	public abstract AdminVO readLogin(AdminVO vo);
	
} // end AdminService
