package com.nkxgen.spring.jdbc.Bal;

import java.util.List;

import com.nkxgen.spring.jdbc.InputModels.BankUserInput;
import com.nkxgen.spring.jdbc.ViewModels.AccountApplicationViewModel;
import com.nkxgen.spring.jdbc.ViewModels.AccountTypeView;
import com.nkxgen.spring.jdbc.ViewModels.AccountViewModel;
import com.nkxgen.spring.jdbc.ViewModels.BankUserViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanAccountViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanApplicationViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanViewModel;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.BankUser;
import com.nkxgen.spring.jdbc.model.Customer;

public interface ViewInterface {
	List<LoanAccountViewModel> getLoanAccountsByLoanType(String typee);

	AccountViewModel getAccountById(int act);

	List<AccountViewModel> getAccoutsByType(List<Account> typee);

	List<LoanApplicationViewModel> getLoanApplicationsByStatus(String typee);

	List<AccountApplicationViewModel> getAccountsappByType(String typee);

	List<LoanApplicationViewModel> getLoanApplicationByValue(String typee);

	List<AccountViewModel> getAccountsByType(String typee);

	List<BankUserViewModel> getAllBankUsers();

	BankUser getBankUserById(BankUserInput status);

	List<BankUserViewModel> getBankUsersByDesignation(BankUser status);

	List<BankUserViewModel> getBankUsersByDesignation(String status);

	LoanViewModel getSelectedLoanDetails(int status);

	List<LoanViewModel> getAllLoans();

	AccountTypeView getSelectedAccountDetails(int status);

	List<AccountTypeView> set11();

	List<Account> checkdate(List<Account> l);

	List<Account> checkdates(List<Account> l);

	List<Customer> getAllCustomers();

	LoanAccountViewModel getLoanAccountById(int accountnumber);
}
