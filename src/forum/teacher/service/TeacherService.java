package forum.teacher.service;

import java.util.ArrayList;

import forum.teacher.domain.Teacher;

public interface TeacherService {
	int addTeacher(Teacher student);
	int delTeacher(Teacher student);
	int updateTeacher(Teacher student);
	Teacher getTeacherByIdCard(String idString);
	ArrayList<Teacher> getAllTeacher();

}
