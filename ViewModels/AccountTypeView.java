package com.nkxgen.spring.jdbc.ViewModels;

import com.nkxgen.spring.jdbc.model.accountTypes;

public class AccountTypeView {
	private Integer accountId;
	private String accountType;
	private String descriptionForm;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
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

	public AccountTypeView mapEntityToViewModel(accountTypes entity) {
		AccountTypeView viewModel = new AccountTypeView();
		viewModel.setAccountId(entity.getAccountId());
		viewModel.setAccountType(entity.getAccountType());
		viewModel.setDescriptionForm(entity.getDescriptionForm());
		return viewModel;
	}
}
