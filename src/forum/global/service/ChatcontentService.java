package forum.global.service;

import java.util.ArrayList;

import forum.global.domain.Chatcontent;;

public interface ChatcontentService {
	int addChatcontent(Chatcontent chatcontent);

	int deleteChatcontent(Chatcontent chatcontent);

	int updateChatcontent(Chatcontent chatcontent);

	Chatcontent getChatcontentById(String idString);
	
	ArrayList<Chatcontent> getAllChatcontent();
}
