package forum.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import forum.global.domain.Artical;
import forum.global.domain.Chatcontent;
import forum.util.Dbutil;

public class ChatcontentDaoImpl implements ChatcontentDao{
	public static final String SQL_DEL="delete from chatcontent where id=?";
	private static final String SQL_UPDATE="update chatcontent set content=?,chatthemeid=?,senderid=?,issend=? where id=?";
	private static final String SQL_QUERY="select * from chatcontent where id=?";
	private static final String SQL_SEL = "select * from chatcontent where 1=1";
	@Override
	public int addChatcontent(Chatcontent chatcontent) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		String query="insert into chatcontent values ('"+chatcontent.getId()+"','"+chatcontent.getContent()+"','"+chatcontent.getChatthemeid()+"','"+chatcontent.getSenderid()+"','"+chatcontent.getIssend()+"')";
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
	public int delChatcontent(Chatcontent chatcontent) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(SQL_DEL);
			pstmt.setString(1, chatcontent.getId());
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
	public int updateChatcontent(Chatcontent chatcontent) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		int res=0;
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, chatcontent.getContent());
			pstmt.setString(2, chatcontent.getChatthemeid());
			pstmt.setString(3, chatcontent.getSenderid());
			pstmt.setString(4, chatcontent.getIssend());
			pstmt.setString(5, chatcontent.getId());
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
	public Chatcontent getChatcontentById(String idString) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Chatcontent chatcontent = null;
		try {
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while (res.next()) {
				chatcontent=new Chatcontent();
				chatcontent.setId(idString);
				chatcontent.setContent(res.getString("content"));
				chatcontent.setChatthemeid(res.getString("chatthemeid"));
				chatcontent.setSenderid(res.getString("senderid"));
				chatcontent.setIssend(res.getString("issend"));
			}
			utils.releaseResource(conn, pstmt, res);
			return chatcontent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Chatcontent> getAllChatcontent() {
		// TODO Auto-generated method stub
		Dbutil utils = new Dbutil();
		Connection conn = utils.getConn();
		PreparedStatement pstmt = null;

		try {
			List list = new ArrayList();
			pstmt = conn.prepareStatement(SQL_SEL);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				Chatcontent chatcontent=new Chatcontent();
				chatcontent.setId(res.getString("id"));
				chatcontent.setContent(res.getString("content"));
				chatcontent.setChatthemeid(res.getString("chatthemeid"));
				chatcontent.setSenderid(res.getString("senderid"));
				chatcontent.setIssend(res.getString("issend"));
				list.add(chatcontent);
			}
			return (ArrayList<Chatcontent>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.releaseResource(conn, pstmt, null);
		}
		return null;
	}

}
