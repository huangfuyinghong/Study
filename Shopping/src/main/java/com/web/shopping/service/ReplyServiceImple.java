package com.web.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.shopping.domain.BqnaVO;
import com.web.shopping.domain.ReplyVO;
import com.web.shopping.persistence.BqnaDAO;
import com.web.shopping.persistence.PqnaDAO;
import com.web.shopping.persistence.ReplyDAO;
import com.web.shopping.persistence.SqnaDAO;




@Service
public class ReplyServiceImple implements ReplyService{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDao;
	@Autowired
	private BqnaDAO bqnaDao;
	@Autowired
	private SqnaDAO sqnaDao;
	@Autowired
	private PqnaDAO pqnaDao;
	
	@Transactional
	@Override
	public int create(ReplyVO vo) throws Exception {
		LOGGER.info("create() 호출");
		replyDao.insert(vo);
		LOGGER.info("댓글 입력 성공");

	    bqnaDao.updateReplyCOUNT(1, vo.getQnaID());
		sqnaDao.updateReplyCOUNT(1, vo.getQnaID());
		pqnaDao.updateReplyCOUNT(1, vo.getQnaID());
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}
	@Override
	public List<ReplyVO> read(int qnaID) {
		LOGGER.info("");
		return replyDao.select(qnaID);
	}
	@Override
	public int update(ReplyVO vo) {
		LOGGER.info("");
		return replyDao.update(vo);
	}
	@Override
	public int delete(int replyID, int qnaID) throws Exception {
		LOGGER.info("");
		replyDao.delete(replyID);
		LOGGER.info("댓글 삭제 성공");
		
		bqnaDao.updateReplyCOUNT(-1, qnaID);
		sqnaDao.updateReplyCOUNT(-1, qnaID);
		pqnaDao.updateReplyCOUNT(-1, qnaID);
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}
	
} // end ReplyServiceImple
