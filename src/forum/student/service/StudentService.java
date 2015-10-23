package forum.student.service;

import java.util.ArrayList;

import forum.student.domain.Student;

public interface StudentService {
	int addStudent(Student student);
	int delStudent(Student student);
	int updateStudent(Student student);
	Student getStudentByIdCard(String idString);
	Student getStudentByName(String name);
	ArrayList<Student> getAllStudent();

}
