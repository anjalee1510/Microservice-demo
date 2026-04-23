package com.cg.model;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("user-data")
public class User {
//	private String id;
	@Id
	private String userName;
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;
	private String contactNo;
	//private String role;
	
	 
	
	public User() {}

	public User(String userName, String firstName, String lastName, String emailID, String password,
			String contactNo,String role) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
		this.contactNo = contactNo;
		//this.role = role;
	}
	
	


//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

//	@Override
//	public String toString() {
//		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID="
//				+ emailID + ", password=" + password + ", contactNo=" + contactNo + ", role=" + role + "]";
//	}
//	

}
