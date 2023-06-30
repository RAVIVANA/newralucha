package com.nkxgen.spring.jdbc.ViewModels;

import com.nkxgen.spring.jdbc.model.BankUser;

public class BankUserViewModel {
	private long busr_id;
	private String busr_title;
	private String busr_desg;
	private String busr_email;

	// Getters and setters

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

	public void setFromEntity(BankUser bankUser) {
		this.busr_id = bankUser.getBusr_id();
		this.busr_title = bankUser.getBusr_title();
		this.busr_desg = bankUser.getBusr_desg();
		this.busr_email = bankUser.getBusr_email();
	}
}
