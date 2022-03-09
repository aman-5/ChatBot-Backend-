package com.askme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "normalUser")
public class NormalUser {

	//It only contains fields like - First Name, Last Name, User Name, Email, Phone Number. 
	@Id
	private String id;
	private String emailID;
	private String password;
	private String firstName;
	private String lastName;
	private String userName;
	
	public NormalUser(String emailID, String password, String firstName, String lastName, String userName) {
		super();
		this.emailID = emailID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
