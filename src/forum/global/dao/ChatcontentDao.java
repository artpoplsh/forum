package forum.global.dao;
import java.util.ArrayList;

import forum.global.domain.*;
public interface ChatcontentDao {
	int addChatcontent(Chatcontent artical);
	int delChatcontent(Chatcontent client);
	int updateChatcontent(Chatcontent client);
	Chatcontent getChatcontentById(String idString);
	ArrayList<Chatcontent> getAllChatcontent();

}
