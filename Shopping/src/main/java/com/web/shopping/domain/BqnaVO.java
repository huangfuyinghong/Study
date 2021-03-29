package com.web.shopping.domain;

import java.util.Date;

/*
BQID	   NUMBER	            NOT NULL		1	구매자문의글아이디
BQCATE	   VARCHAR2(100 BYTE)   NULL		    2	문의글카테고리
BQWRITER   VARCHAR2(100 BYTE)	NULL		    3	문의글작성자
BQTITLE	   VARCHAR2(100 BYTE)	NULL		    4	문의글제목
BQCONTENT  VARCHAR2(1000 BYTE)	NULL		    5	문의글내용
BQFILE	   VARCHAR2(1000 BYTE)	NULL		    6	첨부파일
BQCDATE	   TIMESTAMP(6)	        NULL  SYSDATE   7	등록일
REPLYCOUNT NUMBER	            NULL	        8	답변 수
*/
public class BqnaVO {
	
	private Integer bqID;
	private String bqCATE;
	private String bqWRITER;
	private String bqTITLE;
	private String bqCONTENT;
	private String bqFILE;
	private Date bqCDATE;
	private Integer replyCOUNT;
	
	// 생성자
	public BqnaVO() {}

	public BqnaVO(Integer bqID, String bqCATE, String bqWRITER, String bqTITLE, String bqCONTENT, String bqFILE,
			Date bqCDATE, Integer replyCOUNT) {
		super();
		this.bqID = bqID;
		this.bqCATE = bqCATE;
		this.bqWRITER = bqWRITER;
		this.bqTITLE = bqTITLE;
		this.bqCONTENT = bqCONTENT;
		this.bqFILE = bqFILE;
		this.bqCDATE = bqCDATE;
		this.replyCOUNT = replyCOUNT;
	}

	public Integer getBqID() {
		return bqID;
	}

	public void setBqID(Integer bqID) {
		this.bqID = bqID;
	}

	public String getBqCATE() {
		return bqCATE;
	}

	public void setBqCATE(String bqCATE) {
		this.bqCATE = bqCATE;
	}

	public String getBqWRITER() {
		return bqWRITER;
	}

	public void setBqWRITER(String bqWRITER) {
		this.bqWRITER = bqWRITER;
	}

	public String getBqTITLE() {
		return bqTITLE;
	}

	public void setBqTITLE(String bqTITLE) {
		this.bqTITLE = bqTITLE;
	}

	public String getBqCONTENT() {
		return bqCONTENT;
	}

	public void setBqCONTENT(String bqCONTENT) {
		this.bqCONTENT = bqCONTENT;
	}

	public String getBqFILE() {
		return bqFILE;
	}

	public void setBqFILE(String bqFILE) {
		this.bqFILE = bqFILE;
	}

	public Date getBqCDATE() {
		return bqCDATE;
	}

	public void setBqCDATE(Date bqCDATE) {
		this.bqCDATE = bqCDATE;
	}

	public Integer getReplyCOUNT() {
		return replyCOUNT;
	}

	public void setReplyCOUNT(Integer replyCOUNT) {
		this.replyCOUNT = replyCOUNT;
	}

	@Override
	public String toString() {
		return "BqnaVO [bqID=" + bqID + ", bqCATE=" + bqCATE + ", bqWRITER=" + bqWRITER + ", bqTITLE=" + bqTITLE
				+ ", bqCONTENT=" + bqCONTENT + ", bqFILE=" + bqFILE + ", bqCDATE=" + bqCDATE + ", replyCOUNT="
				+ replyCOUNT + "]";
	}
	
} // end BqnaVO
