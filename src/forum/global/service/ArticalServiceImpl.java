package forum.global.service;

import java.util.ArrayList;
import forum.global.dao.ArticalDao;
import forum.global.dao.ArticalDaoImpl;
import forum.global.domain.Artical;

public class ArticalServiceImpl implements ArticalService{

	@Override
	public int addArtical(Artical artical) {
		// TODO Auto-generated method stub
		ArticalDao articalDao = new ArticalDaoImpl();
		return articalDao.addArtical(artical);
	}

	@Override
	public int deleteArtical(Artical artical) {
		// TODO Auto-generated method stub
		ArticalDao articalDao = new ArticalDaoImpl();
		return articalDao.delArtical(artical);
	}

	@Override
	public int updateArtical(Artical artical) {
		// TODO Auto-generated method stub
		ArticalDao articalDao = new ArticalDaoImpl();
		return articalDao.updateArtical(artical);
	}

	@Override
	public Artical getArticalById(String idString) {
		// TODO Auto-generated method stub
		ArticalDao articalDao = new ArticalDaoImpl();
		Artical artical=new Artical();
		artical=articalDao.getArticalById(idString);
		return artical;
	}

	@Override
	public ArrayList<Artical> getAllArtical() {
		// TODO Auto-generated method stub
		ArticalDao articalDao = new ArticalDaoImpl();
		return articalDao.getAllArtical();
	}

}
