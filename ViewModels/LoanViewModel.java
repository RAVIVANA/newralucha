package com.nkxgen.spring.jdbc.ViewModels;

import com.nkxgen.spring.jdbc.model.LoansTypes;

public class LoanViewModel {
	private Integer loanId;
	private String loanType;
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

	public LoanViewModel mapEntityToViewModel(LoansTypes entity) {
		LoanViewModel viewModel = new LoanViewModel();
		viewModel.setLoanId(entity.getLoanId());
		viewModel.setLoanType(entity.getLoanType());
		viewModel.setDescriptionForm(entity.getDescriptionForm());
		return viewModel;
	}
}
