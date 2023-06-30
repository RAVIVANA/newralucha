package com.nkxgen.spring.jdbc.InputModels;

public class AccountApplicationInput {
	private Long customerId;
	private String acapNomineeFirstName;
	private String acapNomineeLastName;
	private String acap_acty_id;
	private long createdBy;
	private String applicationDate;
	private String createdDate;
	private long processedBy;
	private String aadhar;
	private String pan;
	private String passport;
	private String driving;
	private String jobcard;
	private Long acapId;

	public Long getAcapId() {
		return acapId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getAcapNomineeFirstName() {
		return acapNomineeFirstName;
	}

	public String getAcapNomineeLastName() {
		return acapNomineeLastName;
	}

	public String getAcap_acty_id() {
		return acap_acty_id;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public long getProcessedBy() {
		return processedBy;
	}

	public String getAadhar() {
		return aadhar;
	}

	public String getPan() {
		return pan;
	}

	public String getPassport() {
		return passport;
	}

	public String getDriving() {
		return driving;
	}

	public String getJobcard() {
		return jobcard;
	}

	public void setAcapId(Long acapId) {
		this.acapId = acapId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setAcapNomineeFirstName(String acapNomineeFirstName) {
		this.acapNomineeFirstName = acapNomineeFirstName;
	}

	public void setAcapNomineeLastName(String acapNomineeLastName) {
		this.acapNomineeLastName = acapNomineeLastName;
	}

	public void setAcap_acty_id(String acap_acty_id) {
		this.acap_acty_id = acap_acty_id;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setProcessedBy(long processedBy) {
		this.processedBy = processedBy;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setDriving(String driving) {
		this.driving = driving;
	}

	public void setJobcard(String jobcard) {
		this.jobcard = jobcard;
	}
}
