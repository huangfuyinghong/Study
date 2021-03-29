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

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.BuyerVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.BuyerDAO;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class BuyerDAOTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BuyerDAOTest.class);
	
	@Autowired
	private BuyerDAO dao;
	
	@Test
	public void testDAO() {
//ok		testInsert();
//ok		testSelectAll();
//ok		testSelectByBid();
//ok		testUpdate();
//ok		testDelete();
//		testSelectLogin();
//ok		testTotalCount();
//ok		testPaging();
//ok		testSelectByBno();
//ok		testSelectSearch();
	}
	
	private void testInsert() {
		BuyerVO vo = new BuyerVO(0, "test", "test", "test","test", "test","test", "2020.02.02", "test", 0, null, 0, 0, 0 );
		int result = dao.insert(vo);
		if(result == 1) { 
			LOGGER.info("insert 성공");
		} else { 
			LOGGER.info("insert 실패");
		}
	
	}
	
	private void testSelectAll() {
		List<BuyerVO> list = dao.select();
		for (BuyerVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	
	private void testSelectByBid() {
		BuyerVO vo = dao.select("test");
		if(vo != null) { 
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	}
	
	private void testUpdate() {
		BuyerVO vo = new BuyerVO(2, "", "", "test2","test2", "test2","test2", "2020.02.02", "test2", 0, null, 0, 0, 0 );
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
//	}

//	private void testSelectLogin() {
//		BuyerVO vo = dao.selectLogin("test1","test1");
//		if(vo != null) { 
//			LOGGER.info(vo.toString());
//		} else { 
//			LOGGER.info("데이터 없음");
//		}
//	}
	
	private void testTotalCount() {
		int result = dao.getTotalNumsOfRecords();
		LOGGER.info("전체 데이터 : " + result);
	} // end testTotalCount()
	
	private void testPaging() {
		PageCriteria criteria = new PageCriteria(1, 5);
		List<BuyerVO> list = dao.select(criteria);
		for(BuyerVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testPaging() 
	
	private void testSelectByBno() {
		List<BuyerVO> vo = dao.select(2);
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	} // end testSelectByBno()
	
	private void testSelectSearch() {
		List<BuyerVO> list = dao.selectByKw("test");
		for(BuyerVO vo : list) { 
			LOGGER.info(vo.toString());
		}
	} // end testSelectSearch()
	
	
	
} // end BuyerDAOTest
