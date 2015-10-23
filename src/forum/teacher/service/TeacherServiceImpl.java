package forum.teacher.service;

import java.util.ArrayList;

import forum.student.dao.StudentsDao;
import forum.student.dao.StudentsDaoImpl;
import forum.teacher.dao.TeacherDao;
import forum.teacher.dao.TeacherDaoImpl;
import forum.teacher.domain.Teacher;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao tDao;
	public TeacherServiceImpl()
	{
		this.tDao=new TeacherDaoImpl();
	}
	@Override
	public int addTeacher(Teacher student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delTeacher(Teacher student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacher(Teacher student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Teacher getTeacherByIdCard(String idString) {
		// TODO Auto-generated method stub
		return this.tDao.getTeacherById(idString);
	}

	@Override
	public ArrayList<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

}
