package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface SellerDAO {

	    // ȸ������ 
		public abstract int insert(SellerVO vo);
		// ȸ������ ���̵� �ߺ� üũ 
		public abstract int sidCheck(String sID);
		// ȸ������ ��ȣ��(sNAME) �ߺ� üũ 
		public abstract int snameCheck(String sNAME);
		
		// buyer ��ü ����Ʈ ����  
		public abstract List<SellerVO> select();
		
		// ȸ�� ���� ����  
		public abstract SellerVO select(String sID);
		
		// ȸ�� ���� ���� 
		public abstract int update(SellerVO vo);
		
		// ȸ�� ���� Ż�� 
		public abstract void delete(SellerVO vo);
		
		// �ε��� ���̵� ��й�ȣ Ȯ��  
		public abstract SellerVO selectLogin(SellerVO vo);
		
		// ��ü buyer ȸ�� ���� 
		public abstract int getTotalNumsOfRecords();
		
		// ���������� ��� ȸ�� ǥ��  
		public abstract List<SellerVO> select(PageCriteria criteria);
		
		// ȸ�� no ���� �� ȸ�� ��ü ���� Ȯ��  
		public abstract List<SellerVO> select(int sNO);
		
		// �˻�â�� keyword �Է½� ������ ���� ���
		public abstract List<SellerVO> selectByKw(String keyword);
			
	
} // end SellerDAO
