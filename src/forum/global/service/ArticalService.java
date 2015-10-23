package forum.global.service;

import java.util.ArrayList;
import java.util.List;

import forum.global.domain.Artical;


public interface  ArticalService {
	int addArtical(Artical artical);

	int deleteArtical(Artical artical);

	int updateArtical(Artical artical);

	Artical getArticalById(String idString);
	
	ArrayList<Artical> getAllArtical();
}
