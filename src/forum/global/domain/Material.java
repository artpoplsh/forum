package forum.global.domain;

public class Material {
	private int id;
	private String title;
	private String hyperlinkaddress;
	private String teacherid;
	private String description;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHyperlinkaddress() {
		return hyperlinkaddress;
	}
	public void setHyperlinkaddress(String hyperlinkaddress) {
		this.hyperlinkaddress = hyperlinkaddress;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	
	
}
