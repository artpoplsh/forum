package forum.admin.dao;

public interface InvitationContentDao {
	public InvitationContent getInvitationContentById(int id);
	public void deleteInvitationContentByInvitationId(int invitationid);

}
