package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.CartVO;
import com.web.shopping.domain.CategoryVO;
import com.web.shopping.domain.ProductVO;
import com.web.shopping.pageutil.PageCriteria;

public interface ProductDAO {

	// ��ǰ���  
	public abstract int insert(ProductVO vo);
	// ��ǰ ��ü ����Ʈ 
	public abstract List<ProductVO> select();
	// ��ǰ ���� 
	public abstract ProductVO select(String pID);
	// ��ǰ ���� ���� 
	public abstract int update(ProductVO vo);
	// ��ǰ ���� 
	public abstract int delete(String pID);
	// ��ϵ� ��ǰ ����  
	public abstract int getTotalNumsOfRecords();
	// ���������� ��� ��ǰ ǥ��  
	public abstract List<ProductVO> select(PageCriteria criteria);
	// �˻�â�� keyword �Է� �� ������ ���� ��� 
	public abstract List<ProductVO> selectByKw(String keyword);
	// �� seller ��ǰ ����Ʈ 
	public abstract List<ProductVO> productselect(String sID);
	
	
	// ī�װ� 
	public abstract List<CategoryVO> category() throws Exception;
	
	// īƮ ���  
	public abstract int addCart(CartVO vo) throws Exception;
	
} // end ProductDAO 
