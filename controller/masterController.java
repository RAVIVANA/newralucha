package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.Bal.Accounts;
import com.nkxgen.spring.jdbc.Bal.ViewInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.AccountTypeInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.LoanTypesInterface;
import com.nkxgen.spring.jdbc.InputModels.AccountTypeInput;
import com.nkxgen.spring.jdbc.InputModels.LoanTypeInput;
import com.nkxgen.spring.jdbc.ViewModels.AccountTypeView;
import com.nkxgen.spring.jdbc.ViewModels.LoanViewModel;
import com.nkxgen.spring.jdbc.model.LoansTypes;
import com.nkxgen.spring.jdbc.model.accountTypes;
import com.nkxgen.spring.jdbc.model.cashChest;

@Controller
public class masterController {

	@Autowired
	private AccountTypeInterface account;
	@Autowired
	ViewInterface v;
	@Autowired
	private Accounts ac1;
	@Autowired
	private LoanTypesInterface loan;

	@RequestMapping(value = "/accountDataSave", method = RequestMethod.POST)
	public String accountApplicationSave(AccountTypeInput accountTypes, Model model) {
		// Create a new instance of accountTypes
		accountTypes at = new accountTypes();

		// Set the input model values of the accountTypes using the accountTypesInput object
		at.setInputModelValues(accountTypes);

		// Save the accountTypes to the database using the account.saveAccountTypes() method
		account.saveAccountTypes(at);

		return "account-master-entry"; // Return the view name "account_master_entry" to render the page
	}

	@RequestMapping(value = "/getAccountTypes", method = RequestMethod.GET)
	public String getAccounts(Model model) {
		// Get the list of AccountTypeView objects
		List<AccountTypeView> list = v.set11();

		for (AccountTypeView ll : list) {
			System.out.println(ll.getAccountType());
		}

		// Add the list of AccountTypeView objects to the model attribute "accountTypes"
		model.addAttribute("accountTypes", list);

		return "get-accounts"; // Return the view name "getaccounts" to render the page
	}

	@RequestMapping(value = "/getSelectedAccountDetails", method = RequestMethod.GET)
	public String getSelectedAccountDetails(@RequestParam("accountType") int accountType, Model model) {
		// Get the selected account details based on the account type
		AccountTypeView accountT = v.getSelectedAccountDetails(accountType);

		// Print the account type and description form
		System.out.println("the iid value is :" + accountT.getAccountType());
		System.out.println("the iid value is :" + accountT.getDescriptionForm());

		// Add the accountT object to the model attribute "accounts"
		model.addAttribute("accounts", accountT);

		return "account-details"; // Return the view name "accountdetails" to render the page
	}

	@RequestMapping(value = "/loanDataSave", method = RequestMethod.POST)
	public String loanInfoSaveToDb(LoanTypeInput loans, Model model) {
		// Create a new instance of LoansTypes
		LoansTypes lt = new LoansTypes();

		// Set the input model values of the LoansTypes using the LoanTypeInput object
		lt.setInputModelValues(loans);

		System.out.println("hello"); // Print "hello"

		// Save the LoansTypes to the database using the loan.save() method
		loan.save(lt);

		return "loan-master-entry"; // Return the view name "loan_master_entry" to render the page
	}

	@RequestMapping(value = "/getLoanTypes", method = RequestMethod.GET)
	public String getLoans(Model model) {
		// Get all loan types
		List<LoanViewModel> list = v.getAllLoans();

		// Print the loan type for each loan in the list
		for (LoanViewModel ll : list) {
			System.out.println(ll.getLoanType());
		}

		// Add the list of loans to the model attribute "loans"
		model.addAttribute("loans", list);

		return "get-loans"; // Return the view name "getloans" to render the page
	}

	@RequestMapping(value = "/getSelectedLoanDetails", method = RequestMethod.GET)
	public String getSelectedLoanDetails(@RequestParam("loanType") int loanType, Model model) {
		// Print the value of loanType
		System.out.println("the value is" + loanType);

		// Get the selected loan details based on the loanType
		LoanViewModel loank = v.getSelectedLoanDetails(loanType);

		// Print the loan ID
		System.out.println("the iid value is :" + loank.getLoanId());

		// Add the loank object to the model attribute "loans"
		model.addAttribute("loans", loank);

		return "loan-details"; // Return the view name "loandetails" to render the page
	}

	// =================================================================================================================

	@RequestMapping("/masterLoan")
	public String LoanMasterEntry(Model model) {
		return "loan_master_entry";
	}

	@RequestMapping(value = "/cashChest", method = RequestMethod.GET)
	public String money(Model model) {
		// Retrieve the cash chest information
		cashChest cashchest = account.getallamount();

		// Set the cash chest in the ac1 object
		ac1.setcashChest(cashchest);

		// Add the cash chest object to the model attribute "cashChest"
		model.addAttribute("cashChest", cashchest);

		return "cash-chest"; // Return the view name "cashchest" to render the page
	}

	@RequestMapping(value = "profitLoss", method = RequestMethod.GET)
	public String Profitloss(Model model) {
		// Retrieve the cash chest information
		cashChest cashchest = account.getallamount();

		// Set the cash chest in the ac1 object
		ac1.setcashChest(cashchest);

		// Add the cash chest object to the model attribute "cashChest"
		model.addAttribute("cashChest", cashchest);

		return "p&l";
	}

}