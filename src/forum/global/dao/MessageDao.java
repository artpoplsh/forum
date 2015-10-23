package forum.global.dao;
import java.util.ArrayList;

import forum.global.domain.*;
public interface MessageDao {

	int addMessage(Message artical);
	int delMessage(Message client);
	int updateMessage(Message client);
	Message getMessageById(String idString);
	ArrayList<Message> getAllMessage();

}
