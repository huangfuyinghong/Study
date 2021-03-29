package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface SellerService {

	public abstract int create(SellerVO vo);                    // ȸ������ 
	public abstract int sidCheck(String sID);              // ȸ������ ���̵� �ߺ� üũ  
	public abstract int snameCheck(String sNAME);          // ȸ������ ��ȣ�� �ߺ� üũ 
	public abstract List<SellerVO> read();                      // ��ü����Ʈ 
	public abstract SellerVO read(String sID);                  // ȸ������ ���� 
	public abstract int update(SellerVO vo);                    // ȸ������ ����
	public abstract void delete(SellerVO vo);                     // ȸ������ Ż��  
	public abstract SellerVO readLogin(SellerVO vo);            // �α���  
	public abstract int getTotalNumsOfRecords();                // ȸ�� �� Ȯ��  
	public abstract List<SellerVO> read(PageCriteria criteria); // ������ ���� 
	
} // end SellerService 
