package forum.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import forum.admin.domain.Invitation;
import forum.util.Dbutil;

public class InvitationContentDaoImpl implements InvitationContentDao {

	private Dbutil dbutil;
	public InvitationContentDaoImpl()
	{
		this.dbutil=new Dbutil();
	}
	@Override
	public InvitationContent getInvitationContentById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		InvitationContent invitationContent=null;
		String sql="select * from invitationcontent where id=?";
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				invitationContent=new InvitationContent();
				invitationContent.setId(res.getInt("id"));
				//System.out.print(res.getString("id"));
				invitationContent.setId(id);
				invitationContent.setDate(res.getString("date"));
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

}
