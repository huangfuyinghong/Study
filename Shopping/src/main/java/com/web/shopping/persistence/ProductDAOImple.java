package com.web.shopping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.CartVO;
import com.web.shopping.domain.CategoryVO;
import com.web.shopping.domain.ProductVO;
import com.web.shopping.pageutil.PageCriteria;

@Repository
public class ProductDAOImple implements ProductDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ProductDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.ProductMapper";
	
	@Autowired
	private SqlSession sqlSession;

	// 상품 등록 
	@Override
	public int insert(ProductVO vo) {
		LOGGER.info("product insert() 제품등록 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	// 상품 전체 리스트 
	@Override
	public List<ProductVO> select() {
		LOGGER.info("product select() 제품전체 리스트 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	// 상품 정보 
	@Override
	public ProductVO select(String pID) {
		LOGGER.info("product select() 상품 정보 호출 : pID = " + pID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_pID", pID);
	}
	// 상품 수정 
	@Override
	public int update(ProductVO vo) {
		LOGGER.info("product update() 상품정보 수정 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	// 상품 삭제 
	@Override
	public int delete(String pID) {
		LOGGER.info("product delete() 상품정보 삭제 호출");
		return sqlSession.delete(NAMESPACE + ".delete", pID);
		
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("product getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<ProductVO> select(PageCriteria criteria) {
		LOGGER.info("product select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<ProductVO> selectByKw(String keyword) {
		LOGGER.info("product selectByKw() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_kw", keyword);
	}
	// 제품 카테고리  
	@Override
	public List<CategoryVO> category() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".category");
	}
	// 각 seller 제품 리스트 
	@Override
	public List<ProductVO> productselect(String sID) {
		LOGGER.info("product list select() 호출 : sID : " + sID);
		sID = "%" + sID + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_myProductsID", sID);
	}
	// 카트 담기 
	@Override
	public int addCart(CartVO vo) throws Exception {
		LOGGER.info("Cart Add insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert_cart", vo);
		
	}
	
	
	
} // end ProductDAOImple
