package com.clothesshop.dto;

public class UserDto {
	String fullName;
	String email;
	String phone;
	String userName;
	String passWord;
	String role;
	
	
	

	public UserDto(String fullName, String email, String phone, String userName, String passWord, String role) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDto() {
		super();
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
	
