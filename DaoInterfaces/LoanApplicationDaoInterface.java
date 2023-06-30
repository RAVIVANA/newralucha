package com.nkxgen.spring.jdbc.DaoInterfaces;

import java.util.List;

import com.nkxgen.spring.jdbc.InputModels.LoanApplicationInput;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;

public interface LoanApplicationDaoInterface {
	void saveLoanApplication(LoanApplication loanApplication);

	void updateLoanApplication(LoanApplicationInput loanApplication);

	List<LoanApplication> getLoanApplicationByValue(String value);

	List<LoanApplication> getLoanApplicationsByStatus(String status);

	List<LoanAccount> getLoanAccountsByLoanType(String loanType);

	void deleteApplication(int id);

	List<LoanAccount> getAllLoans();

	void approveApplication(int loanId, long custId);

	LoanApplication getLoanApplicationByid(long accountType);

	void saveTheApprovedLoanApplication(LoanApplication loanapp);

}
