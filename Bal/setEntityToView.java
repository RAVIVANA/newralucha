package com.nkxgen.spring.jdbc.Bal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nkxgen.spring.jdbc.DaoInterfaces.AccountApplicationDaoInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.AccountTypeInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.BankUserInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.CustomerDaoInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.LoanApplicationDaoInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.LoanTypesInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.TransactionsInterface;
import com.nkxgen.spring.jdbc.InputModels.BankUserInput;
import com.nkxgen.spring.jdbc.ViewModels.AccountApplicationViewModel;
import com.nkxgen.spring.jdbc.ViewModels.AccountTypeView;
import com.nkxgen.spring.jdbc.ViewModels.AccountViewModel;
import com.nkxgen.spring.jdbc.ViewModels.BankUserViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanAccountViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanApplicationViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanViewModel;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.AccountApplication;
import com.nkxgen.spring.jdbc.model.BankUser;
import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoansTypes;
import com.nkxgen.spring.jdbc.model.accountTypes;

public class setEntityToView implements ViewInterface {
	@Autowired
	LoanApplicationDaoInterface ll;
	@Autowired
	LoanTypesInterface loan;
	@Autowired
	AccountApplicationDaoInterface ac;
	@Autowired
	BankUserInterface bankUserService;
	@Autowired
	private AccountTypeInterface account;
	@Autowired
	private CustomerDaoInterface cd;
	@Autowired
	TransactionsInterface ti;

	List<LoanAccountViewModel> viewlist = new ArrayList<>();
	List<LoanApplicationViewModel> viewlist1 = new ArrayList<>();
	List<AccountViewModel> viewlist2 = new ArrayList<>();
	List<AccountApplicationViewModel> viewlist4 = new ArrayList<>();
	List<LoanViewModel> viewlist5 = new ArrayList<>();
	List<BankUserViewModel> viewlist3 = new ArrayList<>();
	List<AccountTypeView> viewlist6 = new ArrayList<>();
	List<Account> viewlist7 = new ArrayList<>();
	List<Customer> viewlist8 = new ArrayList<>();

	@Override
	public List<LoanAccountViewModel> getLoanAccountsByLoanType(String typee) {
		viewlist.clear(); // Clear the viewlist to ensure it's empty

		// Get the list of LoanAccounts by loan type from the ll object
		List<LoanAccount> list = ll.getLoanAccountsByLoanType(typee);

		for (LoanAccount l : list) {
			LoanAccountViewModel la = new LoanAccountViewModel(); // Create a new LoanAccountViewModel object

			// Set the values from the LoanAccount object to the LoanAccountViewModel object
			la.setValuesFromLoanAccount(l);

			viewlist.add(la); // Add the LoanAccountViewModel object to the viewlist
		}

		return viewlist; // Return the viewlist containing LoanAccountViewModel objects
	}

	@Override
	public AccountViewModel getAccountById(int act) {
		Account a = ti.getAccountById(act); // Get the Account object by account ID from the ti object

		AccountViewModel a1 = new AccountViewModel(); // Create a new AccountViewModel object
		AccountViewModel a2 = a1.mapToViewModel(a); // Map the values from the Account object to the AccountViewModel
													// object

		return a2; // Return the AccountViewModel object
	}

	@Override
	public List<AccountViewModel> getAccoutsByType(List<Account> typee) {
		viewlist2.clear(); // Clear the existing contents of the viewlist2 list

		for (Account l : typee) {
			AccountViewModel la = new AccountViewModel(); // Create a new AccountViewModel object
			AccountViewModel la1 = la.mapToViewModel(l); // Map the values from the Account object to the
															// AccountViewModel object
			viewlist2.add(la1); // Add the AccountViewModel object to the viewlist2 list
		}

		return viewlist2; // Return the list of AccountViewModel objects
	}

	@Override
	public List<LoanApplicationViewModel> getLoanApplicationsByStatus(String typee) {
		viewlist1.clear(); // Clear the existing contents of the viewlist1 list

		List<LoanApplication> list = ll.getLoanApplicationsByStatus(typee); // Retrieve the list of LoanApplication
																			// objects by status

		for (LoanApplication l : list) {
			LoanApplicationViewModel la = new LoanApplicationViewModel(); // Create a new LoanApplicationViewModel
																			// object
			la.copyFromEntity(l); // Copy the values from the LoanApplication object to the LoanApplicationViewModel
									// object
			viewlist1.add(la); // Add the LoanApplicationViewModel object to the viewlist1 list
		}

		return viewlist1; // Return the list of LoanApplicationViewModel objects
	}

	@Override
	public List<AccountApplicationViewModel> getAccountsappByType(String typee) {
		viewlist4.clear(); // Clear the existing contents of the viewlist4 list

		List<AccountApplication> list = ac.getAccountsappByType(typee); // Retrieve the list of AccountApplication
																		// objects by type

		for (AccountApplication l : list) {
			AccountApplicationViewModel la = new AccountApplicationViewModel(); // Create a new
																				// AccountApplicationViewModel object
			la.setEntityModelValues(l); // Set the values from the AccountApplication object to the
										// AccountApplicationViewModel object
			viewlist4.add(la); // Add the AccountApplicationViewModel object to the viewlist4 list
		}

		return viewlist4; // Return the list of AccountApplicationViewModel objects
	}

	@Override
	public List<LoanApplicationViewModel> getLoanApplicationByValue(String typee) {
		viewlist1.clear(); // Clear the existing contents of the viewlist1 list

		List<LoanApplication> list = ll.getLoanApplicationByValue(typee); // Retrieve the list of LoanApplication
																			// objects by value

		for (LoanApplication l : list) {
			LoanApplicationViewModel la = new LoanApplicationViewModel(); // Create a new LoanApplicationViewModel
																			// object
			la.copyFromEntity(l); // Copy the values from the LoanApplication object to the LoanApplicationViewModel
									// object
			viewlist1.add(la); // Add the LoanApplicationViewModel object to the viewlist1 list
		}

		return viewlist1; // Return the list of LoanApplicationViewModel objects
	}

	@Override
	public List<AccountViewModel> getAccountsByType(String typee) {
		viewlist2.clear(); // Clear the existing contents of the viewlist2 list

		List<Account> list = ac.getAccountsByType(typee); // Retrieve the list of Account objects by typee

		for (Account l : list) {
			AccountViewModel la = new AccountViewModel(); // Create a new AccountViewModel object
			AccountViewModel la1 = la.mapToViewModel(l); // Map the values from the Account object to the
															// AccountViewModel object
			viewlist2.add(la1); // Add the AccountViewModel object to the viewlist2 list
		}

		return viewlist2; // Return the list of AccountViewModel objects
	}

	@Override
	public List<BankUserViewModel> getAllBankUsers() {
		viewlist3.clear(); // Clear the existing contents of the viewlist3 list

		List<BankUser> list = bankUserService.getAllBankUsers(); // Retrieve the list of BankUser objects

		for (BankUser l : list) {
			BankUserViewModel la = new BankUserViewModel(); // Create a new BankUserViewModel object
			la.setFromEntity(l); // Set the values in the BankUserViewModel object based on the BankUser entity
			viewlist3.add(la); // Add the BankUserViewModel object to the viewlist3 list
		}

		return viewlist3; // Return the list of BankUserViewModel objects
	}

	@Override
	public BankUser getBankUserById(BankUserInput status) {
		BankUser b = bankUserService.getBankUserById(status.getBusr_id()); // Retrieve the BankUser object by its
																			// busr_id

		return b; // Return the BankUser object
	}

	@Override
	public List<BankUserViewModel> getBankUsersByDesignation(BankUser status) {
		viewlist3.clear(); // Clear the viewlist3 to start with an empty list

		// Retrieve a list of BankUser objects based on the designation
		List<BankUser> list = bankUserService.getBankUsersByDesignation(status);

		for (BankUser l : list) {
			BankUserViewModel la = new BankUserViewModel();
			la.setFromEntity(l); // Set the values of BankUserViewModel based on the BankUser object
			viewlist3.add(la); // Add the BankUserViewModel object to the viewlist3
		}

		return viewlist3; // Return the list of BankUserViewModel objects
	}

	@Override
	public List<BankUserViewModel> getBankUsersByDesignation(String status) {
		viewlist3.clear(); // Clear the viewlist3 to start with an empty list

		// Retrieve a list of BankUser objects based on the designation
		List<BankUser> list = bankUserService.getBankUsersByDesignation(status);

		for (BankUser l : list) {
			BankUserViewModel la = new BankUserViewModel();
			la.setFromEntity(l); // Set the values of BankUserViewModel based on the BankUser object
			viewlist3.add(la); // Add the BankUserViewModel object to the viewlist3
		}

		return viewlist3; // Return the list of BankUserViewModel objects
	}

	@Override
	public LoanViewModel getSelectedLoanDetails(int status) {
		LoansTypes loank = loan.getSelectedLoanDetails(status); // Retrieve the selected loan details based on the
																// status

		LoanViewModel la = new LoanViewModel();
		LoanViewModel la1 = la.mapEntityToViewModel(loank); // Map the LoansTypes object to a LoanViewModel object
		return la1; // Return the LoanViewModel object
	}

	@Override
	public List<LoanViewModel> getAllLoans() {
		viewlist5.clear();
		List<LoansTypes> loank = loan.getAllLoans(); // Retrieve all loans

		for (LoansTypes l : loank) {
			LoanViewModel la = new LoanViewModel();
			LoanViewModel la1 = la.mapEntityToViewModel(l); // Map each LoansTypes object to a LoanViewModel object
			viewlist5.add(la1); // Add the LoanViewModel object to the viewlist5 list
		}

		return viewlist5; // Return the list of LoanViewModel objects
	}

	@Override
	public AccountTypeView getSelectedAccountDetails(int status) {
		accountTypes loank = account.getSelectedAccountDetails(status); // Retrieve selected account details

		AccountTypeView la = new AccountTypeView();
		AccountTypeView la1 = la.mapEntityToViewModel(loank); // Map the account details to an AccountTypeView object
		return la1; // Return the AccountTypeView object
	}

	@Override
	public List<AccountTypeView> set11() {
		viewlist6.clear(); // Clear the existing list

		List<accountTypes> loank = account.getAllAccounts(); // Retrieve all the accounts

		for (accountTypes l : loank) {
			AccountTypeView la = new AccountTypeView();
			AccountTypeView la1 = la.mapEntityToViewModel(l); // Map each account to an AccountTypeView object
			viewlist6.add(la1); // Add the mapped object to the list
		}

		return viewlist6; // Return the list of AccountTypeView objects
	}

	@Override
	public List<Account> checkdate(List<Account> l) {
		viewlist7.clear(); // Clear the existing list

		LocalDate currentDate = LocalDate.now(); // Get the current date
		LocalDate oneMonthBackDate = currentDate.minusMonths(1); // Calculate the date one month ago

		for (Account a : l) {
			LocalDate ld = LocalDate.parse(a.getLastUpdate()); // Parse the last update date of the account

			// Compare the last update date with one month ago
			if (oneMonthBackDate.equals(ld)) {
				viewlist7.add(a); // Add the account to the filtered list
			}
		}

		return viewlist7; // Return the filtered list of accounts
	}

	@Override
	public List<Account> checkdates(List<Account> l) {
		viewlist7.clear(); // Clear the existing list

		LocalDate currentDate = LocalDate.now(); // Get the current date
		LocalDate oneMonthBackDate = currentDate.minusMonths(6); // Calculate the date 6 months ago

		for (Account a : l) {
			LocalDate ld = LocalDate.parse(a.getLastUpdate()); // Parse the last update date of the account

			// Compare the last update date with 6 months ago
			if (oneMonthBackDate.compareTo(ld) > 0) {
				viewlist7.add(a); // Add the account to the filtered list
			}
		}

		return viewlist7; // Return the filtered list of accounts
	}

	@Override
	public List<Customer> getAllCustomers() {
		viewlist8.clear(); // Clear the existing list

		List<Customertrail> loank = cd.getAllCustomers(); // Retrieve all customers from the Customertrail table

		for (Customertrail l : loank) {
			Customer la = new Customer();
			Customer la1 = la.dotheservice1(l); // Convert Customertrail object to Customer object
			viewlist8.add(la1); // Add the converted Customer object to the list
		}

		return viewlist8; // Return the list of customers
	}

	@Override
	public LoanAccountViewModel getLoanAccountById(int accountnumber) {
		LoanAccount la = ti.getLoanAccountById(accountnumber); // Retrieve LoanAccount by account number

		LoanAccountViewModel la2 = new LoanAccountViewModel();
		la2.setValuesFromLoanAccount(la); // Convert LoanAccount to LoanAccountViewModel

		return la2; // Return the LoanAccountViewModel
	}

}
