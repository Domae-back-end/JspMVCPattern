package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;


public class BoardDTO {
	int id, cnt;
	String title, pname, pw, content, upfile;
	Date reg_date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public String getContentBr() {
		return content.replaceAll("\n", "<br>");
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpfile() {
		
		if(upfile == null || upfile.trim().equals("") || upfile.toLowerCase().trim().equals("null")) {
			upfile = null;
		}
		
		return upfile;
	}
	
	public boolean isImg() {
		if(getUpfile()==null)
			return false;
		String imgs = ".*[.](jpg|jpeg|bmp|png|gif)";
		return Pattern.matches(imgs, upfile.toLowerCase());
	}
	
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", cnt=" + cnt + ", title=" + title + ", pname=" + pname + ", pw=" + pw
				+ ", content=" + content + ", upfile=" + upfile + ", reg_date=" + reg_date + "]";
	}
	
}
