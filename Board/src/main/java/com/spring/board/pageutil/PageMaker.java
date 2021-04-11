package com.spring.board.pageutil;

// 페이지 번호들의 링크를 만들기 위한 유틸리티 클래스  
public class PageMaker {
	
	private PageCriteria criteria; 
	private int totalCount; // 전체 게시글 개수  
	private int numsOfPageLinks; // 페이지 번호 링크(예:게시판 개수)의 개수  
	private int startPageNo; // 시작 페이지 링크 번호 
	private int endPageNo; // 끝 페이지 링크 번호 
	private boolean hasPrev; // 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 있는 지 
	private boolean hasNext; // 화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는 지
	
	public PageMaker() {
		// 한번에 표시할 페이징 번호의 갯수  
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
	
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산 및 세팅 
	// Math.ceil (올림)
	// Math.floor (버림)
	public void setPageData() {
		// 하단 페이징 번호 ([게시물 총 갯수 / 한페이지에 출력할 갯수]의 올림번호) 즉, 10, 20, 30.. 으로 나오는 번호 ( 한번에 10페이지 표시로 설정함 ) 
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
		
		// 표시되는 페이지 번호 중 마지막 번호 
		// 마지막 페이지 번호 = ((올림)(현재 페이지 번호 / 한번에 표시할 페이지 번호의 갯수)) * 한번에 표시할 페이지 번호의 갯수
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
	
		// 표시되는 페이지 번호가 하단 페이징 번호보다 크면 하단페이지 번호로 표시, 반면 ... 
		if (temp > totalLinkNo) { 
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		// 표시되는 페이지 번호 중 첫번째 번호 
		// 시작 페이지 = 마지막 페이지 번호 - 한번에 표시할 페이지 번호의 갯수 + 1
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