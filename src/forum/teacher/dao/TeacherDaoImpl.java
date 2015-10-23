package forum.teacher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import forum.student.domain.Student;
import forum.teacher.domain.Teacher;
import forum.util.Dbutil;

public class TeacherDaoImpl implements TeacherDao {
	private Dbutil dbutil;
	private static final String SQL_INSERT="insert into teacher values(?,?,?,?)";
	private static final String SQL_DEL="delete from teacher where id=?";
	private static final String SQL_UPDATE="update teacher name=?,password=?,sex=? where id=?";
	private static final String SQL_QUERY="select * from teacher where id=?";

	public TeacherDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbutil=new Dbutil();
	}
	@Override
	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Teacher getTeacherById(String idString) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		Teacher teacher=null;
		ResultSet res=null;
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while(res.next())
			{
				teacher=new Teacher();
				teacher.setId(res.getString("id"));
				teacher.setName(res.getString("name"));
				//System.out.print(res.getString("id"));
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

	@Override
	public ArrayList<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

}
