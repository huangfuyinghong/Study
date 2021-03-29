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

	
	// ��ǰ��� 
	@Override
	public int create(ProductVO vo) {
		LOGGER.info("product create() ȣ��");
		return dao.insert(vo);
	}
	// ��ǰ ��ü����Ʈ 
	@Override
	public List<ProductVO> read() {
		LOGGER.info("product read() ��ü����Ʈ ȣ��");
		return dao.select();
	}
	// ��ǰ���� 
	@Override
	public ProductVO read(String pID) {
		LOGGER.info("product read() �� ���� ȣ�� : pID = " + pID);
		return dao.select(pID);
	}
	// ��ǰ���� ����  
	@Override
	public int update(ProductVO vo) {
		LOGGER.info("product update() ��ǰ���� ���� ȣ��");
		return dao.update(vo);
	}
	// ��� ��ǰ ����
	@Override
	public int delete(String pID) {
		LOGGER.info("product delete() ��ǰ ���� ȣ��");
		return dao.delete(pID);
		
	}
	// ��ϵ� ��ǰ ���� 
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("product getTotalNumsOfRecords() ȣ��");
		return dao.getTotalNumsOfRecords();
	}
	// ���������� Ȯ�εǴ� ��ǰ ���� 
	@Override
	public List<ProductVO> read(PageCriteria criteria) {
		LOGGER.info("product read() ȣ�� : page = " + criteria.getPage());
		return dao.select(criteria);
	}

	@Override
	public List<ProductVO> readByKw(String keyword) {
		LOGGER.info("product read() ȣ�� : keyword = " + keyword);
		return dao.selectByKw(keyword);
	}
	
	// ī�װ� 
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}
	// �� seller ��ǰ ����Ʈ 
	@Override
	public List<ProductVO> productread(String sID) {
		LOGGER.info("product read() ȣ�� : sID = " + sID);
		return dao.productselect(sID);
	}
	// īƮ ��� 
	@Override
	public int create(CartVO vo) throws Exception {
		LOGGER.info("Cart Add insert() ȣ��");
		return dao.addCart(vo);
	}
	
} // end ProductServiceImple
