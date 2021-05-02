package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Action;
import model.AlertDTO;
import model.BoardDAO;
import model.BoardDTO;
import model.InData;

public class FileDelete implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("FileDelete execute() 진입");
		
		ActionForward res = new ActionForward();
		
		BoardDTO dto = new BoardDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		
		BoardDTO check = new BoardDAO().exist(dto);
		AlertDTO al = new AlertDTO();
		
		al.setMsg("암호가 일치하지 않습니다.");
		al.setUrl("BoardModifyForm?id="+dto.getId()+"&page="+request.getParameter("page"));
		
		if(check != null) {
			new BoardDAO().filedelete(check);
			InData.fileDelete(request, check.getUpfile());
			al.setMsg("파일이 삭제되었습니다.");
		}
		
		request.setAttribute("data",al);
		
		
		res.setUrl("alert");
		return res;
	}
	

}
