package com.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	
	private int id;
	
    private String name;
@Column(name="user_name")
    private String username;
	@Column(name="email_id")
	private String emailid;
@Column(name="mobile_number")
	private long mobileno;

	private String password;
	
	
	private Boolean active;
	
	
public User(){
	
}




	public User(String name, String username, String emailid, long mobileno, String password,Boolean active) {
	super();
	
	this.name = name;
	this.username = username;
	this.emailid = emailid;
	this.mobileno = mobileno;
	this.password = password;
	this.active = active;
	
}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public String getEmailid() {
		return emailid;
	}




	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getMobileno() {
		return mobileno;
	}


	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", emailid=" + emailid + ", mobileno="
				+ mobileno + ", password=" + password + ", active=" + active + "]";
	}


		
}
