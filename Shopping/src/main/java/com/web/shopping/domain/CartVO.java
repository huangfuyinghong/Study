package com.web.shopping.domain;

/* 
CID	  NUMBER	            NOT NULL	1	장바구니번호
BID	  VARCHAR2(100 BYTE)	NULL		2	구매자아이디
PID	  NUMBER	            NULL	    3	제품아이디
CQTY  NUMBER	            NOT NULL	4	제품수량
*/
public class CartVO {

	private Integer cID;
	private String bID;
	private Integer pID;
	private Integer cQTY;
	
	// 생성자
	public CartVO() {}

	public CartVO(int cID, String bID, int pID, int cQTY) {
		this.cID = cID;
		this.bID = bID;
		this.pID = pID;
		this.cQTY = cQTY;
	}

	// getter / setter 
	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
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

	public int getcQTY() {
		return cQTY;
	}

	public void setcQTY(int cQTY) {
		this.cQTY = cQTY;
	}

	// toString
	@Override
	public String toString() {
		return "CartVO [cID=" + cID + ", bID=" + bID + ", pID=" + pID + ", cQTY=" + cQTY + "]";
	}
	
} // end CartVO
