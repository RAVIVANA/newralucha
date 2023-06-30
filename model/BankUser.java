package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nkxgen.spring.jdbc.InputModels.BankUserInput;

@Entity
@Table(name = "BankUser")
public class BankUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long busr_id;

	private String busr_title;
	private String busr_desg;
	private String busr_email;

	private String busr_pwd = "pennant@123";

	// Getters and setters
	@OneToMany(mappedBy = "createdByUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LoanApplication> createdLoanApplications;

	@OneToMany(mappedBy = "processedByUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LoanApplication> processedLoanApplications;

	@OneToMany(mappedBy = "lastUpdatedUsers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LoanApplication> lastUpdatedLoanApplications;

	// Getters and setters...

	public List<LoanApplication> getCreatedLoanApplications() {
		return createdLoanApplications;
	}

	public void setCreatedLoanApplications(List<LoanApplication> createdLoanApplications) {
		this.createdLoanApplications = createdLoanApplications;
	}

	public List<LoanApplication> getProcessedLoanApplications() {
		return processedLoanApplications;
	}

	public void setProcessedLoanApplications(List<LoanApplication> processedLoanApplications) {
		this.processedLoanApplications = processedLoanApplications;
	}

	public List<LoanApplication> getLastUpdatedLoanApplications() {
		return lastUpdatedLoanApplications;
	}

	public void setLastUpdatedLoanApplications(List<LoanApplication> lastUpdatedLoanApplications) {
		this.lastUpdatedLoanApplications = lastUpdatedLoanApplications;
	}

	public long getBusr_id() {
		return busr_id;
	}

	public void setBusr_id(long busr_id) {
		this.busr_id = busr_id;
	}

	public String getBusr_title() {
		return busr_title;
	}

	public void setBusr_title(String busr_title) {
		this.busr_title = busr_title;
	}

	public String getBusr_desg() {
		return busr_desg;
	}

	public void setBusr_desg(String busr_desg) {
		this.busr_desg = busr_desg;
	}

	public String getBusr_email() {
		return busr_email;
	}

	public void setBusr_email(String busr_email) {
		this.busr_email = busr_email;
	}

	public String getBusr_pwd() {
		return busr_pwd;
	}

	public void setBusr_pwd(String busr_pwd) {
		this.busr_pwd = busr_pwd;
	}

	@Override
	public String toString() {
		return "BankUser [busr_id=" + busr_id + ", busr_title=" + busr_title + ", busr_desg=" + busr_desg + "]";
	}

	public void setInputModelValues(BankUserInput input) {
		this.busr_id = (long) input.getBusr_id();
		this.busr_title = input.getBusr_title();
		this.busr_desg = input.getBusr_desg();
		this.busr_email = input.getBusr_email();
	}

}
