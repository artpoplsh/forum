package forum.admin.domain;

public class Invitation {
	private int id;//帖子的id
	private String title;//帖子的内容
	private String authorId;//发布者的id
	private int isChecked;//是否被审查了,1代表审查通过，0代表未审查，2代表审查不通过
	private String date;//时间
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the authorId
	 */
	public String getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the isChecked
	 */
	public int getIsChecked() {
		return isChecked;
	}
	/**
	 * @param isChecked the isChecked to set
	 */
	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
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
	

}
