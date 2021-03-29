package com.web.shopping;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.web.shopping.domain.SellerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.SellerDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class SellerDAOTest {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SellerDAOTest.class);

	@Autowired
	private SellerDAO dao;
	
	@Test
	public void testDAO() {
//ok		testInsert();
//ok		testSelectAll();
//ok		testSelectByBid();
//ok		testUpdate();
//ok		testDelete(); 
//ok		testSelectLogin();
//ok		testTotalCount();
//ok		testPaging();
//ok		testSelectBySno();
//ok		testSelectSearch();
	}
	
	private void testInsert() {
		SellerVO vo = new SellerVO(0, "test", "test", "test","test", "test","test", "test", "test","test", 0, null, 0, 0, "test");
		int result = dao.insert(vo);
		if(result == 1) { 
			LOGGER.info("insert 성공");
		} else { 
			LOGGER.info("insert 실패");
		}
	
	}
	
	private void testSelectAll() {
		List<SellerVO> list = dao.select();
		for (SellerVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	
	private void testSelectByBid() {
		SellerVO vo = dao.select("test");
		if(vo != null) { 
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	}
	
	private void testUpdate() {
		SellerVO vo = new SellerVO(6, "test", "test00", "test00","test00", "test00","test00", "test", "test","test", 0, null, 0, 0, "test");
		int result = dao.update(vo);
		if ( result == 1) {
			LOGGER.info("update 성공");
		} else { 
			LOGGER.info("update 실패");
		}
	}
	
//	private void testDelete() { 
//		int result = dao.delete("test");
//		if(result == 1) { 
//			LOGGER.info("삭제 성공");
//		} else { 
//			LOGGER.info("삭제 실패");
//		}
//	} // end testDelete()
	
	private void testSelectLogin() {
		SellerVO vo = dao.select("test");
		if(vo != null) { 
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	}
	
	private void testTotalCount() {
		int result = dao.getTotalNumsOfRecords();
		LOGGER.info("전체 데이터 : " + result);
	} // end testTotalCount()
	
	private void testPaging() {
		PageCriteria criteria = new PageCriteria(1, 5);
		List<SellerVO> list = dao.select(criteria);
		for(SellerVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testPaging() 
	
	private void testSelectBySno() {
		List<SellerVO> vo = dao.select(6);
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	} // end testSelectByBno()
	
	private void testSelectSearch() {
		List<SellerVO> list = dao.selectByKw("test");
		for(SellerVO vo : list) { 
			LOGGER.info(vo.toString());
		}
	} // end testSelectSearch()
	
} // end SellerDAOTest
