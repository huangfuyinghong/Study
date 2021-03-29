package com.web.shopping.domain;

import java.util.Date;

/*
PID	       NUMBER	            NOT NULL		   1	상품번호
SID	       VARCHAR2(100 BYTE)	NOT NULL		   2	판매자아이디
PNAME	   VARCHAR2(300 BYTE)	NOT NULL	       3	상품명
PDISCOUNT  NUMBER	            NOT NULL	0 	   4	할인율
PSTOCK	   NUMBER	            NOT NULL	0 	   5	재고수량
PIMG1	   VARCHAR2(1000 BYTE)	NOT NULL		   6	대표이미지
PIMG2	   VARCHAR2(1000 BYTE)	NULL		       7	추가이미지2
PIMG3	   VARCHAR2(1000 BYTE)	NULL		       8	추가이미지3
PDETAIL	   CLOB	                NOT NULL		   9	상세정보
PDELIVERY  NUMBER	            NOT NULL	0 	   10	배송조건
PCDATE	   TIMESTAMP(6)	        NOT NULL	SYSDATE  11	등록일
PHIT	   NUMBER	            NOT NULL		   12	상품열람수
PSELL	   NUMBER	            NOT NULL		   13	상품판매량
CATECODE   VARCHAR2(100 BYTE)	No		           14	카테고리 코드
PPRICE	   NUMBER	            No		           15	상품가격
 */
public class ProductVO {

	private Integer pID;
	private String sID;
	private String pNAME;
	private Integer pDISCOUNT;
	private Integer pSTOCK;
	private String pIMG1;
	private String pIMG2;
	private String pIMG3;
	private String pDETAIL;
	private Integer pDELIVERY;
	private Date pCDATE;
	private Integer pHIT;
	private Integer pSELL;
	private String cateCode;
	private Integer pPRICE;
	
	
	// 생성자
	public ProductVO() {}


	public ProductVO(Integer pID, String sID, String pNAME, Integer pDISCOUNT, Integer pSTOCK, String pIMG1,
			String pIMG2, String pIMG3, String pDETAIL, Integer pDELIVERY, Date pCDATE, Integer pHIT, Integer pSELL,
			String cateCode, Integer pPRICE) {
		super();
		this.pID = pID;
		this.sID = sID;
		this.pNAME = pNAME;
		this.pDISCOUNT = pDISCOUNT;
		this.pSTOCK = pSTOCK;
		this.pIMG1 = pIMG1;
		this.pIMG2 = pIMG2;
		this.pIMG3 = pIMG3;
		this.pDETAIL = pDETAIL;
		this.pDELIVERY = pDELIVERY;
		this.pCDATE = pCDATE;
		this.pHIT = pHIT;
		this.pSELL = pSELL;
		this.cateCode = cateCode;
		this.pPRICE = pPRICE;
	}


	public Integer getpID() {
		return pID;
	}


	public void setpID(Integer pID) {
		this.pID = pID;
	}


	public String getsID() {
		return sID;
	}


	public void setsID(String sID) {
		this.sID = sID;
	}


	public String getpNAME() {
		return pNAME;
	}


	public void setpNAME(String pNAME) {
		this.pNAME = pNAME;
	}


	public Integer getpDISCOUNT() {
		return pDISCOUNT;
	}


	public void setpDISCOUNT(Integer pDISCOUNT) {
		this.pDISCOUNT = pDISCOUNT;
	}


	public Integer getpSTOCK() {
		return pSTOCK;
	}


	public void setpSTOCK(Integer pSTOCK) {
		this.pSTOCK = pSTOCK;
	}


	public String getpIMG1() {
		return pIMG1;
	}


	public void setpIMG1(String pIMG1) {
		this.pIMG1 = pIMG1;
	}


	public String getpIMG2() {
		return pIMG2;
	}


	public void setpIMG2(String pIMG2) {
		this.pIMG2 = pIMG2;
	}


	public String getpIMG3() {
		return pIMG3;
	}


	public void setpIMG3(String pIMG3) {
		this.pIMG3 = pIMG3;
	}


	public String getpDETAIL() {
		return pDETAIL;
	}


	public void setpDETAIL(String pDETAIL) {
		this.pDETAIL = pDETAIL;
	}


	public Integer getpDELIVERY() {
		return pDELIVERY;
	}


	public void setpDELIVERY(Integer pDELIVERY) {
		this.pDELIVERY = pDELIVERY;
	}


	public Date getpCDATE() {
		return pCDATE;
	}


	public void setpCDATE(Date pCDATE) {
		this.pCDATE = pCDATE;
	}


	public Integer getpHIT() {
		return pHIT;
	}


	public void setpHIT(Integer pHIT) {
		this.pHIT = pHIT;
	}


	public Integer getpSELL() {
		return pSELL;
	}


	public void setpSELL(Integer pSELL) {
		this.pSELL = pSELL;
	}


	public String getCateCode() {
		return cateCode;
	}


	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}


	public Integer getpPRICE() {
		return pPRICE;
	}


	public void setpPRICE(Integer pPRICE) {
		this.pPRICE = pPRICE;
	}


	@Override
	public String toString() {
		return "ProductVO [pID=" + pID + ", sID=" + sID + ", pNAME=" + pNAME + ", pDISCOUNT=" + pDISCOUNT + ", pSTOCK="
				+ pSTOCK + ", pIMG1=" + pIMG1 + ", pIMG2=" + pIMG2 + ", pIMG3=" + pIMG3 + ", pDETAIL=" + pDETAIL
				+ ", pDELIVERY=" + pDELIVERY + ", pCDATE=" + pCDATE + ", pHIT=" + pHIT + ", pSELL=" + pSELL
				+ ", cateCode=" + cateCode + ", pPRICE=" + pPRICE + "]";
	}

	
} // end ProducntVO
