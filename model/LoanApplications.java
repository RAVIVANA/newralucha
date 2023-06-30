package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nkxgen.spring.jdbc.InputModels.LoanApplicationInput;

@Entity
@Table(name = "LoanApplicationss")
public class LoanApplications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lnap_id")
	private Integer id;

	@Column(name = "lnap_cust_id")
	private int custId;

	@Column(name = "lnap_apdate")
	private String applicationDate;

	@Column(name = "lnap_lnty_id")
	private String loanTypeId;

	@Column(name = "lnap_amount")
	private Long amount;

	@Column(name = "l_intrest")
	private long intrest;

	@Column(name = "lnap_emilimitfrom")
	private Long emiLimitFrom;

	@Column(name = "lnap_emilimitto")
	private Long emiLimitTo;

	@Column(name = "lnap_tenure_requested")
	private Integer tenureRequested;

	@Column(name = "lnap_nominee")
	private String nominee;

	@Column(name = "lnap_createdby")
	private int createdBy;

	@Column(name = "lnap_createddate")
	private String createdDate;

	@Column(name = "lnap_processedby")
	private Integer processedBy;

	@Column(name = "lnap_processdate")
	private String processDate;

	@Column(name = "lnap_processedstatus")
	private String processedStatus;

	@Column(name = "lnap_luudate")
	private String lastUpdatedDate;

	@Column(name = "lnap_luuser")
	private Integer lastUpdatedUser;

	@Column(name = "lnap_status")
	private String status;

	@Column(name = "lnap_remarks")
	private String remarks;

	@Column(name = "doc")
	private String attachment;

	// Setters and getters

	// ...

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public void setIntrest(int intrest) {
		this.intrest = intrest;
	}

	public long getIntrest() {
		return intrest;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getEmiLimitFrom() {
		return emiLimitFrom;
	}

	public void setEmiLimitFrom(Long emiLimitFrom) {
		this.emiLimitFrom = emiLimitFrom;
	}

	public Long getEmiLimitTo() {
		return emiLimitTo;
	}

	public void setEmiLimitTo(Long emiLimitTo) {
		this.emiLimitTo = emiLimitTo;
	}

	public Integer getTenureRequested() {
		return tenureRequested;
	}

	public void setTenureRequested(Integer tenureRequested) {
		this.tenureRequested = tenureRequested;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(Integer processedBy) {
		this.processedBy = processedBy;
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

	public Integer getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(Integer lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
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

	public void LoanApplication(LoanApplicationInput input) {
		this.custId = input.getCustId();
		this.applicationDate = input.getApplicationDate();
		this.loanTypeId = input.getLoanTypeId();
		this.amount = input.getAmount();
		this.intrest = input.getIntrest();
		this.emiLimitFrom = input.getEmiLimitFrom();
		this.emiLimitTo = input.getEmiLimitTo();
		this.tenureRequested = input.getTenureRequested();
		this.nominee = input.getNominee();
		this.createdBy = input.getCreatedBy();
		this.createdDate = input.getCreatedDate();
		this.processedBy = input.getProcessedBy();
		this.processDate = input.getProcessDate();
		this.processedStatus = input.getProcessedStatus();
		this.lastUpdatedDate = input.getLastUpdatedDate();
		this.lastUpdatedUser = input.getLastUpdatedUser();
		this.status = input.getStatus();
		this.remarks = input.getRemarks();
		this.attachment = input.getAttachment();
	}
}
