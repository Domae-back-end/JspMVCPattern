package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;

	public BoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/zxcv");
			con = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filedelete(BoardDTO dto) {
		sql = "update board set upfile = null where id = ?";
		try {
			ptmt = con.prepareStatement(sql);

			ptmt.setInt(1, dto.id);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public BoardDTO exist(BoardDTO dto) {
		BoardDTO res = null;
		sql = "select * from board where id = ? and pw = ?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			rs = ptmt.executeQuery();

			if (rs.next()) {
				res = new BoardDTO();
				res.setId(rs.getInt("id"));
				res.setTitle(rs.getString("title"));
				res.setCnt(rs.getInt("cnt"));
				res.setPname(rs.getString("pname"));
				res.setContent(rs.getString("content"));
				res.setUpfile(rs.getString("upfile"));
				res.setReg_date(rs.getDate("reg_date"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close();
		}
		return res;
	}

	public void delete(BoardDTO dto) {

		sql = "delete from board where id = ?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}

	}

	public void insert(BoardDTO dto) {

		sql = "insert into board (title,pname,pw,upfile,content,cnt,reg_date) values (?,?,?,?,?,0,sysdate())";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.title);
			ptmt.setString(2, dto.pname);
			ptmt.setString(3, dto.pw);
			ptmt.setString(4, dto.upfile);
			ptmt.setString(5, dto.content);

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}
	}

	public ArrayList<BoardDTO> list(PageDTO pd) {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();

		sql = "select * from board order by id desc limit ?,?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, pd.getStart());
			ptmt.setInt(2, pd.getLimit());
			rs = ptmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setPname(rs.getString("pname"));
				dto.setReg_date(rs.getTimestamp("reg_date"));

				ar.add(dto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close();
		}
		return ar;
	}
	public int totalCnt() {
		int ar = 0;

		sql = "select count(*) from board";

		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			rs.next();
			ar = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close();
		}
		return ar;
	}

	public BoardDTO detail(BoardDTO a) {
		BoardDTO dto = new BoardDTO();
		sql = "select * from board where id = ?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, a.getId());
			rs = ptmt.executeQuery();

			while (rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setPname(rs.getString("pname"));
				dto.setContent(rs.getString("content"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setReg_date(rs.getDate("reg_date"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close();
		}
		return dto;
	}

	public void addCount(BoardDTO dto) {
		sql = "update board set cnt = cnt+1 where id = ?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			rs = ptmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modify(BoardDTO dto) {

		sql = "update board set title=?,pname=?,upfile=?,content=? where id = ? and pw = ?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.title);
			ptmt.setString(2, dto.pname);
			ptmt.setString(3, dto.upfile);
			ptmt.setString(4, dto.content);
			
			ptmt.setInt(5, dto.id);
			ptmt.setString(6, dto.pw);

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}
	}

	public void close() {

		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (ptmt != null)
			try {
				ptmt.close();
			} catch (Exception e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (Exception e) {
			}

	}
}
