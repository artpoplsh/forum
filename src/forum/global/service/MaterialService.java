package forum.global.service;

import java.util.ArrayList;

import forum.global.dao.MaterialDao;
import forum.global.domain.Material;
import forum.global.dao.MaterialDaoImp;

public class MaterialService {
	MaterialDao materialdao = new MaterialDaoImp();
	
	
	public int addMaterial(Material material){
		return materialdao.addMaterial(material);
	}
	
	
	public int delMaterial(int id){
		return materialdao.delMaterial(id);
	}
	
	
	
	public int updateMaterial(Material material){
		return materialdao.updateMaterial(material);
	}
	
	
	public Material getMaterialById(int id){
		return materialdao.getMaterialById(id);
	}
	
	
	public ArrayList<Material> getAllMaterial(){
		return materialdao.getAllMaterial();
	}
}

