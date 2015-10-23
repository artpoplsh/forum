package forum.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import forum.admin.domain.Admin;
import forum.teacher.domain.Teacher;
import forum.util.Dbutil;

public class AdminDaoImpl implements AdminDao {
	private Dbutil dbutil;
	private static final String SQL_QUERY="select * from admin where id=?";

	public AdminDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbutil=new Dbutil();
	}
	@Override
	public Admin getAdminById(String idString) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		Admin admin=null;
		ResultSet res=null;
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while(res.next())
			{
				admin=new Admin();
				admin.setId(res.getString("id"));
				admin.setName(res.getString("name"));
				//System.out.print(res.getString("id"));
				admin.setPassword(res.getString("password"));
				admin.setSex(res.getString("sex"));
			}
			return admin;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.dbutil.releaseResource(conn, pstmt, res);
		}
		return null;
	}

}
