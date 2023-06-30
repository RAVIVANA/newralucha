package com.nkxgen.spring.jdbc.DaoInterfaces;

import java.util.List;

import com.nkxgen.spring.jdbc.model.LoansTypes;

public interface LoanTypesInterface {
	List<LoansTypes> getAllLoans();

	List<LoansTypes> getAllLoanDetails();

	LoansTypes getSelectedLoanDetails(int loanType);

	void save(LoansTypes loanType);
}
