package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTP")
public class User {
	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}
