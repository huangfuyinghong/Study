package com.web.shopping.domain;

import java.util.Date;

/* 
SNO	      NUMBER	            NOT NULL		   1	번호         PK 
SID	      VARCHAR2(100 BYTE)	NOT NULL		   2	아이디
SPW	      VARCHAR2(100 BYTE)	NOT NULL		   3	비밀번호
SPHONE	  VARCHAR2(100 BYTE)	NULL		       4	휴대전화번호
SEMAIL	  VARCHAR2(100 BYTE)	NULL		       5	아메일
SADDRESS  VARCHAR2(500 BYTE)	NULL		       6	주소
SBUILD	  VARCHAR2(100 BYTE)	NULL		       7	빌딩이름
SBUILDNO  VARCHAR2(100 BYTE)	NULL		       8	매장번호
SLICENCE  VARCHAR2(1000 BYTE)	NULL		       9	사업자등록증
SBANK	  VARCHAR2(1000 BYTE)	NULL		       10	통장사본
STEMRS	  NUMBER	            NOT NULL	0 	   11	약관동의여부
SCDATE	  TIMESTAMP(6)	        NOT NULL	SYSDATE  12	등록일
SLEVEL	  NUMBER	            NOT NULL	0 	   13	권한
SDROP	  NUMBER	            NOT NULL	0 	   14	탈퇴여부 
SNAME	  VARCHAR2(100 BYTE)	NOT NULL	       15	SHOP 이름    UNIQUE
 */
public class SellerVO {

	private Integer sNO;
	private String sID;
	private String sPW;
	private String sPHONE;
	private String sEMAIL;
	private String sADDRESS;
	private String sBUILD;
	private String sBUILDNO;
	private String sLICENCE;
	private String sBANK;
	private Integer sTEMRS;
	private Date sCDATE;
	private Integer sLEVEL;
	private Integer sDROP;
	private String sNAME;
	
	// 생성자
	public SellerVO() {}

	public SellerVO(Integer sNO, String sID, String sPW, String sPHONE, String sEMAIL, String sADDRESS, String sBUILD,
			String sBUILDNO, String sLICENCE, String sBANK, Integer sTEMRS, Date sCDATE, Integer sLEVEL, Integer sDROP,
			String sNAME) {
		super();
		this.sNO = sNO;
		this.sID = sID;
		this.sPW = sPW;
		this.sPHONE = sPHONE;
		this.sEMAIL = sEMAIL;
		this.sADDRESS = sADDRESS;
		this.sBUILD = sBUILD;
		this.sBUILDNO = sBUILDNO;
		this.sLICENCE = sLICENCE;
		this.sBANK = sBANK;
		this.sTEMRS = sTEMRS;
		this.sCDATE = sCDATE;
		this.sLEVEL = sLEVEL;
		this.sDROP = sDROP;
		this.sNAME = sNAME;
	}

	public Integer getsNO() {
		return sNO;
	}

	public void setsNO(Integer sNO) {
		this.sNO = sNO;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getsPW() {
		return sPW;
	}

	public void setsPW(String sPW) {
		this.sPW = sPW;
	}

	public String getsPHONE() {
		return sPHONE;
	}

	public void setsPHONE(String sPHONE) {
		this.sPHONE = sPHONE;
	}

	public String getsEMAIL() {
		return sEMAIL;
	}

	public void setsEMAIL(String sEMAIL) {
		this.sEMAIL = sEMAIL;
	}

	public String getsADDRESS() {
		return sADDRESS;
	}

	public void setsADDRESS(String sADDRESS) {
		this.sADDRESS = sADDRESS;
	}

	public String getsBUILD() {
		return sBUILD;
	}

	public void setsBUILD(String sBUILD) {
		this.sBUILD = sBUILD;
	}

	public String getsBUILDNO() {
		return sBUILDNO;
	}

	public void setsBUILDNO(String sBUILDNO) {
		this.sBUILDNO = sBUILDNO;
	}

	public String getsLICENCE() {
		return sLICENCE;
	}

	public void setsLICENCE(String sLICENCE) {
		this.sLICENCE = sLICENCE;
	}

	public String getsBANK() {
		return sBANK;
	}

	public void setsBANK(String sBANK) {
		this.sBANK = sBANK;
	}

	public Integer getsTEMRS() {
		return sTEMRS;
	}

	public void setsTEMRS(Integer sTEMRS) {
		this.sTEMRS = sTEMRS;
	}

	public Date getsCDATE() {
		return sCDATE;
	}

	public void setsCDATE(Date sCDATE) {
		this.sCDATE = sCDATE;
	}

	public Integer getsLEVEL() {
		return sLEVEL;
	}

	public void setsLEVEL(Integer sLEVEL) {
		this.sLEVEL = sLEVEL;
	}

	public Integer getsDROP() {
		return sDROP;
	}

	public void setsDROP(Integer sDROP) {
		this.sDROP = sDROP;
	}

	public String getsNAME() {
		return sNAME;
	}

	public void setsNAME(String sNAME) {
		this.sNAME = sNAME;
	}

	@Override
	public String toString() {
		return "SellerVO [sNO=" + sNO + ", sID=" + sID + ", sPW=" + sPW + ", sPHONE=" + sPHONE + ", sEMAIL=" + sEMAIL
				+ ", sADDRESS=" + sADDRESS + ", sBUILD=" + sBUILD + ", sBUILDNO=" + sBUILDNO + ", sLICENCE=" + sLICENCE
				+ ", sBANK=" + sBANK + ", sTEMRS=" + sTEMRS + ", sCDATE=" + sCDATE + ", sLEVEL=" + sLEVEL + ", sDROP="
				+ sDROP + ", sNAME=" + sNAME + "]";
	}

	
	
} // end SellerVO

