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
import com.web.shopping.pageutil.PageCriteria;
import com.web.shopping.persistence.BqnaDAO;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class BqnaDAOTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BqnaDAOTest.class);
	
	@Autowired
	private BqnaDAO dao;
	
	@Test
	public void testDAO() {
//ok		testSelectBybqID();
//ok		testSelectAll();
//ok		testInsert();
//ok		testUpdate();
//ok		testDelete();
//ok		testTotalCount();
//ok		testPaging();
//ok		testSelectBybqWRITER();
//ok		testSelectSearch();
		
	} // end testDAO() 

	private void testSelectBybqID() {
		BqnaVO vo = dao.select(1);
		if(vo != null) { 
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("������ ����");
		}
	} // end testSelectByBqid()
	
	private void testSelectAll() {
		List<BqnaVO> list = dao.select();
		for (BqnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testSelectAll()
	
	private void testInsert() {
		BqnaVO vo = new BqnaVO(0, "", "test1", "test1", "test1", "test1", null, 0);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert ����");
		} else { 
			LOGGER.info("insert ����");
		}
	} // end testInsert()
	
	private void testUpdate() { 
		BqnaVO vo = new BqnaVO(1, "", null, "����", "����", "����", null, 0);
		int result = dao.update(vo);
		if ( result == 1) {
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
		List<BqnaVO> list = dao.select(criteria);
		for(BqnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testPaging() 
	
	private void testSelectBybqWRITER() {
		List<BqnaVO> vo = dao.select("test1");
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("������ ����");
		}
	} // end testSelectBybqWRITER()
	
	private void testSelectSearch() {
		List<BqnaVO> list = dao.selectByTitleOrContent("����");
		for(BqnaVO vo : list) { 
			LOGGER.info(vo.toString());
		}
	} // end testSelectSearch()
	
	
	
} // end BqnaDAOTest
