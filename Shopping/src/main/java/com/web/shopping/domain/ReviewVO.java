package com.web.shopping.domain;

import java.util.Date;

/* 
RID	        NUMBER	            NOT NULL        1	리뷰아이디
OID	        NUMBER	            NULL		    2	주문아이디
PID	        NUMBER	            NULL		    3	제품아이디
RWRITER	    VARCHAR2(100 BYTE)	NULL		    4	리뷰작성자
RTITLE	    VARCHAR2(200 BYTE)	NULL		    5	리뷰제목
RCONTENT	VARCHAR2(1000 BYTE)	NULL		    6	리뷰내용
RIMG	    VARCHAR2(1000 BYTE)	NULL		    7	리뷰이미지
RIMG2	    VARCHAR2(1000 BYTE)	NULL		    8	리뷰이미지2
RCDATE	    TIMESTAMP(6)	    NULL	SYSDATE 9	등록일
RHIT	    NUMBER	            NULL		    10	조회수
*/
public class ReviewVO {

	private Integer rID;
	private Integer oID;
	private Integer pID;
	private String rWRITER;
	private String rTITLE;
	private String rCONTENT;
	private String rIMG;
	private String rIMG2;
	private Date rCDATE;
	private Integer rHIT;
	
	// 생성자
	public ReviewVO() {}

	public ReviewVO(int rID, int oID, int pID, String rWRITER, String rTITLE, String rCONTENT, String rIMG,
			String rIMG2, Date rCDATE, int rHIT) {
		this.rID = rID;
		this.oID = oID;
		this.pID = pID;
		this.rWRITER = rWRITER;
		this.rTITLE = rTITLE;
		this.rCONTENT = rCONTENT;
		this.rIMG = rIMG;
		this.rIMG2 = rIMG2;
		this.rCDATE = rCDATE;
		this.rHIT = rHIT;
	}

	// getter / setter 
	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getrWRITER() {
		return rWRITER;
	}

	public void setrWRITER(String rWRITER) {
		this.rWRITER = rWRITER;
	}

	public String getrTITLE() {
		return rTITLE;
	}

	public void setrTITLE(String rTITLE) {
		this.rTITLE = rTITLE;
	}

	public String getrCONTENT() {
		return rCONTENT;
	}

	public void setrCONTENT(String rCONTENT) {
		this.rCONTENT = rCONTENT;
	}

	public String getrIMG() {
		return rIMG;
	}

	public void setrIMG(String rIMG) {
		this.rIMG = rIMG;
	}

	public String getrIMG2() {
		return rIMG2;
	}

	public void setrIMG2(String rIMG2) {
		this.rIMG2 = rIMG2;
	}

	public Date getrCDATE() {
		return rCDATE;
	}

	public void setrCDATE(Date rCDATE) {
		this.rCDATE = rCDATE;
	}

	public int getrHIT() {
		return rHIT;
	}

	public void setrHIT(int rHIT) {
		this.rHIT = rHIT;
	}

	// toString
	@Override
	public String toString() {
		return "ReviewVO [rID=" + rID + ", oID=" + oID + ", pID=" + pID + ", rWRITER=" + rWRITER + ", rTITLE=" + rTITLE
				+ ", rCONTENT=" + rCONTENT + ", rIMG=" + rIMG + ", rIMG2=" + rIMG2 + ", rCDATE=" + rCDATE + ", rHIT="
				+ rHIT + "]";
	} 
	
} // end ReviewVO
