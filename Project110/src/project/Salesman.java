package project;

import java.io.Serializable;

public class Salesman extends User implements Serializable{
	private int SalesmanID;
	private String SalesFirstName;
	private String SalesLastName;
	private String SalesAddress;
	private String SalesPhoneNumber;
	private String SalesmanUsername;
	private String SalesmanPassword;
	
public Salesman() {
		
	}
	Salesman(int salesmanID,String salesFirstName,String salesPhoneNumber, String salesAddress, String salesmanPassword){
		this.SalesmanID=salesmanID;
		this.SalesFirstName=salesFirstName;
		this.SalesPhoneNumber=salesPhoneNumber;
		this.SalesAddress = salesAddress;
		this.SalesmanPassword = salesmanPassword;
	}
	
	public int getSalesmanID() {
		return super.getuserID();
	}
	public void setSalesmanID(int salesmanID) {
		super.setuserID(salesmanID);;
	}
	public String getSalesFirstName() {
		return super.getuserName();
	}
	public void setSalesFirstName(String salesFirstName) {
		super.setuserName(salesFirstName);
	}
	
	//this is for update new name 
		public void setSalesFirstname(String salesFirstName) {
			System.out.println("Setting new user name: " + salesFirstName);
		    this.SalesFirstName = salesFirstName;
		}
		public String getSalesFirstname() {
			return SalesFirstName;
		}
		
	
	public String getSalesLastName() {
		return SalesLastName;
	}
	public void setSalesLastName(String salesLastName) {
		this.SalesLastName = salesLastName;
	}
	public String getSalesAddress() {
		return super.getAddress();
	}
	public void setSalesAddress(String salesAddress) {
		super.setAddress(salesAddress);;
	}
	public String getSalesPhoneNumber() {
		return super.getPhoneNumber();
	}
	public void setSalesPhoneNumber(String salesPhoneNumber) {
		super.setPhoneNumber(salesPhoneNumber);
	}
	public String getSalesmanUsername() {
		return SalesFirstName;
	}
	public void setSalesmanUsername(String salesmanUsername) {
		SalesmanUsername = salesmanUsername;
	}
	public String getSalesmanPassword() {
		return SalesmanPassword;
	}
	public void setSalesmanPassword(String salesmanPassword) {
		SalesmanPassword = salesmanPassword;
	}
	@Override
	public int UserUniqueID() {
		return super.UserUniqueID();
	}
	@Override
	public void display() {
		System.out.println(
				"UserID                : #S"+ SalesmanID+
			    "\nUserName              : "+SalesFirstName+
			    "\nSalesman Address      : "+SalesAddress+
			    "\nSalesman Phone Number : "+SalesPhoneNumber+
			    "\nPassword              : "+SalesmanPassword);	}
}
