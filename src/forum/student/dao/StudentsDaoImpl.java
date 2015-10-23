package forum.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import forum.student.domain.Student;
import forum.util.Dbutil;

public class StudentsDaoImpl implements StudentsDao {
	private Dbutil dbutil;
	private static final String SQL_INSERT="insert into students values(?,?,?,?,?,?)";
	private static final String SQL_DEL="delete from students where id=?";
	private static final String SQL_UPDATE="update students name=?,password=?,sex=?,limits=?,teacherId=? where id=?";
	private static final String SQL_QUERY="select * from students where id=?";
	private static final String SQL_QUERY_NAME="select * from students where name=?";
	

	public StudentsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbutil=new Dbutil();
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student getStudentById(String idString) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		Student student=null;
		ResultSet res=null;
		try{
			conn=this.dbutil.getConn();
			//执行查询
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, idString);
			res=pstmt.executeQuery();
			while(res.next())
			{
				student=new Student();
				student.setId(res.getString("id"));
				student.setName(res.getString("name"));
				//System.out.print(res.getString("id"));
				student.setPassword(res.getString("password"));
				student.setSex(res.getString("sex"));
				student.setLimits(res.getInt("limits"));
				student.setTeacherId(res.getString("teacherId"));
			}
			return student;
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
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		Student student=null;
		ResultSet res=null;
		try{
			conn=this.dbutil.getConn();
			//执行查询
			pstmt=conn.prepareStatement(SQL_QUERY_NAME);
			pstmt.setString(1, name);
			res=pstmt.executeQuery();
			while(res.next())
			{
				student=new Student();
				student.setId(res.getString("id"));
				//System.out.print(res.getString("id"));
				student.setPassword(res.getString("password"));
				student.setSex(res.getString("sex"));
				student.setLimits(res.getInt("limits"));
				student.setTeacherId(res.getString("teacherId"));
			}
			return student;
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
