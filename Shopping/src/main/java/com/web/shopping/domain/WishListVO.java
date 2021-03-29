package com.web.shopping.domain;

/*
WID	 NUMBER	            NOT NULL	1	찜아이디
BID	 VARCHAR2(100 BYTE)	NULL		2	구매자아이디
PID	 NUMBER	            NULL		3	제품아이디
*/

public class WishListVO {

	private Integer wID;
	private String bID;
	private Integer pID;
	
	// 생성자 
	public WishListVO() {}

	public WishListVO(int wID, String bID, int pID) {
		this.wID = wID;
		this.bID = bID;
		this.pID = pID;
	}

	// getter / setter 
	public int getwID() {
		return wID;
	}

	public void setwID(int wID) {
		this.wID = wID;
	}

	public String getbID() {
		return bID;
	}

	public void setbID(String bID) {
		this.bID = bID;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	// toString
	@Override
	public String toString() {
		return "WishListVO [wID=" + wID + ", bID=" + bID + ", pID=" + pID + "]";
	} 
	
} // end WishListVO
