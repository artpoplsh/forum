package forum.global.service;

import java.util.ArrayList;

import forum.global.dao.ArticalDao;
import forum.global.dao.ArticalDaoImpl;
import forum.global.dao.ChatcontentDao;
import forum.global.dao.ChatcontentDaoImpl;
import forum.global.domain.Chatcontent;

public class ChatcontentServiceImpl implements ChatcontentService {

	@Override
	public int addChatcontent(Chatcontent chatcontent) {
		// TODO Auto-generated method stub
		ChatcontentDao chatcontentDao = new ChatcontentDaoImpl();
		return chatcontentDao.addChatcontent(chatcontent);
	}

	@Override
	public int deleteChatcontent(Chatcontent chatcontent) {
		// TODO Auto-generated method stub
		ChatcontentDao chatcontentDao = new ChatcontentDaoImpl();
		return chatcontentDao.delChatcontent(chatcontent);
	}

	@Override
	public int updateChatcontent(Chatcontent chatcontent) {
		// TODO Auto-generated method stub
		ChatcontentDao chatcontentDao = new ChatcontentDaoImpl();
		return chatcontentDao.updateChatcontent(chatcontent);
	}

	@Override
	public Chatcontent getChatcontentById(String idString) {
		// TODO Auto-generated method stub
		ChatcontentDao chatcontentDao = new ChatcontentDaoImpl();
		return chatcontentDao.getChatcontentById(idString);
	}

	@Override
	public ArrayList<Chatcontent> getAllChatcontent() {
		// TODO Auto-generated method stub
		ChatcontentDao chatcontentDao = new ChatcontentDaoImpl();
		return chatcontentDao.getAllChatcontent();
	}

}
