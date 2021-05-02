package model;

import javax.servlet.http.HttpServletRequest;

public class PageDTO {

	int page = 1, start, total, startPage, endPage;
	int limit = 3, pageLimit = 4;
	
	public PageDTO(HttpServletRequest request) {
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));	
		}
	}
	

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}




	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}




	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void init() {
		int ttt = new BoardDAO().totalCnt();
		this.total = ttt/limit;
		
		if(ttt%limit>0)
			total++;

		start = (page-1)*limit;
		
		startPage = (page-1)/pageLimit * pageLimit  +1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > total) {
			endPage = total;
		}
		
	}

	public PageDTO() {
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		start = (page-1)*limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}


}
