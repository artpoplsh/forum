package forum.admin.service;

import forum.admin.dao.AdminDao;
import forum.admin.dao.AdminDaoImpl;
import forum.admin.domain.Admin;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	public AdminServiceImpl()
	{
		this.adminDao=new AdminDaoImpl();
	}
	@Override
	public Admin getAdminById(String idString) {
		// TODO Auto-generated method stub
		return this.adminDao.getAdminById(idString);
	}

}
