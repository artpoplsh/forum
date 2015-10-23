package forum.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import forum.global.domain.Chatcontent;
import forum.global.domain.Handinhomework;
import forum.util.Dbutil;

public class HandinhomeworkDaoImpl implements HandinhomeworkDao{
	public static final String SQL_DEL="delete from handinhomework where releasehomeworkid=?";
	private static final String SQL_UPDATE="update handinhomework set releasehomeworkid=?,studentid=?,mark=?,address=? where id=?";
	private static final String SQL_QUERY="select * from handinhomework where id=?";
	private static final String SQL_SEL = "select * from handinhomework where 1=1";
	@Override
	public int addHandinhomework(Handinhomework handinhomework) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		String query="insert into handinhomework values (null,'"+handinhomework.getReleasehomeworkid()+"','"+handinhomework.getStudentid()+"','"+handinhomework.getMark()+"','"+handinhomework.getAddress()+"')";
		try {
			pstmt=conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rest=0;
		try {
			rest =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if (rest != 0) {
			utils.releaseResource(conn, pstmt, null);
			return 1;
		}
		return 0;
	}

	@Override
	public int delHandinhomework(int releasehomeworkid) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(SQL_DEL);
			pstmt.setInt(1, releasehomeworkid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rest=0;
		try {
			rest=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if (rest != 0) {
			utils.releaseResource(conn, pstmt, null);
			return 1;
		}

		return 0;
	}

	@Override
	public int updateHandinhomework(Handinhomework handinhomework) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		int res=0;
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setInt(1, handinhomework.getReleasehomeworkid());
			pstmt.setString(2, handinhomework.getStudentid());
			pstmt.setDouble(3, handinhomework.getMark());
			pstmt.setInt(4, handinhomework.getId());
			pstmt.setString(5, handinhomework.getAddress());
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res!=0) {
			utils.releaseResource(conn, pstmt,null);
			return 1;
		}

		return 0;
	}

	@Override
	public Handinhomework getHandinhomeworkById(String idString) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Handinhomework handinhomework = null;
		try {
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while (res.next()) {
				handinhomework=new Handinhomework();
				handinhomework.setId(res.getInt("id"));
				handinhomework.setReleasehomeworkid(res.getInt("releasehomeworkid"));
				handinhomework.setStudentid(res.getString("studentid"));
				handinhomework.setMark(res.getDouble("mark"));
				handinhomework.setAddress(res.getString("address"));
			}
			utils.releaseResource(conn, pstmt, res);
			return handinhomework;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Handinhomework> getAllHandinhomework() {
		// TODO Auto-generated method stub
		Dbutil utils = new Dbutil();
		Connection conn = utils.getConn();
		PreparedStatement pstmt = null;

		try {
			List list = new ArrayList();
			pstmt = conn.prepareStatement(SQL_SEL);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				Handinhomework handinhomework=new Handinhomework();
				handinhomework.setId(res.getInt("id"));
				handinhomework.setReleasehomeworkid(res.getInt("releasehomeworkid"));
				handinhomework.setStudentid(res.getString("studentid"));
				handinhomework.setMark(res.getDouble("mark"));
				handinhomework.setAddress(res.getString("address"));
				list.add(handinhomework);
			}
			return (ArrayList<Handinhomework>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.releaseResource(conn, pstmt, null);
		}
		return null;
	}

}
