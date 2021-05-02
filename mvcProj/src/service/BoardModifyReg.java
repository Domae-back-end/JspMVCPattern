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

public class BoardModifyReg implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardModfiyReg execute() 진입");

		ActionForward res = new ActionForward();

		try {
			MultipartRequest mm = new MultipartRequest(request, InData.path(request), 10 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			BoardDTO dto = new BoardDTO();
			dto.setId(mm.getParameter("id"));
			dto.setTitle(mm.getParameter("title"));
			dto.setPname(mm.getParameter("pname"));
			dto.setPw(mm.getParameter("pw"));
			dto.setContent(mm.getParameter("content"));

			if (mm.getParameter("upfile") != null)
				dto.setUpfile(mm.getParameter("upfile"));
			else
				dto.setUpfile(mm.getFilesystemName("upfile"));
			System.out.println(dto);
			AlertDTO al = new AlertDTO();
			BoardDTO check = new BoardDAO().exist(dto);

			al.setMsg("암호가 일치하지 않습니다.");
			al.setUrl("BoardModifyForm?id=" + dto.getId()+"&page="+mm.getParameter("page"));

			if (check != null) {

				new BoardDAO().modify(dto);
				InData.fileDelete(request, check.getUpfile());

				al.setMsg("해당 게시글이 수정되었습니다.");
				al.setUrl("BoardDetail?id=" + dto.getId()+"&page="+mm.getParameter("page"));
			} else {
				if (mm.getParameter("upfile") == null)
					InData.fileDelete(request, dto.getUpfile());
			}
			request.setAttribute("data", al);
		} catch (IOException e) {
			e.printStackTrace();
		}

		res.setUrl("alert");
		return res;
	}

}
