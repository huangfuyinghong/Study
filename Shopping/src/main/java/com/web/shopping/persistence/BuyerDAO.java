package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;

public interface BuyerDAO {

	// ȸ������ 
	public abstract int insert(BuyerVO vo);
	// ȸ������ ���̵� �ߺ� üũ 
	public abstract int bidCheck(String bID);
	
	// buyer ��ü ����Ʈ ����  
	public abstract List<BuyerVO> select();
	
	// ȸ�� ���� ����  
	public abstract BuyerVO select(String bID);
	
	// ȸ�� ���� ���� 
	public abstract int update(BuyerVO vo);
	
	// ȸ�� ���� Ż�� 
	public abstract void delete(BuyerVO vo);
	
	// �ε��� ���̵� ��й�ȣ Ȯ��  
	public abstract BuyerVO selectLogin(BuyerVO vo);
	
	// ��ü buyer ȸ�� ���� 
	public abstract int getTotalNumsOfRecords();
	
	// ���������� ��� ȸ�� ǥ��  
	public abstract List<BuyerVO> select(PageCriteria criteria);
	
	// ȸ�� no ���� �� ȸ�� ��ü ���� Ȯ��  
	public abstract List<BuyerVO> select(int bNO);
	
	// �˻�â�� keyword �Է½� ������ ���� ���
	public abstract List<BuyerVO> selectByKw(String keyword);


	
	
} // end BuyerDAO
