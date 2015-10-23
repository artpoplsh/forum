package forum.global.service;

import java.util.ArrayList;
import java.util.List;



import forum.global.dao.ReleasehomeworkDao;
import forum.global.dao.ReleasehomeworkDaoImpl;
import forum.global.service.ReleasehomeworkService;
import forum.global.domain.Releasehomework;

public class ReleasehomeworkServiceImpl implements ReleasehomeworkService {

	@Override
	public int addReleasehomework(Releasehomework artical) {
		// TODO Auto-generated method stub
				ReleasehomeworkDao relehomedao = (ReleasehomeworkDao) new ReleasehomeworkDaoImpl();
				if(artical.getId()!=0){
					Releasehomework rh = relehomedao.getReleasehomeworkById(artical.getId());
				if (rh!=null)
					return 1;}
				return relehomedao.addReleasehomework(artical);
	}

	@Override
	public boolean delReleasehomework(int id) {
		// TODO Auto-generated method stub
		ReleasehomeworkDao relehomedao = (ReleasehomeworkDao) new ReleasehomeworkDaoImpl();
		return relehomedao.delReleasehomework(id);
	}

	@Override
	public boolean updateReleasehomework(Releasehomework artical) {
		// TODO Auto-generated method stub
		ReleasehomeworkDao relehomedao = (ReleasehomeworkDao) new ReleasehomeworkDaoImpl();
		return relehomedao.updateReleasehomework(artical);
	}

	@Override
	public Releasehomework getReleasehomeworkById(int id) {
		// TODO Auto-generated method stub
		ReleasehomeworkDao relehomedao = (ReleasehomeworkDao) new ReleasehomeworkDaoImpl();
		return relehomedao.getReleasehomeworkById(id);
	}

	@Override
	public ArrayList<Releasehomework> getAllReleasehomework() {
		// TODO Auto-generated method stub
		ReleasehomeworkDao relehomedao = (ReleasehomeworkDao) new ReleasehomeworkDaoImpl();
		return relehomedao.getAllReleasehomework();
	}

	@Override
	public Releasehomework getReleasehomeworkByTitle(String title) {
		// TODO Auto-generated method stub
		ReleasehomeworkDao relehomedao = (ReleasehomeworkDao) new ReleasehomeworkDaoImpl();
		return relehomedao.getReleasehomeworkByTitle(title);
	}

}
