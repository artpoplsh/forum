package forum.global.domain;
import javax.management.loading.PrivateClassLoader;

import forum.global.domain.Artical;
public class Handinhomework {
	private int id;
	private int releasehomeworkid;
	private String studentid;
	private double mark;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReleasehomeworkid() {
		return releasehomeworkid;
	}
	public void setReleasehomeworkid(int releasehomeworkid) {
		this.releasehomeworkid = releasehomeworkid;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double d) {
		this.mark = d;
	}
	
}
