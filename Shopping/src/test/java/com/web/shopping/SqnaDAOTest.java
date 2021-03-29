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

import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.SqnaDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class SqnaDAOTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SqnaDAOTest.class);
	
	@Autowired
	private SqnaDAO dao;
	
	@Test
	public void testDAO() {
		testSelectAll();
//ok		testSelectBysqID();
//ok		testInsert();
//ok		testUpdate();
//ok		testDelete();
//ok		testTotalCount();
//ok		testPaging(); 
//ok		testSelectBysqWRITER();
//ok		testSelectSearch();	
		
	} // end testDAO() 
	
	private void testSelectAll() { 
		List<SqnaVO> list = dao.select();
		for(SqnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testSelectAll()
	
	private void testSelectBysqID() {
		SqnaVO vo = dao.select(1);
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else {
			LOGGER.info("데이터 없음");
		}
	} // end testSelectBysqID()
	
	private void testInsert() {
		SqnaVO vo = new SqnaVO(0, "", "test1", "test1", "test1", "test1", null, 0 );
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else { 
			LOGGER.info("insert 실패");
		}
	} // end testInsert()
	
	private void testUpdate() { 
		SqnaVO vo = new SqnaVO(1, "", null, "변경", "변경", "변경", null, 0);
		int result = dao.update(vo);
		if(result == 1) {
			LOGGER.info("update 성공");
		} else { 
			LOGGER.info("update 실패");
		}
	} // end testUpdate() 
	
	private void testDelete() { 
		int result = dao.delete(2);
		if(result == 1) { 
			LOGGER.info("삭제 성공");
		} else { 
			LOGGER.info("삭제 실패");
		}
	} // end testDelete()
	
	private void testTotalCount() { 
		int result = dao.getTotalNumsOfRecords();
		LOGGER.info("전체 데이터 : " + result);
	} // end testTotalCount()
	
	private void testPaging() {
		PageCriteria criteria = new PageCriteria(1, 5);
		List<SqnaVO> list = dao.select(criteria);
		for(SqnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testPaging()
	
	private void testSelectBysqWRITER() { 
		List<SqnaVO> vo = dao.select("test1");
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	} // end testSelectBysqWRITER()
	
	private void testSelectSearch() { 
		List<SqnaVO> list = dao.selectByTitleOrContent("변경");
		for(SqnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testSelectSearch()
	
} // end SqnaDAOTest
