package forum.student.dao;

import java.util.ArrayList;

import forum.student.domain.Student;


public interface StudentsDao {

	int addStudent(Student student);
	int delStudent(Student student);
	int updateStudent(Student student);
	Student getStudentById(String idString);
	Student getStudentByName(String name);
	ArrayList<Student> getAllStudent();
}
