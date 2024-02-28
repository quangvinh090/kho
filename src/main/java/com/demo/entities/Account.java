package com.demo.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Account {
	private String username;
	private String password;
	private String description;
	private String details;
	private String gender;	

	private int cert;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	private boolean status;
	
	private int[] languages;
	
	

	public int getCert() {
		return cert;
	}


	public void setCert(int cert) {
		this.cert = cert;
	}


	public String getGender() {
		return gender;
	}
	

	public int[] getLanguages() {
		return languages;
	}

	public void setLanguages(int[] languages) {
		this.languages = languages;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setGender(String gender) {
		this.gender = gender;
		
	}
	
	
	
}
