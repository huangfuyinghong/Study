package com.web.shopping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.shopping.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE = 
			"com.web.shopping.ReplyMapper";
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(ReplyVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	@Override
	public List<ReplyVO> select(int qnaID) {
		LOGGER.info("select() ȣ�� : qnaID = " + qnaID);
		return sqlSession.selectList(NAMESPACE + ".select_by_reply_qnaID", qnaID);
	}
	@Override
	public int update(ReplyVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	@Override
	public int delete(int replyID) {
		LOGGER.info("delete() ȣ�� : replyID = " + replyID);
		return sqlSession.delete(NAMESPACE + ".delete", replyID);
	}
	
} // end ReplyDAOImple
