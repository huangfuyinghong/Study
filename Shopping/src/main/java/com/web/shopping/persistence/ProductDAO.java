package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.CartVO;
import com.web.shopping.domain.CategoryVO;
import com.web.shopping.domain.ProductVO;
import com.web.shopping.pageutil.PageCriteria;

public interface ProductDAO {

	// 상품등록  
	public abstract int insert(ProductVO vo);
	// 상품 전체 리스트 
	public abstract List<ProductVO> select();
	// 상품 정보 
	public abstract ProductVO select(String pID);
	// 상품 정보 수정 
	public abstract int update(ProductVO vo);
	// 상품 삭제 
	public abstract int delete(String pID);
	// 등록된 제품 수량  
	public abstract int getTotalNumsOfRecords();
	// 한페이지당 몇개의 제품 표시  
	public abstract List<ProductVO> select(PageCriteria criteria);
	// 검색창에 keyword 입력 시 유사한 정보 출력 
	public abstract List<ProductVO> selectByKw(String keyword);
	// 각 seller 제품 리스트 
	public abstract List<ProductVO> productselect(String sID);
	
	
	// 카테고리 
	public abstract List<CategoryVO> category() throws Exception;
	
	// 카트 담기  
	public abstract int addCart(CartVO vo) throws Exception;
	
} // end ProductDAO 
