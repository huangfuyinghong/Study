package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.CartVO;
import com.web.shopping.domain.CategoryVO;
import com.web.shopping.domain.ProductVO;
import com.web.shopping.pageutil.PageCriteria;

public interface ProductService {

	// ��ǰ���  
		public abstract int create(ProductVO vo);
		// ��ǰ ��ü ����Ʈ 
		public abstract List<ProductVO> read();
		// ��ǰ ���� 
		public abstract ProductVO read(String pID);
		// ��ǰ ���� ���� 
		public abstract int update(ProductVO vo);
		// ��ǰ ���� 
		public abstract int delete(String pID);
		// ��ϵ� ��ǰ ����  
		public abstract int getTotalNumsOfRecords();
		// ���������� ��� ��ǰ ǥ��  
		public abstract List<ProductVO> read(PageCriteria criteria);
		// �˻�â�� keyword �Է� �� ������ ���� ��� 
		public abstract List<ProductVO> readByKw(String keyword);
		// �� seller ��ǰ ����Ʈ 
		public abstract List<ProductVO> productread(String sID);
		
		
		// ī�װ� 
		public abstract List<CategoryVO> category() throws Exception;
		
		// īƮ ���  
		public abstract int create(CartVO vo) throws Exception;	
	
} // end ProductService
