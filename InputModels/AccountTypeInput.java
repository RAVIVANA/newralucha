package com.nkxgen.spring.jdbc.InputModels;

public class AccountTypeInput {
	private String accountType;
	private String descriptionForm;
	private Integer accountId;

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
}
