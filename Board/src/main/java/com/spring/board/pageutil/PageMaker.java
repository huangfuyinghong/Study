package com.spring.board.pageutil;

// ������ ��ȣ���� ��ũ�� ����� ���� ��ƿ��Ƽ Ŭ����  
public class PageMaker {
	
	private PageCriteria criteria; 
	private int totalCount; // ��ü �Խñ� ����  
	private int numsOfPageLinks; // ������ ��ȣ ��ũ(��:�Խ��� ����)�� ����  
	private int startPageNo; // ���� ������ ��ũ ��ȣ 
	private int endPageNo; // �� ������ ��ũ ��ȣ 
	private boolean hasPrev; // ȭ�鿡 ���̴� ���� ������ ��ȣ���� ���� ������ �������� �ִ� �� 
	private boolean hasNext; // ȭ�鿡 ���̴� �� ������ ��ȣ���� ū ������ �������� �ִ� ��
	
	public PageMaker() {
		// �ѹ��� ǥ���� ����¡ ��ȣ�� ����  
		this.numsOfPageLinks = 10; 
	}

	public PageCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}

	public void setNumsOfPageLinks(int numsOfPageLinks) {
		this.numsOfPageLinks = numsOfPageLinks;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	// startPageNo, endPageNo, hasPrev, hasNext ���� ��� �� ���� 
	// Math.ceil (�ø�)
	// Math.floor (����)
	public void setPageData() {
		// �ϴ� ����¡ ��ȣ ([�Խù� �� ���� / ���������� ����� ����]�� �ø���ȣ) ��, 10, 20, 30.. ���� ������ ��ȣ ( �ѹ��� 10������ ǥ�÷� ������ ) 
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
		
		// ǥ�õǴ� ������ ��ȣ �� ������ ��ȣ 
		// ������ ������ ��ȣ = ((�ø�)(���� ������ ��ȣ / �ѹ��� ǥ���� ������ ��ȣ�� ����)) * �ѹ��� ǥ���� ������ ��ȣ�� ����
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
	
		// ǥ�õǴ� ������ ��ȣ�� �ϴ� ����¡ ��ȣ���� ũ�� �ϴ������� ��ȣ�� ǥ��, �ݸ� ... 
		if (temp > totalLinkNo) { 
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		// ǥ�õǴ� ������ ��ȣ �� ù��° ��ȣ 
		// ���� ������ = ������ ������ ��ȣ - �ѹ��� ǥ���� ������ ��ȣ�� ���� + 1
		startPageNo = ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
	
		// boolean prev = startPageNum == 1 ? false : true;
		if (startPageNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		// boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		if (endPageNo * criteria.getNumsPerPage() >= totalCount) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		
	}
	
} // end PageMaker