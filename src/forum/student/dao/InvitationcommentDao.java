package forum.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import forum.admin.domain.Invitation;
import forum.student.domain.Invitationcomment;
import forum.util.Dbutil;

public class InvitationcommentDao {
	private Dbutil dbutil;
	public InvitationcommentDao(){
		this.dbutil=new Dbutil();
	}
	
	public List getInvitationcommentById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List list=null;
		Invitationcomment invitationcomment=null;
		String sql="select * from invitationcomment where invitationid=?";
		try{
			conn=this.dbutil.getConn();
			//ִ�в�ѯ
			list=new ArrayList<Invitationcomment>();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				invitationcomment=new Invitationcomment();
				invitationcomment.setId(res.getInt("id"));
				//System.out.println("====="+res.getString("comment")+"-----");
				invitationcomment.setCommentPerson(res.getString("commentPerson"));
				invitationcomment.setComment(res.getString("comment"));
				invitationcomment.setInvitationid(res.getInt("invitationid"));
				list.add(invitationcomment);
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

}
