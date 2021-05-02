package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Action;
import model.BoardDAO;
import model.BoardDTO;

public class BoardDeleteForm implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDeleteForm execute() 진입");
		
		ActionForward res = new ActionForward();
		
		res.setUrl("deleteForm");
		return res;
	}

}
