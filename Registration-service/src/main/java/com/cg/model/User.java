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
	
	private String password;
	private String contactNo;
	
	
	 
	
	public User() {}

	public User(String userName, String firstName, String lastName,  String password,
			String contactNo) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactNo = contactNo;
		
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


//	@Override
//	public String toString() {
//		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID="
//				+ emailID + ", password=" + password + ", contactNo=" + contactNo + ", role=" + role + "]";
//	}
//	

}
