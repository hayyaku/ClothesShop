package com.clothesshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fullname")
	private String fullName;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String passWord;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="roleid", referencedColumnName = "id")
	private Role roleId;
	
	private String email;
	
	private String phone;


	public User() {
	}


	public Long getId() {
		return id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	public Role getRoleId() {
		return roleId;
	}


	public void setRoleId(Role roleId) {
		this.roleId = roleId;
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


}
