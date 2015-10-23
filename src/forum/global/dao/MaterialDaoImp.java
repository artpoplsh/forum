package forum.global.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import forum.util.Dbutil;
import forum.global.dao.MaterialDao;
import forum.global.domain.Material;


public class MaterialDaoImp implements MaterialDao{
	private Dbutil dbutil;
	private static final String SQL_INSERT="insert into material (title,hyperlinkaddress,teacherid,description) values(?,?,?,?)";
	private static final String SQL_DEL="delete from material where id=?";
	private static final String SQL_UPDATE="update material set title=?,hyperlinkaddress=?,teacherid=?,description=? where id=?";
	private static final String SQL_QUERY="select * from material where id=?";
	private static final String SQL_QUERYALL="select * from material";
	
	public MaterialDaoImp (){
		super();
		this.dbutil = new Dbutil();
	}
	
	@Override
	public int addMaterial(Material material) {
		// TODO Auto-generated method stub
		Connection conn = dbutil.getConn();
		PreparedStatement pstmt = null;

		System.out.println(material.getDescription());
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(2, material.getHyperlinkaddress());
			pstmt.setString(1, material.getTitle());
			pstmt.setString(3, material.getTeacherid());
			pstmt.setString(4,material.getDescription());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			   return 0;
			else return 1;
		}catch(SQLException e){
			e.printStackTrace();
			return 1;
		}
			finally {
				dbutil.releaseResource(conn, pstmt, null);
			}
			
	}
    
	@Override
	public int delMaterial(int id) {
		Connection conn = dbutil.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_DEL);
			pstmt.setInt(1, id);
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			   return 0;
			else return 1;
		}catch(SQLException e){
			e.printStackTrace();
			return 1;
		}
			finally {
				dbutil.releaseResource(conn, pstmt, null);
			}
	}

	@Override
	public int updateMaterial(Material material) {
		// TODO Auto-generated method stub
		Connection conn = dbutil.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(2, material.getHyperlinkaddress());
			pstmt.setString(1, material.getTitle());
			pstmt.setString(3, material.getTeacherid());
			pstmt.setString(4, material.getDescription());
			pstmt.setInt(5, material.getId());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			   return 0;
			else return 1;
		}catch(SQLException e){
			e.printStackTrace();
			return 1;
		}
			finally {
				dbutil.releaseResource(conn, pstmt, null);
			}
	}

	@Override
	public Material getMaterialById(int id) {
		// TODO Auto-generated method stub
		Connection conn = dbutil.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_QUERY);
            pstmt.setInt(1, id);
			
			ResultSet rs =pstmt.executeQuery();
			if(rs.first()){
				Material material = new Material();
				material.setId(rs.getInt("id"));
				material.setHyperlinkaddress(rs.getString("hyperlinkaddress"));
				material.setTitle(rs.getString("title"));
				material.setTeacherid(rs.getString("teacherid"));
				material.setDescription(rs.getString("description"));
				return material;
			}else{
				return null;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
			finally {
				dbutil.releaseResource(conn, pstmt, null);
			}
	}


	@Override
	public ArrayList<Material> getAllMaterial() {
		// TODO Auto-generated method stub
		Connection conn = dbutil.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_QUERYALL);
			
			ResultSet rs =pstmt.executeQuery();
			ArrayList<Material> list = new ArrayList<Material>();
			while(rs.next()){
				Material material = new Material();
				material.setId(rs.getInt("id"));
				material.setHyperlinkaddress(rs.getString("hyperlinkaddress"));
				material.setTitle(rs.getString("title"));
				material.setTeacherid(rs.getString("teacherid"));
				material.setDescription(rs.getString("description"));
				list.add(material);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
			finally {
				dbutil.releaseResource(conn, pstmt, null);
			}
	}

}
