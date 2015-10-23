package forum.admin.dao;

import java.util.List;

import forum.admin.domain.Invitation;

public interface CheckedInvitationDao {
	public List getLimitInvitation(String authorid,int from, int size,String sortBy,String order);
	public List getAllInvitation(String authorid,String orderBy,String order);
	public Invitation getInvitationById(int id);
    public int getInvitaionCount(String authorid);
    public void deleteInvitation(int id);

}
