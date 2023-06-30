package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nkxgen.spring.jdbc.InputModels.AccountDocumentInput;

@Entity
@Table(name = "AccountsDocuments")
public class Accountdocument {
	@Id
	@Column(name = "application_id")
	private Long applicationId;

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

	// Getters and Setters

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setaadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setpan(String pan) {
		this.pan = pan;
	}

	public String getPassport() {
		return passport;
	}

	public void setpassport(String passport) {
		this.passport = passport;
	}

	public String getDriving() {
		return driving;
	}

	public void setdriving(String driving) {
		this.driving = driving;
	}

	public String getjobcard() {
		return jobcard;
	}

	public void setjobcard(String jobcard) {
		this.jobcard = jobcard;
	}

	// toString method

	@Override
	public String toString() {
		return "AccountApplication{" + "applicationId=" + applicationId + ", aadhar='" + aadhar + '\'' + ", pan='" + pan
				+ '\'' + ", passport='" + passport + '\'' + ", driving='" + driving + '\'' + ", jobcard='" + jobcard
				+ '\'' + '}';
	}

	public void setInputModelValues(AccountDocumentInput input) {
		this.applicationId = input.getApplicationId();
		this.aadhar = input.getAadhar();
		this.pan = input.getPan();
		this.passport = input.getPassport();
		this.driving = input.getDriving();
		this.jobcard = input.getjobcard();
	}
}
