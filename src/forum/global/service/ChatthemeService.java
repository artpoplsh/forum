package forum.global.service;

import java.util.ArrayList;

import forum.global.domain.Chattheme;

public interface ChatthemeService {
	int addChattheme(Chattheme chattheme);
	int delChattheme(Chattheme chattheme);
	int updateChattheme(Chattheme chattheme);
	Chattheme getChatthemeById(String idString);
	ArrayList<Chattheme> getAllChattheme();
}
