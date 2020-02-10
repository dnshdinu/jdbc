package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbtest {
		static Connection con;
	public static void main(String[] args) throws SQLException {
    
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
				String sql="Select * from car";
				PreparedStatement ps = con.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int num=rs.getInt("no");
			String name=rs.getString("name");
		System.out.println(num);
		System.out.println(name);
			
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
