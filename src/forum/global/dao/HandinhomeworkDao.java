package forum.global.dao;
import java.util.ArrayList;

import forum.global.domain.*;
import forum.global.domain.Chattheme;
public interface HandinhomeworkDao {
	int addHandinhomework(Handinhomework artical);
	int delHandinhomework(int client);
	int updateHandinhomework(Handinhomework client);
	Handinhomework getHandinhomeworkById(String idString);
	ArrayList<Handinhomework> getAllHandinhomework();

}
