package com.nkxgen.spring.jdbc.model;

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
@Table(name = "loanaccounts")
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "loanapp_id")
	private Long loanappId;

	@Column(name = "loan_type")
	private String loanType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "cust_id")
	private Customertrail customer;

	@Column(name = "loan_amount")
	private long loanAmount;

	@Column(name = "interest_rate")
	private long interestRate;

	@Column(name = "loan_duration")
	private int loanDuration;

	@Column(name = "deduction_amt")
	private long deductionAmt;

	// Setters
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public void setloanappId(Long loanappId) {
		this.loanappId = loanappId;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setCustomerId(Customertrail customerId) {
		this.customer = customerId;
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

	public void setdeductionAmt(long l) {
		this.deductionAmt = l;
	}

	// Getters
	public Long getLoanId() {
		return loanId;
	}

	public Long getloanappId() {
		return loanappId;
	}

	public String getLoanType() {
		return loanType;
	}

	public Customertrail getCustomerId() {
		return customer;
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

	public int getdeductionAmt() {
		return (int) deductionAmt;
	}

	public void setValuesFromLoanAccount(LoanApplication loanAccount) {
		Customertrail c = new Customertrail();
		c.setId(loanAccount.getCustId().getId());

		this.loanType = loanAccount.getLoanTypeId();
		this.loanappId = (long) loanAccount.getId();
		this.customer = c;
		this.loanAmount = loanAccount.getAmount();
		this.interestRate = loanAccount.getIntrest();
		this.loanDuration = loanAccount.getTenureRequested();
		this.deductionAmt = 0;
	}
}