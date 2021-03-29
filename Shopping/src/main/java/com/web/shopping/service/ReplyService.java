package com.web.shopping.service;

import java.util.List;

import com.web.shopping.domain.ReplyVO;

public interface ReplyService {

	int create(ReplyVO vo) throws Exception;
	List<ReplyVO> read(int qnaID);
	int update(ReplyVO vo);
	int delete(int replyID, int qnaID) throws Exception;
	
	
	
} // end ReplyService 
