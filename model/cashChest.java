package com.nkxgen.spring.jdbc.model;

import java.util.Date;

public class cashChest {

	private long totalamount;
	private long loaninterest;
	private long accountinterest;
	private Date timestamp;
	private long startedamount;
	private long difference;

	public long getstartedamount() {
		return startedamount;
	}

	public void setstartedamount(long startedamount) {
		this.startedamount = startedamount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long gettotalamount() {
		return totalamount;
	}

	public void settotalamount(Long totalamount) {
		this.totalamount = totalamount;
	}

	public Long getloaninterest() {
		return loaninterest;
	}

	public void setaccountinterest(Long accountinterest) {
		this.accountinterest = accountinterest;
	}

	public Long getaccountinterest() {
		return accountinterest;
	}

	public void setloaninterest(Long loaninterest) {
		this.loaninterest = loaninterest;
	}

	public long getDifferernce() {
		this.difference = this.getloaninterest() - this.getaccountinterest();
		return difference;
	}

	public cashChest() {
		timestamp = new Date();

	}
}
