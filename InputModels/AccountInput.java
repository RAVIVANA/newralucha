package com.nkxgen.spring.jdbc.InputModels;

public class AccountInput {
	private Long applicationId;
	private String accountTypeId;
	private String applicationNomineeFirstName;
	private String applicationNomineeLastName;
	private Long customerId;
	private String CreatedDate;
	private long CreatedBy;
	private long processedBy;

	public Long getApplicationId() {
		return applicationId;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public String getApplicationNomineeFirstName() {
		return applicationNomineeFirstName;
	}

	public String getApplicationNomineeLastName() {
		return applicationNomineeLastName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getCreated_date() {
		return CreatedDate;
	}

	public long getCreatedBy() {
		return CreatedBy;
	}

	private long balance;

	public long getProcessedBy() {
		return processedBy;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public void setApplicationNomineeFirstName(String applicationNomineeFirstName) {
		this.applicationNomineeFirstName = applicationNomineeFirstName;
	}

	public void setApplicationNomineeLastName(String applicationNomineeLastName) {
		this.applicationNomineeLastName = applicationNomineeLastName;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	public void setCreatedBy(long CreatedBy) {
		this.CreatedBy = CreatedBy;
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
}
