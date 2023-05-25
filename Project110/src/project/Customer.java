package project;

import java.io.*;
import java.util.ArrayList;

class Customer extends User implements Serializable{
	
	private int CustomerID;
	private String CusFirstName;
	private String CusLastName;
	private String CusAddress;
	private String CusPhoneNumber;
	private String CustomerUsername;
	private String CustomerPassword;
	ArrayList<Customer> customers = new ArrayList<>();
	ArrayList<CAR> cars = new ArrayList<>();

	public Customer() {
	}
	Customer(int CustomerID, String cusFirstName, String cusPhoneNumber, String cusAddress, String customerPassword){
		this.CustomerID = CustomerID;
		this.CusFirstName = cusFirstName;
		this.CustomerPassword = customerPassword;
		this.CusPhoneNumber = cusPhoneNumber;
		this.CusAddress = cusAddress;

	}

	public int getCustomerID() {
		return super.getuserID();
	}
	public void setCustomerID(int customerID) {
		super.setuserID(customerID);
	}
	public String getCusFirstName() {
		return super.getuserName();
	}
	public void setCusFirstName(String cusFirstName) {
		super.setuserName(cusFirstName);
	}
	//this is for update new name 
	public void setCusFirstname(String cusFirstName) {
		System.out.println("Setting new user name: " + cusFirstName);
	    this.CusFirstName = cusFirstName;
	}
	public String getCusFirstname() {
		return CusFirstName;
	}
	
	public String getCusAddress() {
		return super.getAddress();
	}
	public void setCusAddress(String cusAddress) {
		super.setAddress(cusAddress);;
	}
	public String getCusPhoneNumber() {
		return super.getPhoneNumber();
	}
	public void setCusPhoneNumber(String cusPhoneNumber) {
		super.setPhoneNumber(cusPhoneNumber);
	}
	
	public String getCusLastName() {
		return CusLastName;
	}
	public void setCusLastName(String cusLastName) {
		this.CusLastName = cusLastName;
	}

	public String getCustomerUsername() {
		return CusFirstName;
	}
	public void setCustomerUsername(String customerUsername) {
		CustomerUsername = customerUsername;
	}
	public String getCustomerPassword() {
		return CustomerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}
	@Override
	public void display() {
		System.out.println(
				"UserID                : #C"+CustomerID+
			    "\nUserName              : "+CusFirstName+
			    "\nCustomer Address      : "+CusAddress+
			    "\nCustomer Phone Number : "+CusPhoneNumber+
			    "\nPassword              : "+CustomerPassword);
		
	}
	@Override
	public int UserUniqueID() {
		return super.UserUniqueID();	
	}
	
	
	public ArrayList<Customer> readCustomerList() {
	    ArrayList<Customer> customers = new ArrayList<>();

	    try (FileInputStream cfis = new FileInputStream("CustomerList.txt");
	         ObjectInputStream cois = new ObjectInputStream(cfis)) {

	        customers = (ArrayList<Customer>) cois.readObject();

	        cois.close();
	        cfis.close();

	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error while loading customers data: " + e.getMessage());
	    }

	    return customers;
	}

}















