package com.nkxgen.spring.jdbc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountsTabledummy")
public class Accountss {
	@Id
	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "account_type_id")
	private String accountTypeId;

	@Column(name = "nominee_first_name")
	private String applicationNomineeFirstName;

	@Column(name = "nominee_last_name")
	private String applicationNomineeLastName;

	@Column(name = "Created_date")
	private Date createdDate;

	@Column(name = "balance")
	private long balance;

	@Column(name = "count")
	private int count;

	@Column(name = "lastupdate")
	private String lastUpdate;

	@Column(name = "interest")
	private long intrest;

	// Getters and setters
	public void setIntrest(long intrest) {
		if (intrest > 0) {
			this.intrest = this.intrest + intrest;
		} else {
			this.intrest = intrest;
		}
	}

	public long getIntrest() {
		return intrest;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = this.balance + balance;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (count > 0) {
			this.count = this.count + count;
		} else {
			this.count = count;
		}
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
