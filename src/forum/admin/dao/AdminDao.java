package forum.admin.dao;

import java.util.ArrayList;

import forum.admin.domain.Admin;
import forum.teacher.domain.Teacher;

public interface AdminDao {
	Admin getAdminById(String idString);

}
