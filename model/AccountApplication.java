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

import com.nkxgen.spring.jdbc.InputModels.AccountApplicationInput;

@Entity
@Table(name = "accountApplicationsTable")
public class AccountApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acap_id")
	private Long acapId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acap_cust_id", referencedColumnName = "cust_id")
	private Customertrail customer;

	@Column(name = "acap_nominee_fn")
	private String acapNomineeFirstName;

	@Column(name = "acap_nominee_ln")
	private String acapNomineeLastName;

	@Column(name = "acap_status")
	private String acapStatus = "approve";

	@Column(name = "acap_acty_id")
	private String acap_acty_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acap_createdby", referencedColumnName = "busr_id")
	private BankUser createdByUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acap_processedby", referencedColumnName = "busr_id")
	private BankUser processedByUser;

	@Column(name = "acap_apdate")
	private String applicationDate;

	@Column(name = "acap_createddate")
	private String createdDate;

	@Column(name = "aadhar")
	private String aadhar;

	@Column(name = "pan")
	private String pan;

	@Column(name = "passport")
	private String passport;

	@Column(name = "driving")
	private String driving;

	@Column(name = "jobcard")
	private String jobcard;

	public Long getAcapId() {
		return acapId;
	}

	public Customertrail getCustomer() {
		return customer;
	}

	public void setCustomer(Customertrail customer) {
		this.customer = customer;
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

	public String getApplicationDate() {
		return applicationDate;
	}

	public String getCreatedDate() {
		return createdDate;
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

	public String getStatus() {
		return acapStatus;
	}

	public void setAcapId(Long acapId) {
		this.acapId = acapId;
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

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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

	public void setStatus(String apStatus) {
		this.acapStatus = apStatus;
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

	public void setInputModelValues(AccountApplicationInput input) {
		Customertrail c = new Customertrail();
		c.setId(input.getCustomerId());
		this.customer = c;
		this.acapNomineeFirstName = input.getAcapNomineeFirstName();
		this.acapNomineeLastName = input.getAcapNomineeLastName();
		this.acap_acty_id = input.getAcap_acty_id();
		BankUser b = new BankUser();
		b.setBusr_id(input.getCreatedBy());
		b.setBusr_id(input.getProcessedBy());
		this.createdByUser = b;
		this.applicationDate = input.getApplicationDate();
		this.createdDate = input.getCreatedDate();
		this.processedByUser = b;
		this.aadhar = input.getAadhar();
		this.pan = input.getPan();
		this.passport = input.getPassport();
		this.driving = input.getDriving();
		this.jobcard = input.getJobcard();
	}
}