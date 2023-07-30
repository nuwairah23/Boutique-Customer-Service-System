package model;

import java.sql.Date;

public class Report { 
		
	 int t_order_id;
	 String u_email;
	 int report_id;
	 String t_subject; 
	 String t_description; 
	 Date t_date; 
	 String t_type;
	 double t_refund_amount;
	 Customer customer;
	 

	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public int getT_order_id() {
		return t_order_id;
	}
	public void setT_order_id(int t_order_id) {
		this.t_order_id = t_order_id;
	}
	public String getT_subject() {
		return t_subject;
	}
	public void setT_subject(String t_subject) {
		this.t_subject = t_subject;
	}
	public String getT_description() {
		return t_description;
	}
	public void setT_description(String t_description) {
		this.t_description = t_description;
	}
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public double getT_refund_amount() {
		return t_refund_amount;
	}
	public void setT_refund_amount(double t_refund_amount) {
		this.t_refund_amount = t_refund_amount;
	}
	
	
}