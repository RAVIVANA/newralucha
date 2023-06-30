package com.nkxgen.spring.jdbc.model;

public class EMIpay {
	private long loanid;
	private String accountHolder;
	private String loanType;
	private long loanamount;
	private int loanduration;
	private int NOI;
	private double interestRate;
	private int loan_pending;
	private int paidMonths;
	private double emi;
	private double interest;
	private int total;
	private int pastdue;
	private int totalwithpenalty;
	private int complete;

	public EMIpay() {

	}

	public long getLoanId() {
		return loanid;
	}

	public void setLoanId(long loanid) {
		this.loanid = loanid;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public int getLoanduration() {
		return loanduration;
	}

	public void setLoanduration(int loanduration) {
		this.loanduration = loanduration;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public long getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(long loanamount) {
		this.loanamount = loanamount;
	}

	public int getNOI() {
		return NOI;
	}

	public void setNOI(int NOI) {
		this.NOI = NOI;
	}

	public int getLoan_pending() {
		return loan_pending;
	}

	public void setLoan_pending(int loan_pending) {
		this.loan_pending = loan_pending;
	}

	public int getPaidMonths() {
		return paidMonths;
	}

	public void setPaidMonths(int paidMonths) {
		this.paidMonths = paidMonths;
	}

	public double getEMI() {
		return emi;
	}

	public void setEMI(double emi) {
		this.emi = emi;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getPastDue() {
		return pastdue;
	}

	public void setPastDue(int pastdue) {
		this.pastdue = pastdue;
	}

	public int getTotalWithPenalty() {
		return totalwithpenalty;
	}

	public void setTotalWithPenalty(int totalwithpenalty) {
		this.totalwithpenalty = totalwithpenalty;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}
}