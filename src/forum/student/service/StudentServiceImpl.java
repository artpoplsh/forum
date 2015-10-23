package forum.student.service;

import java.util.ArrayList;

import forum.student.dao.StudentsDao;
import forum.student.dao.StudentsDaoImpl;
import forum.student.domain.Student;

public class StudentServiceImpl implements StudentService {

	private StudentsDao sDao;
	public StudentServiceImpl()
	{
		this.sDao=new StudentsDaoImpl();
	}
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student getStudentByIdCard(String idString) {
		// TODO Auto-generated method stub
		return this.sDao.getStudentById(idString);
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Student getStudentByName(String name){
		return  this.sDao.getStudentByName(name);
	}

}
