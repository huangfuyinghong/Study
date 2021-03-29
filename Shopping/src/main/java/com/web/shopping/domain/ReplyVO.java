package com.web.shopping.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/* 
REPLYID	       NUMBER	            No		1	답변 아이디
QNAID	       NUMBER	            Yes		2	bqna 답변 아이디
REPLYCONTENT   VARCHAR2(1000 BYTE)	Yes		3	
REPLYWRITER	   VARCHAR2(100 BYTE)	Yes		4	
REPLYCDATE	   TIMESTAMP(6)	        Yes	sysdate 5   
*/
public class ReplyVO {

	private Integer replyID;
	private Integer qnaID;
	private String replyCONTENT;
	private String replyWRITER;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date replyCDATE;
	
	// 생성자
	public ReplyVO() {}

	public ReplyVO(int replyID, int qnaID, String replyCONTENT, String replyWRITER, Date replyCDATE) {
		this.replyID = replyID;
		this.qnaID = qnaID;
		this.replyCONTENT = replyCONTENT;
		this.replyWRITER = replyWRITER;
		this.replyCDATE = replyCDATE;
	}

	// getter / setter 
	public int getReplyID() {
		return replyID;
	}

	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}

	public int getQnaID() {
		return qnaID;
	}

	public void setQnaID(int qnaID) {
		this.qnaID = qnaID;
	}

	public String getReplyCONTENT() {
		return replyCONTENT;
	}

	public void setReplyCONTENT(String replyCONTENT) {
		this.replyCONTENT = replyCONTENT;
	}

	public String getReplyWRITER() {
		return replyWRITER;
	}

	public void setReplyWRITER(String replyWRITER) {
		this.replyWRITER = replyWRITER;
	}

	public Date getReplyCDATE() {
		return replyCDATE;
	}

	public void setReplyCDATE(Date replyCDATE) {
		this.replyCDATE = replyCDATE;
	}

	// toString
	@Override
	public String toString() {
		return "ReplyVO [replyID=" + replyID + ", qnaID=" + qnaID + ", replyCONTENT=" + replyCONTENT + ", replyWRITER="
				+ replyWRITER + ", replyCDATE=" + replyCDATE + "]";
	}

} // end ReplyVO
