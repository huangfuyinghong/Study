package com.web.shopping.persistence;

import java.util.List;

import com.web.shopping.domain.ReplyVO;

public interface ReplyDAO {
	
	int insert(ReplyVO vo);
	List<ReplyVO> select(int qnaID);
	int update(ReplyVO vo);
	int delete(int replyID);

}
