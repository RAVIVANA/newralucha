package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nkxgen.spring.jdbc.InputModels.AccountTypeInput;

@Entity
@Table(name = "accounts2")
public class accountTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId")
	private Integer accountId;

	@Column(name = "accountType")
	private String accountType;

	@Column(name = "descriptionForm")
	private String descriptionForm;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDescriptionForm() {
		return descriptionForm;
	}

	public void setDescriptionForm(String descriptionForm) {
		this.descriptionForm = descriptionForm;
	}

	public void setInputModelValues(AccountTypeInput input) {
		this.accountType = input.getAccountType();
		this.descriptionForm = input.getDescriptionForm();
	}

}
