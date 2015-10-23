package forum.global.service;

import java.util.ArrayList;
import forum.global.dao.HandinhomeworkDao;
import forum.global.dao.HandinhomeworkDaoImpl;
import forum.global.domain.Handinhomework;

public class HandinhomeworkServiceImpl implements HandinhomeworkService{

	@Override
	public int addHandinhomework(Handinhomework handinhomework) {
		// TODO Auto-generated method stub
		HandinhomeworkDao handinhomeworkDao = new HandinhomeworkDaoImpl();
		return handinhomeworkDao.addHandinhomework(handinhomework);
	}

	@Override
	public int delHandinhomework(int handinhomework) {
		// TODO Auto-generated method stub
		HandinhomeworkDao handinhomeworkDao = new HandinhomeworkDaoImpl();
		return handinhomeworkDao.delHandinhomework(handinhomework);
	}

	@Override
	public int updateHandinhomework(Handinhomework handinhomework) {
		// TODO Auto-generated method stub
		HandinhomeworkDao handinhomeworkDao = new HandinhomeworkDaoImpl();
		return handinhomeworkDao.updateHandinhomework(handinhomework);
	}

	@Override
	public Handinhomework getHandinhomeworkById(String idString) {
		// TODO Auto-generated method stub
		HandinhomeworkDao handinhomeworkDao = new HandinhomeworkDaoImpl();
		return handinhomeworkDao.getHandinhomeworkById(idString);
	}

	/* (non-Javadoc)
	 * @see forum.global.service.HandinhomeworkService#getAllHandinhomework()
	 */
	@Override
	public ArrayList<Handinhomework> getAllHandinhomework() {
		// TODO Auto-generated method stub
		HandinhomeworkDao handinhomeworkDao = new HandinhomeworkDaoImpl();
		return handinhomeworkDao.getAllHandinhomework();
	}

}
