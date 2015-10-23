package forum.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

import forum.admin.domain.Invitation;
import forum.global.dao.InvitationcontentDao;
import forum.global.domain.Invitationcontent;
import forum.util.Dbutil;

public class InvitationDaoImpl implements InvitationDao {

	private Dbutil dbutil;
	private static String SQL_QUERY="select * from invitation where isChecked=0 order by ";
	private static String SQL_LIMIT_QUERY="select * from invitation where isChecked=0 order by limit ?,?";
	private static final String SQL_UPDATE="update invitation set isChecked=1 where id=?";
	private static final String SQL_DEL="delete from invitation where id=?";
	public InvitationDaoImpl()
	{
		this.dbutil=new Dbutil();
	}
	@Override
	public List getLimitInvitation(String authorid,int from, int size, String orderBy,String order) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="";
		if(authorid.equals("")){
			sql="select * from invitation where isChecked=0 order by ";
		}
		else sql="select * from invitation where isChecked=0 and authorid='"+authorid+"' order by ";
		try{
			conn=this.dbutil.getConn();
			//执行查询
			list=new ArrayList<Invitation>();
			//如果用户没有设置排序则按时间升序排序
			if(orderBy==null) sql+="date asc";
			else sql=sql+orderBy+" "+order;
			sql+=" limit ?,?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, from);
			pstmt.setInt(2, size);
			res=pstmt.executeQuery();
			while(res.next())
			{
				Invitation invitation=new Invitation();
				invitation.setId(res.getInt("id"));
				//System.out.print(res.getString("id"));
				invitation.setAuthorId(res.getString("authorid"));
				invitation.setTitle(res.getString("title"));
				invitation.setDate(res.getString("date"));
				invitation.setIsChecked(res.getInt("isChecked"));
				list.add(invitation);
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
	public Invitation getInvitationById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="select * from invitation where isChecked=0 and id=?";
		try{
			conn=this.dbutil.getConn();
			//执行查询
			Invitation invitation=null;
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				invitation=new Invitation();
				invitation.setId(res.getInt("id"));
				//System.out.print(res.getString("id"));
				invitation.setAuthorId(res.getString("authorid"));
				invitation.setTitle(res.getString("title"));
				invitation.setDate(res.getString("date"));
				invitation.setIsChecked(res.getInt("isChecked"));
				list.add(invitation);
			}
			return invitation;
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
	public int getInvitaionCount(String authorid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rsCount=0;
		ResultSet res=null;
		String sql="";
		if(authorid.equals("")){
			sql="select count(*) count from invitation where isChecked=0 ";
		}
		else sql="select count(*) count from invitation where isChecked=0 and authorid='"+authorid+"' ";
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
	public List getAllInvitation(String authorid,String orderBy,String order) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="";
		if(authorid.equals("")){
			sql="select * from invitation where isChecked=0 order by ";
		}
		else sql="select * from invitation where isChecked=0 and authorid='"+authorid+"' order by ";
		try{
			conn=this.dbutil.getConn();
			//执行查询
			if(orderBy==null) sql+="date asc";
			else sql=sql+orderBy+" "+order;
			pstmt=conn.prepareStatement(sql);
			res=pstmt.executeQuery();
			list=new ArrayList<Invitation>();
			while(res.next())
			{
				Invitation invitation=new Invitation();
				invitation.setId(res.getInt("id"));
				//System.out.print(res.getString("id"));
				invitation.setAuthorId(res.getString("authorid"));
				invitation.setTitle(res.getString("title"));
				invitation.setDate(res.getString("date"));
				invitation.setIsChecked(res.getInt("isChecked"));
				list.add(invitation);
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
	public void passInvitation(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int num=0;
		try{
			conn=this.dbutil.getConn();
			pstmt=conn.prepareStatement(SQL_UPDATE);//执行更新语句
			pstmt.setInt(1, id);
			num=pstmt.executeUpdate();
			//if((num=pstmt.executeUpdate())>0) return 0;//表示成功
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			this.dbutil.releaseResource(conn, pstmt, null);
		}
		//return 1;//返回1代表失败,0代表成功
		
	}
	@Override
	public void deleteInvitation(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int num=0;
		try{
			conn=this.dbutil.getConn();
			pstmt=conn.prepareStatement(SQL_DEL);//执行更新语句
			pstmt.setInt(1, id);
			num=pstmt.executeUpdate();
			//if((num=pstmt.executeUpdate())>0) return 0;//表示成功
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			this.dbutil.releaseResource(conn, pstmt, null);
		}
		//return 1;//返回1代表失败,0代表成功
	}

	

}
