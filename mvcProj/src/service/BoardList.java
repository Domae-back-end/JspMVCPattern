package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Action;
import model.BoardDAO;
import model.PageDTO;

public class BoardList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardList execute() 진입");

		ActionForward res = new ActionForward();

		PageDTO pd = new PageDTO(request);
		pd.init();

		request.setAttribute("data", new BoardDAO().list(pd));
		request.setAttribute("pd", pd);

		
		res.setUrl("list");
		return res;
	}

}
