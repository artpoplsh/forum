package forum.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import forum.global.domain.Chatcontent;
import forum.global.domain.Chattheme;
import forum.util.Dbutil;

public class ChatthemeDaoImpl implements ChatthemeDao{
	public static final String SQL_DEL="delete from chattheme where id=?";
	private static final String SQL_UPDATE="update chattheme set theme=?,state=? where id=?";
	private static final String SQL_QUERY="select * from chattheme where id=?";
	private static final String SQL_SEL = "select * from chattheme where 1=1";
	@Override
	public int addChattheme(Chattheme chattheme) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		String query="insert into chattheme values ('"+chattheme.getId()+"','"+chattheme.getTheme()+"','"+chattheme.getState()+"')";
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
	public int delChattheme(Chattheme chattheme) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(SQL_DEL);
			pstmt.setString(1, chattheme.getId());
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
	public int updateChattheme(Chattheme chattheme) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		int res=0;
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, chattheme.getTheme());
			pstmt.setString(2, chattheme.getState());
			pstmt.setString(3, chattheme.getId());	
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
	public Chattheme getChatthemeById(String idString) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Chattheme chattheme = null;
		try {
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while (res.next()) {
				chattheme=new Chattheme();
				chattheme.setId(res.getString("id"));
				chattheme.setTheme(res.getString("theme"));
				chattheme.setState(res.getString("state"));
			}
			utils.releaseResource(conn, pstmt, res);
			return chattheme;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Chattheme> getAllChattheme() {
		// TODO Auto-generated method stub
		Dbutil utils = new Dbutil();
		Connection conn = utils.getConn();
		PreparedStatement pstmt = null;

		try {
			List list = new ArrayList();
			pstmt = conn.prepareStatement(SQL_SEL);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				Chattheme chattheme=new Chattheme();
				chattheme.setId(res.getString("id"));
				chattheme.setTheme(res.getString("theme"));
				chattheme.setState(res.getString("state"));
				list.add(chattheme);
			}
			return (ArrayList<Chattheme>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.releaseResource(conn, pstmt, null);
		}
		return null;
	}

}
