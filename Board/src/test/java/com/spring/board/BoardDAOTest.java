package com.spring.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.board.domain.BoardVO;
import com.spring.board.persistence.BoardDAO;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class BoardDAOTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testDAO() throws Exception {
//ok		testInsert();
//ok		testSelectBybNo();
//ok		testSelectAll();
	}
	
	private void testInsert() throws Exception {
		BoardVO vo = new BoardVO(0, "test", "test", "test", null, 0, "test", 0);
		int result = dao.insertBoard(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else { 
			LOGGER.info("insert 실패");
		}
	}
	
	private void testSelectAll() throws Exception {
		List<BoardVO> list = dao.selectBoard();
		for (BoardVO vo : list) { 
			LOGGER.info(vo.toString());
		}
	} // end testSelectAll() 
	
	private void testSelectBybNo() throws Exception {
		BoardVO vo = dao.selectBoard(100000);
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
	}
	
	
	
} // end BoardDAOTest
