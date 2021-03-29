package com.web.shopping.domain;

import java.util.Date;

/*
PQID	    NUMBER	            NOT NULL		1	��ǰ���ù��Ǳ۾��̵�
PQCATE	    NUMBER	            NULL		    2	����ī�װ�
PQWRITER	VARCHAR2(100 BYTE)	NULL		    3	���Ǳ��ۼ���
PQTITLE	    VARCHAR2(100 BYTE)	NULL		    4	���Ǳ�����
PQCONTENT	VARCHAR2(1000 BYTE)	NULL	        5	���Ǳ۳���
PQFILE	    VARCHAR2(1000 BYTE)	NULL		    6	���Ǳ�÷������
PQCDATE	    TIMESTAMP(6)	    NULL	SYSDATE 7	�����
PID	        NUMBER	            NULL		    8	��ǰ���̵�
REPLYCOUNT	NUMBER	            NULL	        9	�亯 ��
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
	
	// ������
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
