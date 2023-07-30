package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;
import model.Report;
public class ReportDAO {
	
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	int report_id;
	int t_order_id; 
	String t_subject; 
	String t_description; 
	Date t_date; 
	String t_type;
	double t_refund_amount;
	String u_email;
	
	//get all reports
	public static List<Report> getAllReports()
	{
		List<Report> report = new ArrayList<Report>();
		
		try {
			//call getConnection() method from ConnectionManager class			
			con = ConnectionManager.getConnection(); 
			
			//3. create statement
			String sql = "SELECT * FROM report";
			stmt = con.createStatement();
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Report r = new Report();
				r.setReport_id(rs.getInt("report_id"));
				r.setU_email(rs.getString("u_email"));
				r.setT_order_id(rs.getInt("t_order_id"));
				r.setT_date(rs.getDate("t_date"));
				r.setT_type(rs.getString("t_type"));
				r.setT_refund_amount(rs.getDouble("t_refund_amount"));
				r.setT_subject(rs.getString("t_subject"));
				r.setT_description(rs.getString("t_description"));
				r.setCustomer(CustomerDAO.getCustomerByEmail(rs.getString("u_email")));
				report.add(r);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	
	//get report by user
	public static Report getReportByUser(String u_email) {
		Report r = new Report();
	try {
		//call getConnection() method from ConnectionManager class			
		con = ConnectionManager.getConnection(); 
		
		//3. create statement
		String sql = "SELECT * FROM report WHERE u_email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, u_email);
		
		//4. execute query
		rs = ps.executeQuery();
		if(rs.next())
		{	
			r.setReport_id(rs.getInt("report_id"));
			r.setU_email(rs.getString("u_email"));
			r.setT_order_id(rs.getInt("t_order_id"));
			r.setT_date(rs.getDate("t_date"));
			r.setT_type(rs.getString("t_type"));
			r.setT_refund_amount(rs.getDouble("t_refund_amount"));
			r.setT_subject(rs.getString("t_subject"));
			r.setT_description(rs.getString("t_description"));
			r.setCustomer(CustomerDAO.getCustomerByEmail(rs.getString("u_email")));
			
		}
		
		//5. close connection
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return r;
	}
	
	public static Report getReportById(int report_id) {
		Report r = new Report();
	try {
		//call getConnection() method from ConnectionManager class			
		con = ConnectionManager.getConnection(); 
		
		//3. create statement
		String sql = "SELECT * FROM report WHERE report_id=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, report_id);
		
		//4. execute query
		rs = ps.executeQuery();
		if(rs.next())
		{	
			r.setReport_id(rs.getInt("report_id"));
			r.setU_email(rs.getString("u_email"));
			r.setT_order_id(rs.getInt("t_order_id"));
			r.setT_date(rs.getDate("t_date"));
			r.setT_type(rs.getString("t_type"));
			r.setT_refund_amount(rs.getDouble("t_refund_amount"));
			r.setT_subject(rs.getString("t_subject"));
			r.setT_description(rs.getString("t_description"));
			r.setCustomer(CustomerDAO.getCustomerByEmail(rs.getString("u_email")));
			
		}
		
		//5. close connection
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return r;
	}
	
	//add report
	public void addComplaint(Report rep) {
		u_email = rep.getU_email();
		t_order_id = rep.getT_order_id();
		t_subject = rep.getT_subject();
		t_description = rep.getT_description();
		t_date = rep.getT_date();
		t_type = rep.getT_type();
		t_refund_amount = rep.getT_refund_amount();
		
		try {
			
			//call getConnection() method from ConnectionManager class			
			con = ConnectionManager.getConnection(); 
			System.out.print("connected");
			//3. create statement
			String sql = "INSERT INTO report (u_email,t_order_id,t_subject,t_description,t_date,t_type,t_refund_amount) VALUES (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, u_email);
			ps.setInt(2, t_order_id);
			ps.setString(3, t_subject);
			ps.setString(4, t_description);
			ps.setDate(5, t_date);
			ps.setString(6, t_type);
			ps.setDouble(7, t_refund_amount);
			
			//System.out.println("Report dao: " + u_email);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update complaint
	public void updateComplaint(Report rep) {
		report_id = rep.getReport_id();
		t_order_id = rep.getT_order_id();
		t_subject = rep.getT_subject();
		t_description = rep.getT_description();
		t_date = rep.getT_date();
		t_type = rep.getT_type();
		t_refund_amount = rep.getT_refund_amount();
		
		try{
		    // call getConnection()method from ConnectionManager class
		    con=ConnectionManager.getConnection();
		    
		    //3.create statement
		    String sql = "UPDATE report SET t_order_id=?,t_subject=?,t_description=?,t_date=?,t_type=?,t_refund_amount=? WHERE report_id=?";
		    ps = con.prepareStatement(sql);
		    ps.setInt(1, t_order_id);
			ps.setString(2, t_subject);
			ps.setString(3, t_description);
			ps.setDate(4, t_date);
			ps.setString(5, t_type);
			ps.setDouble(6, t_refund_amount);
			ps.setInt(7, report_id);
		    
		    //4.execute query
		    ps.executeUpdate(); //or ps.execute();
		    
		    //5.close connection
		    con.close();
		    
		}catch(Exception e){
		    e.printStackTrace();
		}
	}

		//delete complaint
		public void deleteComplaint(int report_id) {
			try{
			    // call getConnection()method from ConnectionManager class
			    con=ConnectionManager.getConnection();
			    
			    //3.create statement
			    String sql = "DELETE FROM report WHERE report_id=?";
			    ps = con.prepareStatement(sql);
			    ps.setInt(1, report_id);
			   
			    //4.execute query
			    ps.executeUpdate(); //or ps.execute();
			    
			    //5.close connection
			    con.close();
			    
			}catch(Exception e){
			    e.printStackTrace();
			}
	}
}
