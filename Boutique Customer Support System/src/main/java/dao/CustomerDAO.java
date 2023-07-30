package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;
import model.Customer;

public class CustomerDAO {

	
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String u_name; 
	String u_email; 
	
	//get all customers
	public static List<Customer> getAllCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			//call getConnection() method from ConnectionManager class			
			con = ConnectionManager.getConnection(); 
			
			//3. create statement
			String sql = "SELECT * FROM customer";
			stmt = con.createStatement();
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Customer customer = new Customer();
				customer.setU_email(rs.getString("u_email"));
				customer.setU_name(rs.getString("u_name"));
				customers.add(customer);
				
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	//get customer by id
	public static Customer getCustomerByEmail(String u_email) {
		Customer customer = new Customer();
	try {
		//call getConnection() method from ConnectionManager class			
		con = ConnectionManager.getConnection(); 
		
		//3. create statement
		String sql = "SELECT * FROM customer WHERE u_email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, u_email);
		
		//4. execute query
		rs = ps.executeQuery();
		if(rs.next())
		{	
			customer.setU_email(rs.getString("u_email"));
			customer.setU_name(rs.getString("u_name"));
		}
		
		//5. close connection
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return customer;
	}
	//get customer by name
		public static Customer getCustomerByName(String u_name) {
			Customer customer = new Customer();
		try {
			//call getConnection() method from ConnectionManager class			
			con = ConnectionManager.getConnection(); 
			
			//3. create statement
			String sql = "SELECT * FROM customer WHERE u_name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, u_name);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next())
			{	
				customer.setU_email(rs.getString("u_email"));
				customer.setU_name(rs.getString("u_name"));
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
		}
	
	//add customer
	public void newCustomer(Customer cus) {
		
		u_name = cus.getU_name();
		u_email = cus.getU_email();
		
		try {
			
			//call getConnection() method from ConnectionManager class			
			con = ConnectionManager.getConnection(); 
			System.out.print("connected");
			//3. create statement
			String sql = "INSERT INTO customer (u_name, u_email) VALUES (?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, u_name);
			ps.setString(2, u_email);
			
			System.out.println("Report dao: " + u_name);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
