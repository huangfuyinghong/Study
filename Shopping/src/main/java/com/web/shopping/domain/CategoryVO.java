package com.web.shopping.domain;

// CATENAME	VARCHAR2(100 BYTE)	No		1	카테고리 1
// CATECODE	VARCHAR2(100 BYTE)	No		2	
// CATECODEREF	VARCHAR2(30 BYTE)	Yes		3	

public class CategoryVO {
	
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private Integer level; 
	
	public CategoryVO() {}

	public CategoryVO(String cateName, String cateCode, String cateCodeRef) {
		this.cateName = cateName;
		this.cateCode = cateCode;
		this.cateCodeRef = cateCodeRef;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateCodeRef() {
		return cateCodeRef;
	}

	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "CategoryVO [cateName=" + cateName + ", cateCode=" + cateCode + ", cateCodeRef=" + cateCodeRef
				+ ", level=" + level + "]";
	}
	
	
} // end CategoryVO
