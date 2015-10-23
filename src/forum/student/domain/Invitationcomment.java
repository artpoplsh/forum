package forum.student.domain;

public class Invitationcomment {
   private int id;
   private String comment;
   private int invitationid;
   private String commentPerson; 
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getInvitationid() {
	return invitationid;
}
public void setInvitationid(int invitationid) {
	this.invitationid = invitationid;
}
public String getCommentPerson() {
	return commentPerson;
}
public void setCommentPerson(String commentPerson) {
	this.commentPerson = commentPerson;
}

}
