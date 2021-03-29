package com.web.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.shopping.domain.ReplyVO;

@RestController
//- @RestController�� ����� Ŭ������ ��� �޼ҵ����
//�� ���� ������ View(JSP) ������ �̸��� �ǹ��ϴ� ���� �ƴ϶�,
//ResponseBody�� ���Եż� Ŭ���̾�Ʈ���� �����ͷ� ���޵�
//- @RestController�� �޼ҵ�鿡�� @ResponseBody ������̼��� ������� ����
//- @Restcontroller�� ������ 4�������� ����
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
		// - Ŭ���̾�Ʈ�� �����͸� �����ϴ� Ŭ����
		// - �����Ϳ� HttpStatus�� ������ �� ����(����, ���� � ���� ����)
		// - �Ű����� T body�� �Էµ� T Ŭ����(���� ���, ReplyVO)�� Ÿ�Կ� ������
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
