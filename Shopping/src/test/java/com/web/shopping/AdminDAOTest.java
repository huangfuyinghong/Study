package com.web.shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.web.shopping.domain.AdminVO;
import com.web.shopping.persistence.AdminDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class AdminDAOTest {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(AdminDAOTest.class);

	@Autowired
	private AdminDAO dao;
	
	@Test
	public void testDAO() {
	//ok	testInsert();
	//ok 	testSelectInfo();
//	testSelectLogin();
	}
	
//	private void testInsert() { 
//		AdminVO vo = new AdminVO(0, "test2", "test2", "test2", 0, null);
//		int result = dao.insert(vo);
//		if(result == 1) {
//			LOGGER.info("insert 성공");
//		} else { 
//			LOGGER.info("insert 실패");
//		}
//	}
	
	private void testSelectInfo() { 
		AdminVO vo = dao.select("test2");
		if(vo != null) {
			LOGGER.info(vo.toString());
		} else { 
			LOGGER.info("데이터 없음");
		}
		
	}
	
//	private void testSelectLogin() {
//		AdminVO vo = dao.selectLogin("vo");
//		if(vo != null) { 
//			LOGGER.info(vo.toString());
//		} else { 
//			LOGGER.info("데이터 없음");
//		}
//	}
	
} // end AdminDAOTest
