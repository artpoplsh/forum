package forum.global.dao;

import java.util.ArrayList;

import forum.global.domain.*;
public interface InvitationDao {
	int addInvitation(Invitation artical);
	int delInvitation(Invitation client);
	int updateInvitation(Invitation client);
	Invitation getInvitationById(String idString);
	ArrayList<Invitation> getAllInvitation();


}
