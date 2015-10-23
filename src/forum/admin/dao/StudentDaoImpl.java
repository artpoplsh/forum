package forum.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import forum.admin.domain.Admin;
import forum.admin.domain.Invitation;
import forum.admin.domain.Student;
import forum.util.Dbutil;

public class StudentDaoImpl implements StudentDao {

	private Dbutil dbutil;
	private static final String SQL_QUERY="select * from students where id=?";

	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbutil=new Dbutil();
	}
	@Override
	public Student getStudentById(String id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		Student student=null;
		ResultSet res=null;
		try{
			conn=this.dbutil.getConn();
			//执行查询
			pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setString(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				student=new Student();
				student.setId(res.getString("id"));
				student.setName(res.getString("name"));
				student.setPassword(res.getString("password"));
				student.setSex(res.getString("sex"));
				student.setTeacherId(res.getString("teacherId"));
				student.setLimits(res.getInt("limits"));
				if((student.getLimits()&1)!=0) student.setCreateInvitation(true);
				if((student.getLimits()&2)!=0) student.setLeaveInvitation(true);
				if((student.getLimits()&4)!=0) student.setHandInMaterial(true);
				
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
	public List getLimitStudent(String id, String teacherId, int from,
			int size, String orderBy, String order) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="";
		if(id.equals("")&&teacherId.equals("")){
			sql="select * from students order by ";
		}
		else if(!id.equals("")&&teacherId.equals("")) 
			sql="select * from students where id='"+id+"' order by ";
		else if (id.equals("")&&!teacherId.equals("")) 
			sql="select * from students where teacherId='"+teacherId+"' order by ";
		else {
			sql="select * from students where id='"+id+"' and teacherId='"+teacherId+"' order by ";
		}
		try{
			conn=this.dbutil.getConn();
			//执行查询
			list=new ArrayList<Student>();
			//如果用户没有设置排序则按时间升序排序
			if(orderBy==null) sql+="id asc";
			else sql=sql+orderBy+" "+order;
			sql+=" limit ?,?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, from);
			pstmt.setInt(2, size);
			res=pstmt.executeQuery();
			while(res.next())
			{
				Student student=new Student();
				student.setId(res.getString("id"));
				//System.out.print(res.getString("id"));
				student.setLimits(res.getInt("limits"));
				student.setName(res.getString("name"));
				student.setPassword(res.getString("password"));
				student.setSex(res.getString("sex"));
				student.setTeacherId(res.getString("teacherId"));
				if((student.getLimits()&1)!=0) student.setCreateInvitation(true);
				if((student.getLimits()&2)!=0) student.setLeaveInvitation(true);
				if((student.getLimits()&4)!=0) student.setHandInMaterial(true);
				list.add(student);
			}
			return list;
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
	public List getAllStudent(String id, String teacherId, String orderBy,
			String order) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="";
		if(id.equals("")&&teacherId.equals("")){
			sql="select * from students order by ";
		}
		else if(!id.equals("")&&teacherId.equals("")) 
			sql="select * from students where id='"+id+"' order by ";
		else if (id.equals("")&&!teacherId.equals("")) 
			sql="select * from students where teacherId='"+teacherId+"' order by ";
		else {
			sql="select * from students where id='"+id+"' and teacherId='"+teacherId+"' order by ";
		}
		try{
			conn=this.dbutil.getConn();
			//执行查询
			if(orderBy==null) sql+="id asc";
			else sql=sql+orderBy+" "+order;
			pstmt=conn.prepareStatement(sql);
			res=pstmt.executeQuery();
			list=new ArrayList<Student>();
			while(res.next())
			{
				Student student=new Student();
				student.setId(res.getString("id"));
				//System.out.print(res.getString("id"));
				student.setLimits(res.getInt("limits"));
				student.setName(res.getString("name"));
				student.setPassword(res.getString("password"));
				student.setSex(res.getString("sex"));
				student.setTeacherId(res.getString("teacherId"));
				if((student.getLimits()&1)!=0) student.setCreateInvitation(true);
				if((student.getLimits()&2)!=0) student.setLeaveInvitation(true);
				if((student.getLimits()&4)!=0) student.setHandInMaterial(true);
				list.add(student);
			}
			return list;
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
	public int getStudentCount(String id, String teacherId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rsCount=0;
		ResultSet res=null;
		String sql="";
		if(id.equals("")&&teacherId.equals("")){
			sql="select count(*) count from students";
		}
		else if(!id.equals("")&&teacherId.equals("")) 
			sql="select count(*) count from students where id='"+id+"' ";
		else if (id.equals("")&&!teacherId.equals("")) 
			sql="select count(*) count from students where teacherId='"+teacherId+"' ";
		else {
			sql="select count(*) count from students where id='"+id+"' and teacherId='"+teacherId+"'";
		}
		try{
			conn=this.dbutil.getConn();
			//执行查询
			//pstmt=conn.prepareStatement("select count(*) count from invitation where isChecked=0");
			pstmt=conn.prepareStatement(sql);
			res=pstmt.executeQuery();
			if(res.next()){
				rsCount = (Integer.parseInt(String.valueOf(res.getInt("count"))));
				System.out.println("rsCount"+rsCount);
			}
			return rsCount;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.dbutil.releaseResource(conn, pstmt, res);
		}
		return 0;
	}
	@Override
	public void updateStudent(String id, int limits) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int res=0;
		String sql="update students set limits=? where id=?";
		try{
			conn=this.dbutil.getConn();
			//执行查询
			//pstmt=conn.prepareStatement("select count(*) count from invitation where isChecked=0");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, limits);
			pstmt.setString(2, id);
			res=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.dbutil.releaseResource(conn, pstmt, null);
		}
		
	}


}
