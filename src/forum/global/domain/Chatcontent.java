package forum.global.domain;
import java.util.ArrayList;

import forum.global.domain.*;
public class Chatcontent {
	private String id;
	private String content;
	private String chatthemeid;
	private String senderid;
	private String issend;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getChatthemeid() {
		return chatthemeid;
	}
	public void setChatthemeid(String chatthemeid) {
		this.chatthemeid = chatthemeid;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getIssend() {
		return issend;
	}
	public void setIssend(String issend) {
		this.issend = issend;
	}

}
