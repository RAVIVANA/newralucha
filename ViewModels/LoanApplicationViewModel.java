package com.nkxgen.spring.jdbc.ViewModels;

import com.nkxgen.spring.jdbc.model.LoanApplication;

public class LoanApplicationViewModel {
	private int id;
	private long customerId;
	private String applicationDate;
	private String loanTypeId;
	private long amount;
	private long emiLimitFrom;
	private long emiLimitTo;
	private int tenureRequested;
	private String nominee;
	private long createdBy;
	private String createdDate;
	private long processedBy;
	private String processDate;
	private String processedStatus;
	private String lastUpdatedDate;
	private long lastUpdatedUser;
	private String status;
	private String remarks;
	private String attachment;

	private long intrest;

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setIntrest(long intrest) {
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

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setProcessedBy(long processedBy) {
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

	public void setLastUpdatedUser(long lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getId() {
		return id;
	}

	public long getCustId() {
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

	public long getCreatedBy() {
		return createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public long getProcessedBy() {
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

	public long getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public String getStatus() {
		return status;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getAttachment() {
		return attachment;
	}

	public void copyFromEntity(LoanApplication loanApplication) {
		setId((int) loanApplication.getId());
		setCustomerId(loanApplication.getCustId().getId());
		setApplicationDate(loanApplication.getApplicationDate());
		setLoanTypeId(loanApplication.getLoanTypeId());
		setIntrest(loanApplication.getIntrest());
		setAmount(loanApplication.getAmount());
		setEmiLimitFrom(loanApplication.getEmiLimitFrom());
		setEmiLimitTo(loanApplication.getEmiLimitTo());
		setTenureRequested(loanApplication.getTenureRequested());
		setNominee(loanApplication.getNominee());
		setCreatedBy(loanApplication.getCreatedByUser().getBusr_id());
		setCreatedDate(loanApplication.getCreatedDate());
		setProcessedBy(loanApplication.getProcessedByUser().getBusr_id());
		setProcessDate(loanApplication.getProcessDate());
		setProcessedStatus(loanApplication.getProcessedStatus());
		setLastUpdatedDate(loanApplication.getLastUpdatedDate());
		setLastUpdatedUser(loanApplication.getLastUpdatedUsers().getBusr_id());
		setStatus(loanApplication.getStatus());
		setRemarks(loanApplication.getRemarks());
		setAttachment(loanApplication.getAttachment());
	}
}
