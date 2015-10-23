package forum.global.dao;

import java.util.ArrayList;

import forum.global.domain.Artical;


public interface ArticalDao {
	int addArtical(Artical artical);
	int delArtical(Artical client);
	int updateArtical(Artical client);
	Artical getArticalById(String idString);
	ArrayList<Artical> getAllArtical();

}
