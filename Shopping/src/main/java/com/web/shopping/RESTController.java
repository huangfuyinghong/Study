package com.web.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.shopping.domain.ReplyVO;

@RestController
//- @RestController로 선언된 클래스의 모든 메소드들은
//그 리턴 값들이 View(JSP) 파일의 이름을 의미하는 것이 아니라,
//ResponseBody에 포함돼서 클라이언트에게 데이터로 전달됨
//- @RestController의 메소드들에는 @ResponseBody 어노테이션을 사용하지 않음
//- @Restcontroller는 스프링 4버전부터 지원
public class RESTController {

	@GetMapping("/rest1")
	public String rest1() {
		return "Hello, REST Controller!";
	}
		
	@GetMapping("/rest2")
	public List<ReplyVO> rest2() {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		for (int i = 0; i < 3; i++) {
			list.add(new ReplyVO(i, 1, "test", "test", null));
		}
		return list;
	}	
	
	@GetMapping("/rest3")
	public ResponseEntity<ReplyVO> rest3(){
		ReplyVO vo = new ReplyVO(1, 1, "test", "test", null);
		// * ResponseEntity<T>
		// - 클라이언트에 데이터를 전송하는 클래스
		// - 데이터에 HttpStatus를 전송할 수 있음(성공, 실패 등에 대한 정보)
		// - 매개변수 T body는 입력된 T 클래스(예를 들어, ReplyVO)의 타입에 고정됨
		ResponseEntity<ReplyVO> entity = 
				new ResponseEntity<ReplyVO>(vo, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/rest4")
	public ResponseEntity<List<ReplyVO>> rest4() {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		for (int i = 0; i < 3; i++) {
			list.add(new ReplyVO(i, 1, "test", "test", null));
		}
		ResponseEntity<List<ReplyVO>> entity = 
				new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK); 
		return entity;
	}
	
} // end RESTController
