package com.nkxgen.spring.jdbc.InputModels;

public class BankUserInput {
	private String busr_title;
	private String busr_desg;
	private String busr_email;
	private String busr_pwd = "pennant@123";
	private long busr_id;

	public long getBusr_id() {
		return busr_id;
	}

	public void setBusr_id(long busr_id) {
		this.busr_id = busr_id;
	}

	public String getBusr_title() {
		return busr_title;
	}

	public void setBusr_title(String busr_title) {
		this.busr_title = busr_title;
	}

	public String getBusr_desg() {
		return busr_desg;
	}

	public void setBusr_desg(String busr_desg) {
		this.busr_desg = busr_desg;
	}

	public String getBusr_email() {
		return busr_email;
	}

	public void setBusr_email(String busr_email) {
		this.busr_email = busr_email;
	}

	public String getBusr_pwd() {
		return busr_pwd;
	}

	public void setBusr_pwd(String busr_pwd) {
		this.busr_pwd = busr_pwd;
	}
}
