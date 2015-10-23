package forum.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

import forum.admin.domain.Invitation;
import forum.student.dao.InvitationcontentDao;
import forum.student.domain.Invitationcontent;
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
	public int getLimitInvitation(Invitation invitation) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="";
		
		sql="Select id from invitation where title='"+invitation.getTitle()+"'";
		System.out.println(sql);
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			pstmt=conn.prepareStatement(sql);
			
			res=pstmt.executeQuery();
			while(res.next())
			{
				
				return res.getInt("id");
			}
			//return list;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.dbutil.releaseResource(conn, pstmt, res);
		}
		return -1;
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
			//ִ�в�ѯ
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
			//ִ�в�ѯ
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
	public List getAllInvitation() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		String sql="select * from invitation where isChecked=1";
		
		
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			
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
			pstmt=conn.prepareStatement(SQL_UPDATE);//ִ�и������
			pstmt.setInt(1, id);
			num=pstmt.executeUpdate();
			//if((num=pstmt.executeUpdate())>0) return 0;//��ʾ�ɹ�
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			this.dbutil.releaseResource(conn, pstmt, null);
		}
		//return 1;//����1����ʧ��,0����ɹ�
		
	}
	@Override
	public void deleteInvitation(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int num=0;
		try{
			conn=this.dbutil.getConn();
			pstmt=conn.prepareStatement(SQL_DEL);//ִ�и������
			pstmt.setInt(1, id);
			num=pstmt.executeUpdate();
			//if((num=pstmt.executeUpdate())>0) return 0;//��ʾ�ɹ�
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			this.dbutil.releaseResource(conn, pstmt, null);
		}
		//return 1;//����1����ʧ��,0����ɹ�
	}
	@Override
	public List getAllInvitation(String authorid, String orderBy, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int addInvitation(Invitation invitation){
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		String query="insert into invitation values (null,'"+invitation.getTitle()+"','"+invitation.getAuthorId()+"','"+invitation.getIsChecked()+"','"+invitation.getDate()+"')";
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
	public List getLimitInvitation(String authorid, int from, int size,
			String sortBy, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
