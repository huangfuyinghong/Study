package com.web.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shopping.domain.CartVO;
import com.web.shopping.domain.CategoryVO;
import com.web.shopping.domain.ProductVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.ProductDAO;

@Service
public class ProductServiceImple implements ProductService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ProductServiceImple.class);
	
	@Autowired
	private ProductDAO dao;

	
	// 상품등록 
	@Override
	public int create(ProductVO vo) {
		LOGGER.info("product create() 호출");
		return dao.insert(vo);
	}
	// 상품 전체리스트 
	@Override
	public List<ProductVO> read() {
		LOGGER.info("product read() 전체리스트 호출");
		return dao.select();
	}
	// 상품정보 
	@Override
	public ProductVO read(String pID) {
		LOGGER.info("product read() 내 정보 호출 : pID = " + pID);
		return dao.select(pID);
	}
	// 상품정보 수정  
	@Override
	public int update(ProductVO vo) {
		LOGGER.info("product update() 상품정보 수정 호출");
		return dao.update(vo);
	}
	// 등록 상품 삭제
	@Override
	public int delete(String pID) {
		LOGGER.info("product delete() 상품 삭제 호출");
		return dao.delete(pID);
		
	}
	// 등록된 상품 수량 
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("product getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}
	// 한페이지당 확인되는 상품 수량 
	@Override
	public List<ProductVO> read(PageCriteria criteria) {
		LOGGER.info("product read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}

	@Override
	public List<ProductVO> readByKw(String keyword) {
		LOGGER.info("product read() 호출 : keyword = " + keyword);
		return dao.selectByKw(keyword);
	}
	
	// 카테고리 
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}
	// 각 seller 제품 리스트 
	@Override
	public List<ProductVO> productread(String sID) {
		LOGGER.info("product read() 호출 : sID = " + sID);
		return dao.productselect(sID);
	}
	// 카트 담기 
	@Override
	public int create(CartVO vo) throws Exception {
		LOGGER.info("Cart Add insert() 호출");
		return dao.addCart(vo);
	}
	
} // end ProductServiceImple
