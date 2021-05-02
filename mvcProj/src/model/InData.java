package model;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InData {
	
	public final static String path(HttpServletRequest request) {
		String path = request.getRealPath("up");
		path = "C:\\Java_study\\HTML CSS\\mvcProj\\WebContent\\up";
		return path;
	}
	
	public final static void fileDelete(HttpServletRequest request,String fname) {
		if(fname != null) {
			new File(path(request)+"\\"+fname).delete();
		}
	}
	
}
