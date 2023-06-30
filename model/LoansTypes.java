package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nkxgen.spring.jdbc.InputModels.LoanTypeInput;

@Entity
@Table(name = "loans2")
public class LoansTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loanId")
	private Integer loanId;

	@Column(name = "loanType")
	private String loanType;

	@Column(name = "descriptionForm")
	private String descriptionForm;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getDescriptionForm() {
		return descriptionForm;
	}

	public void setDescriptionForm(String descriptionForm) {
		this.descriptionForm = descriptionForm;
	}

	public void setInputModelValues(LoanTypeInput input) {
		this.loanType = input.getLoanType();
		this.descriptionForm = input.getDescriptionForm();
	}

}
