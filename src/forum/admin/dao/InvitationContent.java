package forum.admin.dao;

public class InvitationContent {
	private int id;
	private String content;//回复的内容
	private String date;
	private int invitationid;//所属的帖子的id
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the invitationid
	 */
	public int getInvitationid() {
		return invitationid;
	}
	/**
	 * @param invitationid the invitationid to set
	 */
	public void setInvitationid(int invitationid) {
		this.invitationid = invitationid;
	}
	

}
