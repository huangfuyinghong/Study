package com.web.shopping;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 

public class ReviewControllerTest {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewControllerTest.class);
	
	@Autowired
	private WebApplicationContext wac; // 웹 어플리케이션 객체
	
	// MVC 패턴의 앱을 테스트하는 mock-up 객체
			private MockMvc mock;
			
			@Before
			// 실제 JUnit 테스트를 실행하기 전에 초기화 작업을 수행하는 메소드
			public void beforeTest() {
				LOGGER.info("beforeTest 호출");
				LOGGER.info("wac : " + wac);
				LOGGER.info("mock : " + mock);
				// 컨트롤러 메소드에게 요청을 보낼 수 있는 mockup 객체 생성
				mock = MockMvcBuilders.webAppContextSetup(wac).build();
			}
			
			@Test
			// JUnit 테스트를 수행하는 메소드
			public void test() throws Exception {
				testList();
			}

			private void testList() throws Exception {
				LOGGER.info("testList() 호출");
				// get(uri) : GET요청에 대한 mock 객체 생성
				// post(uri) : POST요청에 대한 mock 객체 생성
				// put(uri) : PUT요청에 대한 mock 객체 생성
				// delete(uri) : DELETE요청에 대한 mock 객체 생성

				mock.perform(get("/review/list").param("page", "1"));
				
			}
			
			@After
			// JUnit 테스트 수행 후 호출되는 메소드
			public void afterTest() {
				LOGGER.info("afterTest() 호출");
			}

} // end ReviewControllerTest
