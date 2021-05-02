package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import control.Action;
import model.AlertDTO;
import model.BoardDAO;
import model.BoardDTO;
import model.InData;

public class BoardInsertReg implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardInsertReg execute() 진입");
		
		ActionForward res = new ActionForward();
		
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					InData.path(request),
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			BoardDTO dto = new BoardDTO();
			dto.setTitle(mm.getParameter("title"));
			dto.setPname(mm.getParameter("pname"));
			dto.setPw(mm.getParameter("pw"));
			dto.setContent(mm.getParameter("content"));
			dto.setUpfile(mm.getFilesystemName("upfile"));
			
			new BoardDAO().insert(dto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AlertDTO al = new AlertDTO();
		al.setMsg("게시글이 작성되었습니다.");
		al.setUrl("BoardList");
		
		request.setAttribute("data",al);
		
		res.setUrl("alert");
		return res;
	}

}
