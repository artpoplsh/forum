package forum.teacher.dao;

import java.util.ArrayList;

import forum.teacher.domain.Teacher;

public interface TeacherDao {
	int addTeacher(Teacher teacher);
	int delTeacher(Teacher teacher);
	int updateTeacher(Teacher teacher);
	Teacher getTeacherById(String idString);
	ArrayList<Teacher> getAllTeacher();

}
