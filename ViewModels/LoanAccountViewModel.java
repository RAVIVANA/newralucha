package com.nkxgen.spring.jdbc.ViewModels;

import com.nkxgen.spring.jdbc.model.LoanAccount;

public class LoanAccountViewModel {

	private Long loanId;
	private String loanType;
	private long customerId;
	private long loanAmount;
	private long interestRate;
	private int loanDuration;
	private int intrest;

	// Constructors
	public LoanAccountViewModel() {
	}

	public LoanAccountViewModel(Long loanId, String loanType, Integer customerId, long loanAmount, long interestRate,
			Integer loanDuration) {
		this.loanId = loanId;
		this.loanType = loanType;
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanDuration = loanDuration;
	}

	// Setters
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setInterestRate(long interestRate) {
		this.interestRate = interestRate;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	// Getters
	public Long getLoanId() {
		return loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public long getInterestRate() {
		return interestRate;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setIntrest(int intrest) {
		this.intrest = intrest;
	}

	public long getIntrest() {
		return intrest;
	}

	public void setValuesFromLoanAccount(LoanAccount loanAccount) {
		this.loanId = loanAccount.getLoanId();
		this.loanType = loanAccount.getLoanType();
		this.customerId = loanAccount.getCustomerId().getId();
		this.loanAmount = loanAccount.getLoanAmount();
		this.interestRate = loanAccount.getInterestRate();
		this.loanDuration = loanAccount.getLoanDuration();
	}
}
