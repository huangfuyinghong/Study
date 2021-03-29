package com.web.shopping.domain;

import java.util.Date;

/*  
SQID	    NUMBER	            NOT NULL		1	�Ǹ��ڹ��Ǿ��̵�
SQCATE	    NUMBER	            NULL		    2	����ī�װ�
SQWRITER	VARCHAR2(100 BYTE)	NULL	        3	���Ǳ��ۼ���
SQTITLE	    VARCHAR2(100 BYTE)	NULL	        4	���Ǳ�����
SQCONTENT	VARCHAR2(1000 BYTE)	NULL		    5	���Ǳ۳���
SQFILE	    VARCHAR2(1000 BYTE)	NULL	        6	���Ǳ�÷������
SQCDATE	    TIMESTAMP(6)	    NULL	SYSDATE 7	�����
REPLYCOUNT	NUMBER	            NULL		    8	�亯 ��
*/
public class SqnaVO {

	private Integer sqID;
	private String sqCATE;
	private String sqWRITER;
	private String sqTITLE;
	private String sqCONTENT;
	private String sqFILE;
	private Date sqCDATE;
	private Integer replyCOUNT;
	
	// ������
	public SqnaVO() {}

	public SqnaVO(Integer sqID, String sqCATE, String sqWRITER, String sqTITLE, String sqCONTENT, String sqFILE,
			Date sqCDATE, Integer replyCOUNT) {
		super();
		this.sqID = sqID;
		this.sqCATE = sqCATE;
		this.sqWRITER = sqWRITER;
		this.sqTITLE = sqTITLE;
		this.sqCONTENT = sqCONTENT;
		this.sqFILE = sqFILE;
		this.sqCDATE = sqCDATE;
		this.replyCOUNT = replyCOUNT;
	}

	public Integer getSqID() {
		return sqID;
	}

	public void setSqID(Integer sqID) {
		this.sqID = sqID;
	}

	public String getSqCATE() {
		return sqCATE;
	}

	public void setSqCATE(String sqCATE) {
		this.sqCATE = sqCATE;
	}

	public String getSqWRITER() {
		return sqWRITER;
	}

	public void setSqWRITER(String sqWRITER) {
		this.sqWRITER = sqWRITER;
	}

	public String getSqTITLE() {
		return sqTITLE;
	}

	public void setSqTITLE(String sqTITLE) {
		this.sqTITLE = sqTITLE;
	}

	public String getSqCONTENT() {
		return sqCONTENT;
	}

	public void setSqCONTENT(String sqCONTENT) {
		this.sqCONTENT = sqCONTENT;
	}

	public String getSqFILE() {
		return sqFILE;
	}

	public void setSqFILE(String sqFILE) {
		this.sqFILE = sqFILE;
	}

	public Date getSqCDATE() {
		return sqCDATE;
	}

	public void setSqCDATE(Date sqCDATE) {
		this.sqCDATE = sqCDATE;
	}

	public Integer getReplyCOUNT() {
		return replyCOUNT;
	}

	public void setReplyCOUNT(Integer replyCOUNT) {
		this.replyCOUNT = replyCOUNT;
	}

	@Override
	public String toString() {
		return "SqnaVO [sqID=" + sqID + ", sqCATE=" + sqCATE + ", sqWRITER=" + sqWRITER + ", sqTITLE=" + sqTITLE
				+ ", sqCONTENT=" + sqCONTENT + ", sqFILE=" + sqFILE + ", sqCDATE=" + sqCDATE + ", replyCOUNT="
				+ replyCOUNT + "]";
	}

	
} // end SqnaVO
