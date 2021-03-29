package com.web.shopping.domain;

import java.util.Date;

/* 
OID	      NUMBER	            NOT NULL		   1	오더아이디
BID	      VARCHAR2(100 BYTE)	NOT NULL		   2	구매자아이디
OCDATE	  TIMESTAMP(6)	        NULL	SYSDATE    3	등록일
ONAME	  VARCHAR2(100 BYTE)	NOT NULL		   4	수령자
OPHONE    VARCHAR2(100 BYTE)	NULL		       5	연락처
OPOST	  VARCHAR2(100 BYTE)	NULL		       6	우편번호
OADDRESS  VARCHAR2(500 BYTE)	NULL		       7	배송주소
OAMOUNT	  NUMBER	            NULL		       8	총결제금액
OPAYMENT  NUMBER	            NULL	           9	결제수단
OINVOICE  NUMBER	            NULL		      10	송장번호
ODELIVERY NUMBER	            NULL		      11	배송비
*/
public class OrderVO {

	private Integer oID;
	private String bID;
	private Date oCDATE;
	private String oNAME;
	private String oPHONE;
	private String oPOST;
	private String oADDRESS;
	private Integer oAMOUNT;
	private Integer oPAYMENT;
	private Integer oINVOICE;
	private Integer oDELIVERY;
	
	// 생성자
	public OrderVO() {}

	public OrderVO(int oID, String bID, Date oCDATE, String oNAME, String oPHONE, String oPOST, String oADDRESS,
			int oAMOUNT, int oPAYMENT, int oINVOICE, int oDELIVERY) {
		this.oID = oID;
		this.bID = bID;
		this.oCDATE = oCDATE;
		this.oNAME = oNAME;
		this.oPHONE = oPHONE;
		this.oPOST = oPOST;
		this.oADDRESS = oADDRESS;
		this.oAMOUNT = oAMOUNT;
		this.oPAYMENT = oPAYMENT;
		this.oINVOICE = oINVOICE;
		this.oDELIVERY = oDELIVERY;
	}

	// getter / setter 
	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public String getbID() {
		return bID;
	}

	public void setbID(String bID) {
		this.bID = bID;
	}

	public Date getoCDATE() {
		return oCDATE;
	}

	public void setoCDATE(Date oCDATE) {
		this.oCDATE = oCDATE;
	}

	public String getoNAME() {
		return oNAME;
	}

	public void setoNAME(String oNAME) {
		this.oNAME = oNAME;
	}

	public String getoPHONE() {
		return oPHONE;
	}

	public void setoPHONE(String oPHONE) {
		this.oPHONE = oPHONE;
	}

	public String getoPOST() {
		return oPOST;
	}

	public void setoPOST(String oPOST) {
		this.oPOST = oPOST;
	}

	public String getoADDRESS() {
		return oADDRESS;
	}

	public void setoADDRESS(String oADDRESS) {
		this.oADDRESS = oADDRESS;
	}

	public int getoAMOUNT() {
		return oAMOUNT;
	}

	public void setoAMOUNT(int oAMOUNT) {
		this.oAMOUNT = oAMOUNT;
	}

	public int getoPAYMENT() {
		return oPAYMENT;
	}

	public void setoPAYMENT(int oPAYMENT) {
		this.oPAYMENT = oPAYMENT;
	}

	public int getoINVOICE() {
		return oINVOICE;
	}

	public void setoINVOICE(int oINVOICE) {
		this.oINVOICE = oINVOICE;
	}

	public int getoDELIVERY() {
		return oDELIVERY;
	}

	public void setoDELIVERY(int oDELIVERY) {
		this.oDELIVERY = oDELIVERY;
	}

	// toString
	@Override
	public String toString() {
		return "OrderVO [oID=" + oID + ", bID=" + bID + ", oCDATE=" + oCDATE + ", oNAME=" + oNAME + ", oPHONE=" + oPHONE
				+ ", oPOST=" + oPOST + ", oADDRESS=" + oADDRESS + ", oAMOUNT=" + oAMOUNT + ", oPAYMENT=" + oPAYMENT
				+ ", oINVOICE=" + oINVOICE + ", oDELIVERY=" + oDELIVERY + "]";
	}
	
} // end OrderVO
