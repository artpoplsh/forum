package forum.global.domain;
import java.util.Date;


public class Artical {
	private String articalId;
	private String articalTitle;
	private String articalContent;
	private String articalAuthor; 
    private Date  articalCreatetime;
	public String getArticalId() {
		return articalId;
	}
	public void setArticalId(String articalId) {
		this.articalId = articalId;
	}
	public String getArticalTitle() {
		return articalTitle;
	}
	public void setArticalTitle(String articalTitle) {
		this.articalTitle = articalTitle;
	}
	public String getArticalContent() {
		return articalContent;
	}
	public void setArticalContent(String articalContent) {
		this.articalContent = articalContent;
	}
	public String getArticalAuthor() {
		return articalAuthor;
	}
	public void setArticalAuthor(String articalAuthor) {
		this.articalAuthor = articalAuthor;
	}
	public Date getArticalCreatetime() {
		return articalCreatetime;
	}
	public void setArticalCreatetime(Date articalCreatetime) {
		this.articalCreatetime = articalCreatetime;
	}
    
	
}
