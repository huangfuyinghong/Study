package com.web.shopping.domain;

import java.util.Date;

/*
PQID	    NUMBER	            NOT NULL		1	제품관련문의글아이디
PQCATE	    NUMBER	            NULL		    2	문의카테고리
PQWRITER	VARCHAR2(100 BYTE)	NULL		    3	문의글작성자
PQTITLE	    VARCHAR2(100 BYTE)	NULL		    4	문의글제목
PQCONTENT	VARCHAR2(1000 BYTE)	NULL	        5	문의글내용
PQFILE	    VARCHAR2(1000 BYTE)	NULL		    6	문의글첨부파일
PQCDATE	    TIMESTAMP(6)	    NULL	SYSDATE 7	등록일
PID	        NUMBER	            NULL		    8	제품아이디
REPLYCOUNT	NUMBER	            NULL	        9	답변 수
 */
public class PqnaVO {
	
	private Integer pqID;
	private String pqCATE; 
	private String pqWRITER;
	private String pqTITLE;
	private String pqCONTENT;
	private String pqFILE;
	private Date pqCDATE;
	private Integer pID;
	private Integer replyCOUNT;
	
	// 생성자
	public PqnaVO() {}

	public PqnaVO(Integer pqID, String pqCATE, String pqWRITER, String pqTITLE, String pqCONTENT, String pqFILE,
			Date pqCDATE, Integer pID, Integer replyCOUNT) {
		super();
		this.pqID = pqID;
		this.pqCATE = pqCATE;
		this.pqWRITER = pqWRITER;
		this.pqTITLE = pqTITLE;
		this.pqCONTENT = pqCONTENT;
		this.pqFILE = pqFILE;
		this.pqCDATE = pqCDATE;
		this.pID = pID;
		this.replyCOUNT = replyCOUNT;
	}

	public Integer getPqID() {
		return pqID;
	}

	public void setPqID(Integer pqID) {
		this.pqID = pqID;
	}

	public String getPqCATE() {
		return pqCATE;
	}

	public void setPqCATE(String pqCATE) {
		this.pqCATE = pqCATE;
	}

	public String getPqWRITER() {
		return pqWRITER;
	}

	public void setPqWRITER(String pqWRITER) {
		this.pqWRITER = pqWRITER;
	}

	public String getPqTITLE() {
		return pqTITLE;
	}

	public void setPqTITLE(String pqTITLE) {
		this.pqTITLE = pqTITLE;
	}

	public String getPqCONTENT() {
		return pqCONTENT;
	}

	public void setPqCONTENT(String pqCONTENT) {
		this.pqCONTENT = pqCONTENT;
	}

	public String getPqFILE() {
		return pqFILE;
	}

	public void setPqFILE(String pqFILE) {
		this.pqFILE = pqFILE;
	}

	public Date getPqCDATE() {
		return pqCDATE;
	}

	public void setPqCDATE(Date pqCDATE) {
		this.pqCDATE = pqCDATE;
	}

	public Integer getpID() {
		return pID;
	}

	public void setpID(Integer pID) {
		this.pID = pID;
	}

	public Integer getReplyCOUNT() {
		return replyCOUNT;
	}

	public void setReplyCOUNT(Integer replyCOUNT) {
		this.replyCOUNT = replyCOUNT;
	}

	@Override
	public String toString() {
		return "PqnaVO [pqID=" + pqID + ", pqCATE=" + pqCATE + ", pqWRITER=" + pqWRITER + ", pqTITLE=" + pqTITLE
				+ ", pqCONTENT=" + pqCONTENT + ", pqFILE=" + pqFILE + ", pqCDATE=" + pqCDATE + ", pID=" + pID
				+ ", replyCOUNT=" + replyCOUNT + "]";
	}
	
} // end PqnaVO
