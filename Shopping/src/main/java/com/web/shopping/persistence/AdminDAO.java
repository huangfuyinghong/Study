package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.AdminVO;

public interface AdminDAO {

	// ADMIN ��ü����Ʈ 
	public abstract List<AdminVO> select();
	
	// ȸ������ ����  
	public abstract AdminVO select(String aID);
	
	// �α��� ���̵� ��й�ȣ Ȯ�� 
	public abstract AdminVO selectLogin(AdminVO vo);


	
} // end AdminnDAO
