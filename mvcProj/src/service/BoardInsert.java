package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Action;
import model.BoardDAO;

public class BoardInsert implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardList execute() 진입");
		
		ActionForward res = new ActionForward();
		
		
		res.setUrl("insertForm");
		return res;
	}

}
