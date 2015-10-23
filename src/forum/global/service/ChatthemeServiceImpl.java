package forum.global.service;

import java.util.ArrayList;
import forum.global.dao.ChatthemeDao;
import forum.global.dao.ChatthemeDaoImpl;
import forum.global.domain.Chattheme;

public class ChatthemeServiceImpl implements ChatthemeService{

	@Override
	public int addChattheme(Chattheme chattheme) {
		// TODO Auto-generated method stub
		ChatthemeDao chatthemeDao = new ChatthemeDaoImpl();
		return chatthemeDao.addChattheme(chattheme);
	}

	@Override
	public int delChattheme(Chattheme chattheme) {
		// TODO Auto-generated method stub
		ChatthemeDao chatthemeDao = new ChatthemeDaoImpl();
		return chatthemeDao.delChattheme(chattheme);
	}

	@Override
	public int updateChattheme(Chattheme chattheme) {
		// TODO Auto-generated method stub
		ChatthemeDao chatthemeDao = new ChatthemeDaoImpl();
		return chatthemeDao.updateChattheme(chattheme);
	}

	@Override
	public Chattheme getChatthemeById(String idString) {
		// TODO Auto-generated method stub
		ChatthemeDao chatthemeDao = new ChatthemeDaoImpl();
		return chatthemeDao.getChatthemeById(idString);
	}

	@Override
	public ArrayList<Chattheme> getAllChattheme() {
		// TODO Auto-generated method stub
		ChatthemeDao chatthemeDao = new ChatthemeDaoImpl();
		return chatthemeDao.getAllChattheme();
	}

}
