package com.web.shopping.domain;
/* 
ODID	NUMBER	NOT NULL	1	�����󼼾��̵�
OID	    NUMBER	NULL	    2	�������̵�
PID	    NUMBER	NULL		3	��ǰ���̵�
ODQTY	NUMBER	NULL		4	��ǰ�����ż���
*/
public class OrderDetailVO {

	private Integer odID;
	private Integer oID;
	private Integer pID;
	private Integer odQTY;
	
	// ������
	public OrderDetailVO() {}

	public OrderDetailVO(int odID, int oID, int pID, int odQTY) {
		this.odID = odID;
		this.oID = oID;
		this.pID = pID;
		this.odQTY = odQTY;
	}

	// getter / setter 
	public int getOdID() {
		return odID;
	}

	public void setOdID(int odID) {
		this.odID = odID;
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

	public int getOdQTY() {
		return odQTY;
	}

	public void setOdQTY(int odQTY) {
		this.odQTY = odQTY;
	}

	// toString
	@Override
	public String toString() {
		return "OrderDetailVO [odID=" + odID + ", oID=" + oID + ", pID=" + pID + ", odQTY=" + odQTY + "]";
	}

} // end OrderDetailVO
