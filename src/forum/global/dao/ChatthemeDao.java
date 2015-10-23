package forum.global.dao;
import java.util.ArrayList;

import forum.global.domain.*;
public interface ChatthemeDao {
	int addChattheme(Chattheme artical);
	int delChattheme(Chattheme client);
	int updateChattheme(Chattheme client);
	Chattheme getChatthemeById(String idString);
	ArrayList<Chattheme> getAllChattheme();

}
