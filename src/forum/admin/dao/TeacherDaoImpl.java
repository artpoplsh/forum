package forum.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import forum.admin.domain.Admin;
import forum.admin.domain.Teacher;
import forum.util.Dbutil;

public class TeacherDaoImpl implements TeacherDao {
	private Dbutil dbutil;
	private static final String SQL_QUERY="select * from teacher where id=?";

	public TeacherDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbutil=new Dbutil();
	}
	@Override
	public Teacher getTeacherById(String id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		Teacher teacher=null;
		ResultSet res=null;
		try{
			conn=this.dbutil.getConn();
			//÷¥––≤È—Ø
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				teacher=new Teacher();
				teacher.setId(res.getString("id"));
				//System.out.print(res.getString("id"));
				teacher.setName(res.getString("name"));
				teacher.setPassword(res.getString("password"));
				teacher.setSex(res.getString("sex"));
			}
			return teacher;
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
