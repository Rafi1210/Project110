package project;

import java.io.Serializable;

public class User implements Serializable {

	private int userID;
	private String userName;
	private String Password;
	private String Address;
	private String PhoneNumber; 
	
	public User() {
	}
	
User(int userID, String userName, String Password){
	this.userID = userID;
	this.userName = userName;
	this.Password = Password;
}
public int getuserID() {
	return userID;
}

public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	this.Address = address;
}
public String getPhoneNumber() {
	return PhoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.PhoneNumber = phoneNumber;
}

public void setuserID(int userID) {
	this.userID = userID;
}
public String getuserName() {
	return userName;
}
public void setuserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String Password) {
	this.Password = Password;
}

public int UserUniqueID() {
	userID =(int) (100001+Math.random()*100101);
	return userID;
}


public void display() {
	System.out.println("userID : "+getuserID()+
					    "\nuserName : "+getuserName()+
					    "\nPassword : "+getPassword());
}

}
