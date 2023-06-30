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
import com.nkxgen.spring.jdbc.DaoInterfaces.AccountApplicationDaoInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.AccountProcessingDAO;
import com.nkxgen.spring.jdbc.ViewModels.AccountViewModel;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.LoanTransactions;
import com.nkxgen.spring.jdbc.model.Transaction;

@Controller
public class AccountProcessingController {
	@Autowired
	private AccountApplicationDaoInterface ac;
	@Autowired
	private ViewInterface v;
	@Autowired
	private Accounts ac1;
	@Autowired
	private AccountProcessingDAO interestCalDao;

	@RequestMapping(value = "/intrest", method = RequestMethod.GET)
	public String calculateInterest(Model model) {
		// Retrieve all accounts from the database
		List<Account> list = ac.getall();

		// Calculate interest for each account
		List<Account> list1 = ac1.calcIntrst(list);

		// Merge the updated accounts back into the database
		for (Account aa : list1) {
			ac.mergeAccount(aa);
		}

		// Retrieve all accounts from the database again
		List<Account> list3 = ac.getall();

		// Add the list of accounts as an attribute to the model
		model.addAttribute("accounts", list3);

		// Return the view name "New2" to render the corresponding page
		return "account-interest";
	}

	@RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
	public String getAccountTypes(Model model) {
		return "account-types";
	}

	@RequestMapping(value = "/get-accounts", method = RequestMethod.GET)
	public String getAccounts(@RequestParam("accountType") String accountType, Model model) {
		// Retrieve accounts from the database based on the specified accountType
		List<Account> l = ac.getAccountssByType(accountType);

		// Perform date checking on the retrieved accounts
		List<Account> l1 = v.checkdate(l);

		// Add the updated account list as an attribute to the model
		model.addAttribute("accounts", l1);

		// Return the view name "New2" to render the corresponding page
		return "account-interest";
	}

	@RequestMapping(value = "/getSavings", method = RequestMethod.GET)
	public String getSavingsAccounts(@RequestParam("accountType") String accountType, Model model) {
		// Retrieve accounts from the database based on the specified accountType
		List<Account> l = ac.getAccountssByType(accountType);

		// Perform date checking on the retrieved accounts
		List<Account> l1 = v.checkdates(l);

		// Retrieve account view models from the database based on the specified accountType
		List<AccountViewModel> l2 = v.getAccountsByType(accountType);

		// Add the account view models as an attribute to the model
		model.addAttribute("accounts", l2);

		// Return the view name "New2" to render the corresponding page
		return "account-interest";
	}

	@RequestMapping(value = "/calculateInterest", method = RequestMethod.GET)
	public String getAccountsBasedOnDueDates(@RequestParam("accountType") String accountType, Model model) {
		// Check if the accountType is "savings"
		if (accountType.equals("savings")) {
			// Retrieve accounts from the database based on the specified accountType
			List<Account> l = ac.getAccountssByType(accountType);

			// Perform date checking on the retrieved accounts
			List<Account> l1 = v.checkdates(l);

			// Get savings accounts from the updated account list
			List<Account> l2 = interestCalDao.getSavAcc(l1);

			// Retrieve account view models from the database based on the specified accountType
			List<AccountViewModel> l3 = v.getAccountsByType(accountType);

			// Add the account view models as an attribute to the model
			model.addAttribute("accounts", l3);
		} else {
			// Retrieve accounts from the database based on the specified accountType
			List<Account> l = ac.getAccountssByType(accountType);

			// Perform date checking on the retrieved accounts
			List<Account> l1 = v.checkdate(l);

			// Calculate interest for the accounts
			List<Account> list1 = ac1.calcIntrst(l1);

			// Merge the updated accounts to the database
			for (Account aa : list1) {
				ac.mergeAccount(aa);
			}

			// Retrieve all accounts from the database
			List<Account> list3 = ac.getall();

			// Add the accounts as an attribute to the model
			model.addAttribute("accounts", list3);
		}

		// Return the view name "New2" to render the corresponding page
		return "account-interest";
	}

	@RequestMapping(value = "/statementPage", method = RequestMethod.POST)
	public String spage() {
		return "statement-page";
	}

	@RequestMapping(value = "/statement", method = RequestMethod.GET)
	public String statementGeneration(@RequestParam("accountId") int accountId, @RequestParam("type") String type,
			Model model) {
		// Generate a statement for the specific account
		// Implementation logic goes here

		// Create the statement message
		String statement = "Statement for Account " + accountId;
		System.out.println(statement);

		// Generate the statement contents
		// ...

		// Check the type of statement requested
		if (type.equals("accounts")) {
			// Retrieve account transactions for the specified accountId
			List<Transaction> st = interestCalDao.AccountTransactionStatementGeneration(accountId);
			System.out.println(st);

			// Add the account transactions as an attribute to the model
			model.addAttribute("statementlist", st);

			// Return the view name "stlist" to render the account statement
			return "accounts-transactions-list";
		} else {
			// Retrieve loan transactions for the specified accountId
			List<LoanTransactions> st = interestCalDao.LoanTransactionStatementGeneration(accountId);
			System.out.println(st);

			// Add the loan transactions as an attribute to the model
			model.addAttribute("loanTransactions", st);

			// Return the view name "Stmt2" to render the loan statement
			return "loan-transactions-list";
		}
	}

}