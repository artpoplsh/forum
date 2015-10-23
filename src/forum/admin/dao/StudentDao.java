package forum.admin.dao;

import java.util.List;

import forum.admin.domain.Student;


public interface StudentDao {
	public Student getStudentById(String id);
	public List getLimitStudent(String id,String teacherId,int from, int size,String sortBy,String order);
	public List getAllStudent(String id,String teacherId,String orderBy,String order);
	public int getStudentCount(String id,String teacherId);
	public void updateStudent(String id,int limits);
}
