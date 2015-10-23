package forum.student.domain;


public class Student {
	private String id; // 学生id
	private String name; // 学生姓名
	private String password; // 密码
	private String sex; // 学生性别
	private int limits;// 权限
	private String teacherId;//老师的id
//	public Student(String id, String name, String password, String sex,
//			int limits, String teacherIdString) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.password = password;
//		this.sex = sex;
//		this.limits = limits;
//		this.teacherIdString = teacherIdString;
//	}
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
	 * @return the teacherIdString
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * @param teacherIdString the teacherIdString to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	

}
