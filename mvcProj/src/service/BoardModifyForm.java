package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Action;
import model.BoardDAO;
import model.BoardDTO;

public class BoardModifyForm implements Action{

	
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDetail execute() 진입");
		
		ActionForward res = new ActionForward();
		
		BoardDTO dto = new BoardDTO();
		dto.setId(request.getParameter("id"));
		BoardDAO dao = new BoardDAO();
		dao.addCount(dto); //조회수 증가
		request.setAttribute("data", dao.detail(dto));
		
		res.setUrl("modifyForm");
		return res;
	}

}
