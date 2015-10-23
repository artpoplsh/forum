package forum.global.dao;
import java.util.ArrayList;

import forum.global.domain.*;
public interface InvitationcontentDao {
	int addInvitationcontent(Invitationcontent artical);
	int delInvitationcontent(Invitationcontent client);
	int updateInvitationcontent(Invitationcontent client);
	Invitationcontent getInvitationcontentById(String idString);
	ArrayList<Invitationcontent> getAllInvitationcontent();


}
