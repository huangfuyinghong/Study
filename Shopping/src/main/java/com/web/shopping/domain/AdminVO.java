package com.web.shopping.domain;

import java.util.Date;

/* 
	ANO	   NUMBER	            Not	NULL  ��ȣ
AID	   VARCHAR2(100 BYTE)	Not	NULL  ���̵�
APW	   VARCHAR2(100 BYTE)	Not	NULL  ��й�ȣ
ANAME  VARCHAR2(100 BYTE)	NULL      �̸�
ALEVEL NUMBER	            NULL      ����
ACDATE TIMESTAMP(6)	    	SYSDATE   �����
*/
public class AdminVO {

	private Integer aNO;
	private String aID;
	private String aPW;
	private String aNAME;
	private Integer aLEVEL;
	private Date aCDATE;
	
	// ������
	public AdminVO() {}

	public AdminVO(int aNO, String aID, String aPW, String aNAME, int aLEVEL, Date aCDATE) {
		this.aNO = aNO;
		this.aID = aID;
		this.aPW = aPW;
		this.aNAME = aNAME;
		this.aLEVEL = aLEVEL;
		this.aCDATE = aCDATE;
	}
	
	// getter / setter 
	public int getaNO() {
		return aNO;
	}

	public void setaNO(int aNO) {
		this.aNO = aNO;
	}

	public String getaID() {
		return aID;
	}

	public void setaID(String aID) {
		this.aID = aID;
	}

	public String getaPW() {
		return aPW;
	}

	public void setaPW(String aPW) {
		this.aPW = aPW;
	}

	public String getaNAME() {
		return aNAME;
	}

	public void setaNAME(String aNAME) {
		this.aNAME = aNAME;
	}

	public int getaLEVEL() {
		return aLEVEL;
	}

	public void setaLEVEL(int aLEVEL) {
		this.aLEVEL = aLEVEL;
	}

	public Date getaCDATE() {
		return aCDATE;
	}

	public void setaCDATE(Date aCDATE) {
		this.aCDATE = aCDATE;
	}

	// toString 
	@Override
	public String toString() {
		return "AdminVO [aNO=" + aNO + ", aID=" + aID + ", aPW=" + aPW + ", aNAME=" + aNAME + ", aLEVEL=" + aLEVEL
				+ ", aCDATE=" + aCDATE + "]";
	}

} // end AdminVO
