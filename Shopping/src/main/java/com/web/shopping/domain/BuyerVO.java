package com.web.shopping.domain;

import java.util.Date;

/*
BNO	      NUMBER	            NOT NULL		1	번호
BID	      VARCHAR2(100 BYTE)	NOT NULL		2	아이디
BPW	      VARCHAR2(100 BYTE)	NOT NULL		3	비밀번호
BPHONE	  VARCHAR2(100 BYTE)	NULL	        4	휴대전화번호
BEMAIL	  VARCHAR2(100 BYTE)	NULL	        5	이메일
BPOST	  VARCHAR2(20 BYTE)	    NULL	        6	우편번호
BADDRESS  VARCHAR2(300 BYTE)	NULL	        7	주소
BBIRTH	  DATE	                NULL	        8	생일
BLICENSE  VARCHAR2(500 BYTE)	NULL		    9	사업자등록증 첨부
BTEMRS	  NUMBER	            NULL	 	10	약관동의여부
BCDATE	  TIMESTAMP(6)	        NULL	SYSDATE 	11	등록일
BLEVEL	  NUMBER	            NULL	 	12	고객등급
BBUY      NUMBER	            NULL	 	13	누적구매수
BDROP	  NUMBER	            NULL	 	14	탈퇴여부
 */
public class BuyerVO {

	private Integer bNO;
	private String bID;
	private String bPW;
	private String bPHONE;
	private String bEMAIL;
	private String bPOST;
	private String bADDRESS;
	private String bBIRTH;
	private String bLICENSE;
	private Integer    bTEMRS;
	private Date   bCDATE;
	private Integer    bLEVEL;
	private Integer    bBUY;
	private Integer    bDROP;
	
	// 생성자
	public BuyerVO() {}

	public BuyerVO(int bNO, String bID, String bPW, String bPHONE, String bEMAIL, String bPOST, String bADDRESS,
			String bBIRTH, String bLICENSE, int bTEMRS, Date bCDATE, int bLEVEL, int bBUY, int bDROP) {
		super();
		this.bNO = bNO;
		this.bID = bID;
		this.bPW = bPW;
		this.bPHONE = bPHONE;
		this.bEMAIL = bEMAIL;
		this.bPOST = bPOST;
		this.bADDRESS = bADDRESS;
		this.bBIRTH = bBIRTH;
		this.bLICENSE = bLICENSE;
		this.bTEMRS = bTEMRS;
		this.bCDATE = bCDATE;
		this.bLEVEL = bLEVEL;
		this.bBUY = bBUY;
		this.bDROP = bDROP;
	}

	// getter / setter 
	public int getbNO() {
		return bNO;
	}

	public void setbNO(int bNO) {
		this.bNO = bNO;
	}

	public String getbID() {
		return bID;
	}

	public void setbID(String bID) {
		this.bID = bID;
	}

	public String getbPW() {
		return bPW;
	}

	public void setbPW(String bPW) {
		this.bPW = bPW;
	}

	public String getbPHONE() {
		return bPHONE;
	}

	public void setbPHONE(String bPHONE) {
		this.bPHONE = bPHONE;
	}

	public String getbEMAIL() {
		return bEMAIL;
	}

	public void setbEMAIL(String bEMAIL) {
		this.bEMAIL = bEMAIL;
	}

	public String getbPOST() {
		return bPOST;
	}

	public void setbPOST(String bPOST) {
		this.bPOST = bPOST;
	}

	public String getbADDRESS() {
		return bADDRESS;
	}

	public void setbADDRESS(String bADDRESS) {
		this.bADDRESS = bADDRESS;
	}

	public String getbBIRTH() {
		return bBIRTH;
	}

	public void setbBIRTH(String bBIRTH) {
		this.bBIRTH = bBIRTH;
	}

	public String getbLICENSE() {
		return bLICENSE;
	}

	public void setbLICENSE(String bLICENSE) {
		this.bLICENSE = bLICENSE;
	}

	public int getbTEMRS() {
		return bTEMRS;
	}

	public void setbTEMRS(int bTEMRS) {
		this.bTEMRS = bTEMRS;
	}

	public Date getbCDATE() {
		return bCDATE;
	}

	public void setbCDATE(Date bCDATE) {
		this.bCDATE = bCDATE;
	}

	public int getbLEVEL() {
		return bLEVEL;
	}

	public void setbLEVEL(int bLEVEL) {
		this.bLEVEL = bLEVEL;
	}

	public int getbBUY() {
		return bBUY;
	}

	public void setbBUY(int bBUY) {
		this.bBUY = bBUY;
	}

	public int getbDROP() {
		return bDROP;
	}

	public void setbDROP(int bDROP) {
		this.bDROP = bDROP;
	}

	// toString 
	@Override
	public String toString() {
		return "BuyerVO [bNO=" + bNO + ", bID=" + bID + ", bPW=" + bPW + ", bPHONE=" + bPHONE + ", bEMAIL=" + bEMAIL
				+ ", bPOST=" + bPOST + ", bADDRESS=" + bADDRESS + ", bBIRTH=" + bBIRTH + ", bLICENSE=" + bLICENSE
				+ ", bTEMRS=" + bTEMRS + ", bCDATE=" + bCDATE + ", bLEVEL=" + bLEVEL + ", bBUY=" + bBUY + ", bDROP="
				+ bDROP + "]";
	}

	
} // end BuyerVO
