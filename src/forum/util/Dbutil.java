package forum.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
public class Dbutil {
	private static final String CONN_URL="jdbc:mysql://localhost:3306/forum?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME="root";
	private static final String PASSWORD="123";
	public Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.print("dbutil");
			conn =DriverManager.getConnection(CONN_URL,USERNAME,PASSWORD);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public void releaseResource(Connection conn,PreparedStatement pstmt,ResultSet rset){
		try {
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
