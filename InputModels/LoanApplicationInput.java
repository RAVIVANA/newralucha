package com.nkxgen.spring.jdbc.InputModels;

public class LoanApplicationInput {
	private int id;
	private int customerId;
	private String applicationDate;
	private String loanTypeId;
	private long amount;
	private long intrest;
	private long emiLimitFrom;
	private long emiLimitTo;
	private int tenureRequested;
	private String nominee;
	private int createdBy;
	private String createdDate;
	private int processedBy;
	private String processDate;
	private String processedStatus;
	private String lastUpdatedDate;
	private int lastUpdatedUser;
	private String status;
	private String remarks;
	private String Attachment;

	// Setters
	public void setID(int id) {
		this.id = id;
	}

	public void setCustId(int custId) {
		this.customerId = custId;
	}

	public void setIntrest(int intrest) {
		this.intrest = intrest;
	}

	public long getIntrest() {
		return intrest;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public void setLoanTypeId(String loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setEmiLimitFrom(long emiLimitFrom) {
		this.emiLimitFrom = emiLimitFrom;
	}

	public void setEmiLimitTo(long emiLimitTo) {
		this.emiLimitTo = emiLimitTo;
	}

	public void setTenureRequested(int tenureRequested) {
		this.tenureRequested = tenureRequested;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setProcessedBy(int processedBy) {
		this.processedBy = processedBy;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	public void setProcessedStatus(String processedStatus) {
		this.processedStatus = processedStatus;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public void setLastUpdatedUser(int lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setAttachment(String Attachment) {
		this.Attachment = Attachment;
	}

	// Getters
	public int getId() {
		return id;
	}

	public int getCustId() {
		return customerId;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public String getLoanTypeId() {
		return loanTypeId;
	}

	public long getAmount() {
		return amount;
	}

	public long getEmiLimitFrom() {
		return emiLimitFrom;
	}

	public long getEmiLimitTo() {
		return emiLimitTo;
	}

	public int getTenureRequested() {
		return tenureRequested;
	}

	public String getNominee() {
		return nominee;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public int getProcessedBy() {
		return processedBy;
	}

	public String getProcessDate() {
		return processDate;
	}

	public String getProcessedStatus() {
		return processedStatus;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public int getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public String getStatus() {
		return status;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getAttachment() {
		return Attachment;
	}

}
