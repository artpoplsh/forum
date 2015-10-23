package forum.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import forum.global.domain.Invitation;
import forum.global.domain.Invitationcontent;
import forum.global.domain.Releasehomework;
import forum.util.Dbutil;


public class ReleasehomeworkDaoImpl implements ReleasehomeworkDao {

	private static final String SQL_ADD = "insert into releasehomework(teacherid,title,content,deadline,releasedate) values(?,?,?,?,?)";
	private static final String SQL_SEL = "select * from releasehomework where 1=1 order by releasedate desc";
	private static final String SQL_DEL = "delete from releasehomework where id=?";
	private static final String SQL_UPD = "update releasehomework set title=?,content=?,deadline=?,releasedate=? where id=?";
	private static final String SQL_LIKE = "select * from releasehomework where title like ?";
	@Override
	public int addReleasehomework(Releasehomework artical) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_ADD);
			pstmt.setString(1, artical.getTeacherid());
			pstmt.setString(2, artical.getTitle());
			pstmt.setString(3, artical.getContent());
			pstmt.setString(4, artical.getDeadline());
			pstmt.setString(5, artical.getReleasedate());
			int rs = pstmt.executeUpdate();
			if (rs > 0)
				return 0;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.releaseResource(conn, pstmt, null);
		}

		return 1;
	}

	@Override
	public boolean delReleasehomework(int id) {
		// TODO Auto-generated method stub
				Dbutil utils = new Dbutil();
				Connection conn = utils.getConn();
				PreparedStatement pstmt = null;

				try {
					pstmt = conn.prepareStatement(SQL_DEL);
					pstmt.setInt(1, id);

					int rs = pstmt.executeUpdate();
					if (rs > 0)
						return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					utils.releaseResource(conn, pstmt, null);
				}
				return false;
	}

	@Override
	public boolean updateReleasehomework(Releasehomework artical) {
		// TODO Auto-generated method stub
				Dbutil utils = new Dbutil();
				Connection conn = utils.getConn();
				PreparedStatement pstmt = null;
				
				try {
					pstmt = conn.prepareStatement(SQL_UPD);
					
					pstmt.setString(1, artical.getTeacherid());
					pstmt.setString(2, artical.getTitle());
					pstmt.setString(3, artical.getContent());
					pstmt.setString(4, artical.getDeadline());
					pstmt.setString(5, artical.getReleasedate());
					
					int rs = pstmt.executeUpdate();
					if (rs > 0)
						return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					utils.releaseResource(conn, pstmt, null);
				}
				return false;
	}

	@Override
	public Releasehomework getReleasehomeworkById(int id) {
		// TODO Auto-generated method stub
				Dbutil utils = new Dbutil();
				Connection conn = utils.getConn();
				PreparedStatement pstmt = null;
				Releasehomework relehome = null; 
				try {
				
					pstmt = conn.prepareStatement("select * from releasehomework where id=\""
							+ id + "\"");
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						relehome = new Releasehomework();
						relehome.setId(rs.getInt("id"));
						relehome.setTeacherid(rs.getString("teacherid"));
						relehome.setTitle(rs.getString("title"));
						relehome.setContent(rs.getString("content"));
						relehome.setDeadline(rs.getString("deadline"));
						relehome.setReleasedate(rs.getString("releasedate"));

					}
					return relehome;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					utils.releaseResource(conn, pstmt, null);
				}

				return null;
	}

	@Override
	public ArrayList<Releasehomework> getAllReleasehomework() {
		// TODO Auto-generated method stub
				Dbutil utils = new Dbutil();
				Connection conn = utils.getConn();
				PreparedStatement pstmt = null;

				try {
					List list = new ArrayList();
					pstmt = conn.prepareStatement(SQL_SEL);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						Releasehomework relehome = new Releasehomework();
						relehome.setId(rs.getInt("id"));
						relehome.setTeacherid(rs.getString("teacherid"));
						relehome.setTitle(rs.getString("title"));
						relehome.setContent(rs.getString("content"));
						relehome.setDeadline(rs.getString("deadline"));
						relehome.setReleasedate(rs.getString("releasedate"));
						list.add(relehome);
					}
					return (ArrayList<Releasehomework>) list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					utils.releaseResource(conn, pstmt, null);
				}

				return null;
	}

	@Override
	public Releasehomework getReleasehomeworkByTitle(String title) {
		// TODO Auto-generated method stub
		Dbutil utils = new Dbutil();
		Connection conn = utils.getConn();
		PreparedStatement pstmt = null;
		Releasehomework relehome = null; 
		try {
		
			pstmt = conn.prepareStatement(SQL_LIKE);
			
			pstmt.setString(1, title+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				relehome = new Releasehomework();
				relehome.setId(rs.getInt("id"));
				relehome.setTeacherid(rs.getString("teacherid"));
				relehome.setTitle(rs.getString("title"));
				relehome.setContent(rs.getString("content"));
				relehome.setDeadline(rs.getString("deadline"));
				relehome.setReleasedate(rs.getString("releasedate"));

			}
			return relehome;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.releaseResource(conn, pstmt, null);
		}

		return null;
	}

}
