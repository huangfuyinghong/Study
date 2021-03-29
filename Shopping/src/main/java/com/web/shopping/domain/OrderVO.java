package com.web.shopping.domain;

import java.util.Date;

/* 
OID	      NUMBER	            NOT NULL		   1	�������̵�
BID	      VARCHAR2(100 BYTE)	NOT NULL		   2	�����ھ��̵�
OCDATE	  TIMESTAMP(6)	        NULL	SYSDATE    3	�����
ONAME	  VARCHAR2(100 BYTE)	NOT NULL		   4	������
OPHONE    VARCHAR2(100 BYTE)	NULL		       5	����ó
OPOST	  VARCHAR2(100 BYTE)	NULL		       6	�����ȣ
OADDRESS  VARCHAR2(500 BYTE)	NULL		       7	����ּ�
OAMOUNT	  NUMBER	            NULL		       8	�Ѱ����ݾ�
OPAYMENT  NUMBER	            NULL	           9	��������
OINVOICE  NUMBER	            NULL		      10	�����ȣ
ODELIVERY NUMBER	            NULL		      11	��ۺ�
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
	
	// ������
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
