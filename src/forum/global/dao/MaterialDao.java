package forum.global.dao;
import java.util.ArrayList;

import forum.global.domain.*;
public interface MaterialDao {
	int addMaterial(Material material);
	int delMaterial(int id);
	int updateMaterial(Material material);
	Material getMaterialById(int id);
	ArrayList<Material> getAllMaterial();


}
