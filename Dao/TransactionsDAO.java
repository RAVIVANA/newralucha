package com.nkxgen.spring.jdbc.Dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.Bal.CustomerSetter;
import com.nkxgen.spring.jdbc.DaoInterfaces.CustomerDaoInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.TransactionsInterface;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.EMIpay;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoanTransactions;
import com.nkxgen.spring.jdbc.model.Transaction;
import com.nkxgen.spring.jdbc.model.tempRepayment;
import com.nkxgen.spring.jdbc.model.transactioninfo;

@Repository
@Transactional
public class TransactionsDAO implements TransactionsInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CustomerSetter s;

	@Autowired
	private CustomerDaoInterface cd;
	@Autowired
	private TransactionsInterface ti;

	@Override
	public void moneyDeposit(transactioninfo trans) {
		Account account = entityManager.find(Account.class, (long) trans.getAccountNumber()); // Find the account object
																								// with the given
																								// account number using
																								// the entity manager
		long balance = (long) (account.getBalance() + (long) trans.getAmount()); // Calculate the new balance by adding
																					// the deposit amount to the current
																					// balance
		account.setBal(balance); // Update the balance of the account with the new balance
	}

	@Override
	public void moneyWithdrawl(transactioninfo trans) {
		Account account = entityManager.find(Account.class, (long) trans.getAccountNumber()); // Find the account object
																								// with the given
																								// account number using
																								// the entity manager
		if (account.getBalance() >= (long) trans.getAmount()) { // Check if the account balance is sufficient for the
																// withdrawal
			long balance = (long) (account.getBalance() - (long) trans.getAmount()); // Calculate the new balance by
																						// subtracting the withdrawal
																						// amount from the current
																						// balance
			account.setBal(balance); // Update the balance of the account with the new balance
		} else {
			System.out.println("no sufficient balance"); // Print a message indicating that there is no sufficient
															// balance for the withdrawal
		}
	}

	public Account getAccountById(int id) {
		Account account = entityManager.find(Account.class, (long) id); // Find the account object with the given ID
																		// using the entity manager
		return account; // Return the found account object
	}

	@Override
	public Transaction transactionSave(transactioninfo tarn) {
		Transaction t = s.transactionSet(tarn); // Create a new Transaction object by calling a method 'transactionSet'
		t.setTran_mode(tarn.getMode()); // from another class or service, passing a transactioninfo object
		t.setTran_type("Withdrawl"); // Set the transaction type to "Withdrawl"
		return t; // Return the created Transaction object
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		entityManager.persist(transaction); // Persist the provided Transaction object by adding it to the entity
											// manager, allowing it to be saved in the data store
	}

	@Override
	public Transaction transactionSave1(transactioninfo tarn) {
		Transaction t = s.transactionSet(tarn); // Create a new Transaction object by calling a method 'transactionSet'
												// from another class or service, passing a transactioninfo object
		t.setTran_type("deposit"); // Set the transaction type to "deposit"
		return t; // Return the created Transaction object
	}

	// =================================================================
	public LoanAccount getLoanAccountById(long id) {
		LoanAccount account = entityManager.find(LoanAccount.class, id); // Find the loan account object with the given
																			// ID using the entity manager
		return account; // Return the found loan account object
	}

	@Override
	public void loanWithdrawl(long id) {
		LoanAccount account = entityManager.find(LoanAccount.class, id); // Find the loan account object with the given
																			// ID using the entity manager
		if (account.getLoanAmount() != account.getdeductionAmt()) { // If the loan amount is not equal to the deduction
																	// amount
			account.setdeductionAmt(account.getLoanAmount()); // Set the deduction amount to the loan amount
		} else {
			System.out.println("already withdrawal over"); // Print a message indicating that the withdrawal is already
															// over
		}
	}

	@Override
	public void loanRepayment(tempRepayment trans) {
		LoanAccount account = entityManager.find(LoanAccount.class, (long) trans.getLoanid()); // Find the loan account
																								// object with the given
																								// loan ID using the
																								// entity manager
		System.out.println("the value is nothing");
		int x = (int) Math.ceil(trans.getEMI()); // Calculate the EMI value and round it up to the nearest integer
		if (trans.getAmount() == trans.getTotal()) { // If the repayment amount is equal to the total amount
			account.setdeductionAmt(account.getdeductionAmt() - x); // Update the due balance by subtracting the EMI
																	// amount
		} else if (trans.getAmount() == trans.getComplete()) { // If the repayment amount is equal to the complete
																// amount
			account.setdeductionAmt(0); // Set the due balance to 0
		} else {
			System.out.println("Inavlid data"); // Print an error message for invalid data
		}
	}

	@Override
	public Customertrail getCustomerByLoanID(Long loanId) {
		Customertrail t = cd.getCustomerById(loanId); // Retrieve the customer trail object with the given loan ID using
														// a method 'getCustomerById' from another class or service
		return t; // Return the retrieved customer trail object
	}

	@Override
	public EMIpay changeToEMI(LoanAccount account) {
		EMIpay obj = s.changeToEmiObj(account, ti); // Create a new EMIpay object by calling a method 'changeToEmiObj'
													// from
		// another class or service, passing the loan account object
		return obj; // Return the created EMIpay object
	}

	@Override
	public LoanTransactions loanTransactionRepay(tempRepayment lt) {
		LoanTransactions t = s.loantransactionSet(lt); // Create a new LoanTransactions object by calling a method
														// 'loantransactionSet' from another class or service
		t.setDate(LocalDate.now().toString()); // Set the date of the loan transaction to the current date
		t.setType("emi pay"); // Set the type of the loan transaction to "emi pay"
		return t; // Return the created LoanTransactions object
	}

	@Override
	public void saveLoanTransaction(LoanTransactions lt) {
		entityManager.persist(lt); // Persist the provided LoanTransactions object by adding it to the entity manager
	}

	@Override
	public LoanTransactions LoanTransactionwithdrawl(tempRepayment temp) {
		LoanTransactions t = s.loantransactionSet(temp); // Create a new LoanTransactions object by calling a method
		t.setDate(LocalDate.now().toString()); // 'loantransactionSet' from another class or service
		t.setType("loan withdrawl"); // Set the type of the loan transaction to "loan withdrawl"
		return t; // Return the created LoanTransactions object
	}

	@Override
	public LoanApplication getLoanAccountApplicationById(long id) {
		LoanApplication account = entityManager.find(LoanApplication.class, (long) id);
		return account; // Return the found loan account object
	}

}