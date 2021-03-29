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

import com.web.shopping.domain.ReviewVO;
import com.web.shopping.domain.SqnaVO;
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.ReviewDAO;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class ReviewDAOTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewDAOTest.class);
	
	@Autowired
	private ReviewDAO dao;
	
	@Test
	public void testDAO() {
//ok		testSelectAll();
//ok		testSelectByrID();
//ok		testInsert();
//ok		testUpdate();
//ok		testDelete();
//ok		testTotalCount();
//ok		testPaging();
//ok		testSelectByrWRITER();
//ok		testSelectSearch();	
	} // end testDAO() 
	
	
	private void testSelectAll() { 
		List<ReviewVO> list = dao.select();
		for(ReviewVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testSelectAll()
	
	private void testSelectByrID() {
		ReviewVO vo = dao.select(1);
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else {
			LOGGER.info("������ ����");
		}
	} // end testSelectBysqID()
	
	private void testInsert() {
		ReviewVO vo = new ReviewVO(0, 30000001, 20000005, "test1", "test1", "test1", "test1", "test1", null, 0);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert ����");
		} else { 
			LOGGER.info("insert ����");
		}
	} // end testInsert()
	
	private void testUpdate() { 
		ReviewVO vo = new ReviewVO(1, 0, 0, "", "����", "����", "����", "test1", null, 0);
		int result = dao.update(vo);
		if(result == 1) {
			LOGGER.info("update ����");
		} else { 
			LOGGER.info("update ����");
		}
	} // end testUpdate() 
	
	private void testDelete() { 
		int result = dao.delete(2);
		if(result == 1) { 
			LOGGER.info("���� ����");
		} else { 
			LOGGER.info("���� ����");
		}
	} // end testDelete()
	
	private void testTotalCount() { 
		int result = dao.getTotalNumsOfRecords();
		LOGGER.info("��ü ������ : " + result);
	} // end testTotalCount()
	
	private void testPaging() {
		PageCriteria criteria = new PageCriteria(1, 5);
		List<ReviewVO> list = dao.select(criteria);
		for(ReviewVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testPaging()

	private void testSelectByrWRITER() { 
		List<ReviewVO> vo = dao.select("test1");
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("������ ����");
		}
	} // end testSelectByrWRITER()
	
	private void testSelectSearch() { 
		List<ReviewVO> list = dao.selectByTitleOrContent("����");
		for(ReviewVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testSelectSearch()
	
	
} // end ReviewDAOTest
