package com.spring.board;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.board.domain.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class SqlSessionTest {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SqlSessionTest.class);

	private static final String NAMESPACE =
			"com.spring.board.BoardMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO(0, "test", "test", "test", null, 0, "test", 0);
		int result = sqlSession.insert(NAMESPACE + ".board_insert", vo);  // .board_insert : mapper.xml¿« id
		LOGGER.info(result + "«‡ ª¿‘");
	}
	
} // end SqlSessionTest
