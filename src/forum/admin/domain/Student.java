package forum.admin.domain;

public class Student {

	private String id;
	private String name;
	private String password;
	private String sex;
	private String teacherId;
	private int limits;
	private boolean createInvitation;//发帖权限
	private boolean leaveInvitation;//评论权限
	private boolean handInMaterial;//上传资料权限
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * @return the limits
	 */
	public int getLimits() {
		return limits;
	}
	/**
	 * @param limits the limits to set
	 */
	public void setLimits(int limits) {
		this.limits = limits;
	}
	/**
	 * @return the createInvitation
	 */
	public boolean isCreateInvitation() {
		return createInvitation;
	}
	/**
	 * @param createInvitation the createInvitation to set
	 */
	public void setCreateInvitation(boolean createInvitation) {
		this.createInvitation = createInvitation;
	}
	/**
	 * @return the leaveInvitation
	 */
	public boolean isLeaveInvitation() {
		return leaveInvitation;
	}
	/**
	 * @param leaveInvitation the leaveInvitation to set
	 */
	public void setLeaveInvitation(boolean leaveInvitation) {
		this.leaveInvitation = leaveInvitation;
	}
	/**
	 * @return the handInMaterial
	 */
	public boolean isHandInMaterial() {
		return handInMaterial;
	}
	/**
	 * @param handInMaterial the handInMaterial to set
	 */
	public void setHandInMaterial(boolean handInMaterial) {
		this.handInMaterial = handInMaterial;
	}
	
	
}
