package com.nkxgen.spring.jdbc.InputModels;

public class AccountDocumentInput {
	private Long applicationId;
	private String aadhar;
	private String pan;
	private String passport;
	private String driving;
	private String jobcard;

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
}