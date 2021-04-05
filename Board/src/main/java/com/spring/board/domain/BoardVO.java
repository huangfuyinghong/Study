package com.spring.board.domain;

import java.util.Date;

/*
BNO	      NUMBER	            No		       1	�Խñ� ��ȣ
TITLE	  VARCHAR2(500 BYTE)	No		       2	�Խñ� ����
CONTENT	  VARCHAR2(1000 BYTE)	No		       3 	�Խñ� ����
WRITER	  VARCHAR2(100 BYTE)	No		       4	�Խñ� �ۼ���
BDATE	  TIMESTAMP(6)	        No	 SYSDATE   5	�Խñ� ������
VIEWCNT	  NUMBER	            Yes	    0      6	�Խñ� ������
BFILE	  VARCHAR2(1000 BYTE)	Yes		       7	�Խñ� ����÷��
REPLYCNT  NUMBER	            Yes		0      8	��� ��
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
