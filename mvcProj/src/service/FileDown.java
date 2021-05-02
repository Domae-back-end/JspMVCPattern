package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Action;
import model.BoardDAO;
import model.BoardDTO;

public class FileDown implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("FileDown execute() 진입");

		ActionForward res = new ActionForward();

		String path = request.getRealPath("up");
		path = "C:\\Java_study\\HTML CSS\\mvcProj\\WebContent\\up";
		String fname = request.getParameter("fname");

		try {
			FileInputStream fis = new FileInputStream(path + "\\" + fname);
			String en = URLEncoder.encode(fname, "utf-8");
			response.setHeader("Content-Disposition", "attachment:filename=" + fname);

			ServletOutputStream sos = response.getOutputStream();

			byte[] buf = new byte[1024];

			while (fis.available() > 0) {
				int len = fis.read(buf);

				sos.write(buf, 0, len);
			}
			
			sos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		res.setUrl(null);	//view page 가 없다
		return res;
	}

}
