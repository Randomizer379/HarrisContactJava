import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConn {
	Connection connection = null;
	
	public Connection get_connection() {
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactsdb","root","");
			System.out.println("Connected to database");
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Could not connect to database");
			
		}
		
		
		return connection;
	
		 
	}
	//Gets all records within Database
	public ResultSet getAll(){
		get_connection();
		
		ResultSet rs = null;
		String sql = "{call selectAllContact()}";
		
		try {
			java.sql.CallableStatement cst;
			cst = connection.prepareCall(sql);
			rs = cst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not retrieve data.");
		}
		
		return rs;
		
	}
	
		//Updates contact record within Database (Broken)	
		public void UpdateContact(String name, String surname, String email, String phone, String address, String city, String postcode, String type, String id) {
			get_connection();
			
			ResultSet rs = null;
			String sql = "{call updateContact(?,?,?,?,?,?,?,?,?)}";
			
			try {
				java.sql.CallableStatement cst = connection.prepareCall(sql);
				
				cst.setString(1, id);
				cst.setString(2, name);
				cst.setString(3, surname);
				cst.setString(4, email);
				cst.setString(5, phone);
				cst.setString(6, address);
				cst.setString(7, city);
				cst.setString(8, postcode);
				cst.setString(9, type);				
				rs = cst.executeQuery();


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not update data.");
			}
		}
		
		//Creates contact record within Database (Broken)
		public void CreateContact(String name, String surname, String email, String phone, String address, String city, String postcode, String type) {
			String sql = "{call createContact(?,?,?,?,?,?,?,?)}";
			java.sql.CallableStatement cst;
			try {
				cst = connection.prepareCall(sql);
				cst.setString(1, name);
				cst.setString(2, surname);
				cst.setString(3, email);
				cst.setString(4, phone);
				cst.setString(5, address);
				cst.setString(6, city);
				cst.setString(7, postcode);
				cst.setString(8, type);
				cst.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not create contact.");
			}
		}
		//Creates contact record within Database (Broken)
		public void DeleteContact(String id) {
			String sql = "{call deleteContact(?)}";
			java.sql.CallableStatement cst;
			try {
				cst = connection.prepareCall(sql);
				cst.setString(1,  id);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			
}

