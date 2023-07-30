package model;

public class Customer { 
	 String u_name; 
	 String u_email; 

	 
	public Customer() {
	}

	public Customer(String n, String e) { 
		u_name=n; u_email=e;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	
}