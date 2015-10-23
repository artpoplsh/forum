package forum.student.dao;
import java.util.ArrayList;

import forum.global.domain.*;
import forum.student.domain.Invitationcontent;
public interface InvitationcontentDao {
	int addInvitationcontent(Invitationcontent artical);
	int delInvitationcontent(Invitationcontent client);
	int updateInvitationcontent(Invitationcontent client);
	Invitationcontent getInvitationcontentById(String idString);
	ArrayList<Invitationcontent> getAllInvitationcontent();
	Invitationcontent getInvitationContentById(int id);
	void deleteInvitationContentByInvitationId(int invitationid);


}
