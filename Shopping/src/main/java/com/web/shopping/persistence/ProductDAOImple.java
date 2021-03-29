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

	// ��ǰ ��� 
	@Override
	public int insert(ProductVO vo) {
		LOGGER.info("product insert() ��ǰ��� ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	// ��ǰ ��ü ����Ʈ 
	@Override
	public List<ProductVO> select() {
		LOGGER.info("product select() ��ǰ��ü ����Ʈ ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	// ��ǰ ���� 
	@Override
	public ProductVO select(String pID) {
		LOGGER.info("product select() ��ǰ ���� ȣ�� : pID = " + pID);
		return sqlSession.selectOne(NAMESPACE + ".select_by_pID", pID);
	}
	// ��ǰ ���� 
	@Override
	public int update(ProductVO vo) {
		LOGGER.info("product update() ��ǰ���� ���� ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	// ��ǰ ���� 
	@Override
	public int delete(String pID) {
		LOGGER.info("product delete() ��ǰ���� ���� ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", pID);
		
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("product getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<ProductVO> select(PageCriteria criteria) {
		LOGGER.info("product select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<ProductVO> selectByKw(String keyword) {
		LOGGER.info("product selectByKw() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_kw", keyword);
	}
	// ��ǰ ī�װ�  
	@Override
	public List<CategoryVO> category() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".category");
	}
	// �� seller ��ǰ ����Ʈ 
	@Override
	public List<ProductVO> productselect(String sID) {
		LOGGER.info("product list select() ȣ�� : sID : " + sID);
		sID = "%" + sID + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_myProductsID", sID);
	}
	// īƮ ��� 
	@Override
	public int addCart(CartVO vo) throws Exception {
		LOGGER.info("Cart Add insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert_cart", vo);
		
	}
	
	
	
} // end ProductDAOImple
