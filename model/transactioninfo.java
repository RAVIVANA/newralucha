package com.nkxgen.spring.jdbc.model;

public class transactioninfo {
	private int AccountNumber;
	private int Amount;
	private String Date;
	private String Mode;

	public transactioninfo() {

	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int AccountNumber) {
		this.AccountNumber = AccountNumber;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public String getMode() {
		return Mode;
	}

	public void setMode(String Mode) {
		this.Mode = Mode;
	}
}