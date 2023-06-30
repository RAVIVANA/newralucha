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

import com.nkxgen.spring.jdbc.InputModels.LoanApplicationInput;

@Entity
@Table(name = "LoanApplication")
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lnap_id")
	private long id;

	@Column(name = "lnap_apdate")
	private String applicationDate;

	@Column(name = "lnap_lnty_id")
	private String loanTypeId;

	@Column(name = "lnap_amount")
	private long amount;

	@Column(name = "l_intrest")
	private long intrest;

	@Column(name = "lnap_emilimitfrom")
	private long emiLimitFrom;

	@Column(name = "lnap_emilimitto")
	private long emiLimitTo;

	@Column(name = "lnap_tenure_requested")
	private int tenureRequested;

	@Column(name = "lnap_nominee")
	private String nominee;

	@Column(name = "lnap_createddate")
	private String createdDate;

	@Column(name = "lnap_processdate")
	private String processDate;

	@Column(name = "lnap_processedstatus")
	private String processedStatus;

	@Column(name = "lnap_luudate")
	private String lastUpdatedDate;

	@Column(name = "lnap_status")
	private String status;

	@Column(name = "lnap_remarks")
	private String remarks;

	@Column(name = "doc")
	private String attachment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lnap_cust_id", referencedColumnName = "cust_id")
	private Customertrail customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lnap_createdby", referencedColumnName = "busr_id")
	private BankUser createdByUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lnap_processedby", referencedColumnName = "busr_id")
	private BankUser processedByUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lnap_luuser", referencedColumnName = "busr_id")
	private BankUser lastUpdatedUsers;

	// Setters and Getters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customertrail getCustId() {
		return customer;
	}

	public void setCustomerId(Customertrail customerId) {
		this.customer = customerId;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(String loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getIntrest() {
		return intrest;
	}

	public void setIntrest(long intrest) {
		this.intrest = intrest;
	}

	public long getEmiLimitFrom() {
		return emiLimitFrom;
	}

	public void setEmiLimitFrom(long emiLimitFrom) {
		this.emiLimitFrom = emiLimitFrom;
	}

	public long getEmiLimitTo() {
		return emiLimitTo;
	}

	public void setEmiLimitTo(long emiLimitTo) {
		this.emiLimitTo = emiLimitTo;
	}

	public int getTenureRequested() {
		return tenureRequested;
	}

	public void setTenureRequested(int tenureRequested) {
		this.tenureRequested = tenureRequested;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getProcessDate() {
		return processDate;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	public String getProcessedStatus() {
		return processedStatus;
	}

	public void setProcessedStatus(String processedStatus) {
		this.processedStatus = processedStatus;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Customertrail getCustomer() {
		return customer;
	}

	public void setCustomer(Customertrail customer) {
		this.customer = customer;
	}

	public BankUser getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(BankUser createdByUser) {
		this.createdByUser = createdByUser;
	}

	public BankUser getProcessedByUser() {
		return processedByUser;
	}

	public void setProcessedByUser(BankUser processedByUser) {
		this.processedByUser = processedByUser;
	}

	public BankUser getLastUpdatedUsers() {
		return lastUpdatedUsers;
	}

	public void setLastUpdatedUsers(BankUser lastUpdatedUsers) {
		this.lastUpdatedUsers = lastUpdatedUsers;
	}

	public void LoanApplication(LoanApplicationInput input) {
		Customertrail c = new Customertrail();
		c.setId((long) input.getCustId());
		this.customer = c;
		this.applicationDate = input.getApplicationDate();
		this.loanTypeId = input.getLoanTypeId();
		this.amount = input.getAmount();
		this.intrest = input.getIntrest();
		this.emiLimitFrom = input.getEmiLimitFrom();
		this.emiLimitTo = input.getEmiLimitTo();
		this.tenureRequested = input.getTenureRequested();
		this.nominee = input.getNominee();
		BankUser b = new BankUser();
		b.setBusr_id(input.getCreatedBy());
		b.setBusr_id(input.getProcessedBy());
		b.setBusr_id(input.getLastUpdatedUser());

		this.createdByUser = b;
		this.createdDate = input.getCreatedDate();
		this.processedByUser = b;
		this.processDate = input.getProcessDate();
		this.processedStatus = input.getProcessedStatus();
		this.lastUpdatedDate = input.getLastUpdatedDate();
		this.lastUpdatedUsers = b;
		this.status = input.getStatus();
		this.remarks = input.getRemarks();
		this.attachment = input.getAttachment();
	}
}
