package com.spring.board.domain;

import java.util.Date;

/*
BNO	      NUMBER	            No		       1	게시글 번호
TITLE	  VARCHAR2(500 BYTE)	No		       2	게시글 제목
CONTENT	  VARCHAR2(1000 BYTE)	No		       3 	게시글 내용
WRITER	  VARCHAR2(100 BYTE)	No		       4	게시글 작성자
BDATE	  TIMESTAMP(6)	        No	 SYSDATE   5	게시글 생성일
VIEWCNT	  NUMBER	            Yes	    0      6	게시글 열람수
BFILE	  VARCHAR2(1000 BYTE)	Yes		       7	게시글 파일첨부
REPLYCNT  NUMBER	            Yes		0      8	댓글 수
*/

public class BoardVO {

	private Integer bNo;
	private String title;
	private String content;
	private String writer;
	private Date bDate; 
	private Integer viewCnt;
	private String bFile;
	private Integer replyCnt;
	
	public BoardVO() {}

	public BoardVO(Integer bNo, String title, String content, String writer, Date bDate, Integer viewCnt, String bFile,
			Integer replyCnt) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.bDate = bDate;
		this.viewCnt = viewCnt;
		this.bFile = bFile;
		this.replyCnt = replyCnt;
	}

	public Integer getbNo() {
		return bNo;
	}

	public void setbNo(Integer bNo) {
		this.bNo = bNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public Integer getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getbFile() {
		return bFile;
	}

	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	public Integer getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(Integer replyCnt) {
		this.replyCnt = replyCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [bNo=" + bNo + ", title=" + title + ", content=" + content + ", writer=" + writer + ", bDate="
				+ bDate + ", viewCnt=" + viewCnt + ", bFile=" + bFile + ", replyCnt=" + replyCnt + "]";
	}
	
	
} // end BoardVO
