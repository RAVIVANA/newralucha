package com.nkxgen.spring.jdbc.ViewModels;

import com.nkxgen.spring.jdbc.model.Account;

public class AccountViewModel {
	private Long applicationId;
	private String accountTypeId;
	private String applicationNomineeFirstName;
	private String applicationNomineeLastName;
	private Long customerId;
	private String createdDate;
	private long createdBy;
	private long processedBy;
	private long balance;
	private long intrest;
	private int count;
	private String lastupdate;
	private String status;
	// Getters and setters

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getApplicationNomineeFirstName() {
		return applicationNomineeFirstName;
	}

	public void setApplicationNomineeFirstName(String applicationNomineeFirstName) {
		this.applicationNomineeFirstName = applicationNomineeFirstName;
	}

	public String getApplicationNomineeLastName() {
		return applicationNomineeLastName;
	}

	public void setApplicationNomineeLastName(String applicationNomineeLastName) {
		this.applicationNomineeLastName = applicationNomineeLastName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCreated_date() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(long processedBy) {
		this.processedBy = processedBy;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance_amt) {
		this.balance = balance_amt;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {

		this.count = count;
	}

	public void setIntrest(long intrest) {

		this.intrest = intrest;

	}

	public long getIntrest() {
		return intrest;
	}

	public String getLastUpdate() {
		return lastupdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastupdate = lastUpdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static AccountViewModel mapToViewModel(Account account) {
		AccountViewModel viewModel = new AccountViewModel();
		viewModel.setApplicationId(account.getApplicationId());
		viewModel.setAccountTypeId(account.getAccountTypeId());
		viewModel.setApplicationNomineeFirstName(account.getApplicationNomineeFirstName());
		viewModel.setApplicationNomineeLastName(account.getApplicationNomineeLastName());
		viewModel.setCustomerId(account.getCustomer().getId());
		viewModel.setCreatedDate(account.getCreated_date());
		viewModel.setCreatedBy(account.getCreatedByUser().getBusr_id());
		viewModel.setProcessedBy(account.getProcessedByUser().getBusr_id());
		viewModel.setBalance(account.getBalance());
		viewModel.setIntrest(account.getIntrest());
		viewModel.setCount(account.getCount());
		viewModel.setLastUpdate(account.getLastUpdate());
		viewModel.setStatus(account.getAccountStatus());

		return viewModel;
	}
}
