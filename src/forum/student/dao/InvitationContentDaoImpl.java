package forum.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import forum.student.domain.Invitation;
import forum.student.domain.Invitationcontent;
import forum.util.Dbutil;

public class InvitationContentDaoImpl implements InvitationcontentDao {

	private Dbutil dbutil;
	public InvitationContentDaoImpl()
	{
		this.dbutil=new Dbutil();
	}
	@Override
	public Invitationcontent getInvitationContentById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		Invitationcontent invitationContent=null;
		String sql="select * from invitationcontent where invitationid=?";
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				invitationContent=new Invitationcontent();
				invitationContent.setId(res.getInt("id"));
				//System.out.print(res.getString("id"));
				invitationContent.setId(id);
				invitationContent.setContent(res.getString("content"));
				invitationContent.setInvitationid(res.getInt("invitationid"));
			}
			return invitationContent;
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
	public void deleteInvitationContentByInvitationId(int invitationid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int num=0;
		try{
			conn=this.dbutil.getConn();
			pstmt=conn.prepareStatement("delete from invitationcontent where invitationid=?");//ִ�и������
			pstmt.setInt(1, invitationid);
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
	public int addInvitationcontent(Invitationcontent invitationcontent) {
		// TODO Auto-generated method stub
		Dbutil utils=new Dbutil();
		Connection conn=utils.getConn();
		PreparedStatement pstmt=null;
		String query="insert into invitationcontent values (null,'"+invitationcontent.getContent()+"','"+invitationcontent.getInvitationid()+"')";
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
	public int delInvitationcontent(Invitationcontent client) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateInvitationcontent(Invitationcontent client) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Invitationcontent getInvitationcontentById(String idString) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Invitationcontent> getAllInvitationcontent() {
		// TODO Auto-generated method stub
		return null;
	}

}
