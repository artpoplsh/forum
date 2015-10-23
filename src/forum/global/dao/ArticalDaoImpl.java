package forum.global.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import forum.global.domain.Artical;
import forum.util.Dbutil;

public class ArticalDaoImpl implements ArticalDao{
	public static final String SQL_DEL="delete from artical where id=?";
	private static final String SQL_UPDATE="update artical set title=?,content=?,author=? where id=?";
	private static final String SQL_QUERY="select * from artical where id=?";
	private static final String SQL_SEL = "select * from artical where 1=1";
	@Override
	public int addArtical(Artical artical) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		String query="insert into artical values ('"+artical.getArticalId()+"','"+artical.getArticalTitle()+"','"+artical.getArticalContent()+"',curdate(),'"+artical.getArticalAuthor()+"')";
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
	public int delArtical(Artical artical) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(SQL_DEL);
			pstmt.setString(1, artical.getArticalId());
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
	public int updateArtical(Artical artical) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		int res=0;
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, artical.getArticalTitle());
			pstmt.setString(2, artical.getArticalContent());
			pstmt.setString(3, artical.getArticalAuthor());
			pstmt.setString(4, artical.getArticalId());
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
	public Artical getArticalById(String idString) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Artical artical = null;
		try {
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while (res.next()) {
				artical=new Artical();
				artical.setArticalId(res.getString("id"));
				artical.setArticalTitle(res.getString("title"));
				artical.setArticalContent(res.getString("content"));
				artical.setArticalCreatetime(res.getDate("createtime"));
				artical.setArticalAuthor(res.getString("author"));	
			}
			utils.releaseResource(conn, pstmt, res);
			return artical;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<Artical> getAllArtical() {
		// TODO Auto-generated method stub
		Dbutil utils = new Dbutil();
		Connection conn = utils.getConn();
		PreparedStatement pstmt = null;

		try {
			List list = new ArrayList();
			pstmt = conn.prepareStatement(SQL_SEL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Artical artical = new Artical();
				artical.setArticalId(rs.getString("id"));
				artical.setArticalTitle(rs.getString("title"));
				artical.setArticalContent(rs.getString("content"));
				artical.setArticalCreatetime(rs.getDate("createtime"));
				artical.setArticalAuthor(rs.getString("author"));	
				list.add(artical);
			}
			return (ArrayList<Artical>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.releaseResource(conn, pstmt, null);
		}
		return null;
	}

}
