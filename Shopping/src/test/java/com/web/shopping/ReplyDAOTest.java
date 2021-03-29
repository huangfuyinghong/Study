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

import com.web.shopping.domain.ReplyVO;
import com.web.shopping.persistence.ReplyDAO;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class ReplyDAOTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void testDAO() {
//ok		testInsert();
		testSelect();
//ok		testUpdate();
//ok		testDelete(); 
	}
	
	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, 70000, "test2", "test2", null);
		int result = dao.insert(vo);
		LOGGER.info(result + "행 삽입");
	} // end testInsert()
	
	private void testSelect() {
		List<ReplyVO> list = dao.select(0);
		LOGGER.info(list.size() + "");
		for(ReplyVO vo : list) {
			LOGGER.info(vo.toString());
		}
	} // end testSelect()
	
	private void testUpdate() {
		ReplyVO vo = new ReplyVO(2, 1, "update", null, null);
		int result = dao.update(vo);
		LOGGER.info(result + "행 변경");
	} // end testUpdate()
	
	private void testDelete() {
		int result = dao.delete(2);
		LOGGER.info(result + "행 삭제");	
	} // end testDelete()
	
} // end ReplyDAOTest
