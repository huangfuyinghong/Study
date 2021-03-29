package com.web.shopping;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.web.shopping.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class SqlSessionTest {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SqlSessionTest.class);
	
	// admin
//	private static final String NAMESPACE =
//			"com.web.shopping.AdminMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		AdminVO vo = new AdminVO(0, "test1", "test1", "test1", 1, null);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// buyer
//	private static final String NAMESPACE =
//			"com.web.shopping.BuyerMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		BuyerVO vo = new BuyerVO(0, "test1", "test1", "test1", "test1", "test1", "test1", "2020-01-01", "test",  0,  null, 0, 0, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// seller
//	private static final String NAMESPACE =
//			"com.web.shopping.SellerMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		SellerVO vo = new SellerVO(0, "test", "test", "test", "test", "test", "test", "test", "test", "test", 0,  null, 0, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// product 
//	private static final String NAMESPACE =
//			"com.web.shopping.ProductMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		ProductVO vo = new ProductVO(0, "test1", "test", 0, 0, "test", "test", "test", "test", 0,  null, 0, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// order 
//	private static final String NAMESPACE =
//			"com.web.shopping.OrderMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		OrderVO vo = new OrderVO(0, "test1", null, "test", "test", "test", "test", 0, 0, 0, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// orderDetail
//	private static final String NAMESPACE =
//			"com.web.shopping.OrderDetailMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		OrderDetailVO vo = new OrderDetailVO(0, 30000000, 20000004, 1);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// cart
//	private static final String NAMESPACE =
//			"com.web.shopping.CartMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		CartVO vo = new CartVO(0, "test1", 20000003, 1);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// wishList
//	private static final String NAMESPACE =
//			"com.web.shopping.WishListMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		WishListVO vo = new WishListVO(0, "test1", 20000003);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// bqna
//	private static final String NAMESPACE =
//			"com.web.shopping.BqnaMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		BqnaVO vo = new BqnaVO(0, 0, "test1", "test1", "test1", "test1", "test1", null, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// sqna 
//	private static final String NAMESPACE =
//			"com.web.shopping.SqnaMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		SqnaVO vo = new SqnaVO(0, 0, "test1", "test1", "test1", "test1", "test1", null, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// pqna
//	private static final String NAMESPACE =
//			"com.web.shopping.PqnaMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		PqnaVO vo = new PqnaVO(0, 0, "test1", "test1", "test1", "test1", "test1", null, 0, 20000002);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// review
//	private static final String NAMESPACE =
//			"com.web.shopping.ReviewMapper";
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Test
//	public void testInsert() {
//		ReviewVO vo = new ReviewVO(0, 30000000, 20000002, "test1", "test1", "test1", "test1", "test1", null, 0);
//		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
//		// .insert : mapper.xml의 id값
//				LOGGER.info(result + "행 삽입");
//	}
	
	// reply
	private static final String NAMESPACE =
			"com.web.shopping.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO(0, 0, "test1", "test1", null);
		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
		// .insert : mapper.xml의 id값
				LOGGER.info(result + "행 삽입");
	}

} // end SqlSessionTest
