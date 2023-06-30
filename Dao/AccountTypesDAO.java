package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.Bal.CustomerSetter;
import com.nkxgen.spring.jdbc.DaoInterfaces.AccountTypeInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.LoanApplicationDaoInterface;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.accountTypes;
import com.nkxgen.spring.jdbc.model.cashChest;

@Repository
@Transactional
public class AccountTypesDAO implements AccountTypeInterface {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CustomerSetter s;

	@Autowired
	LoanApplicationDaoInterface ll;

	// private long laonrepayamount = 0;

	public List<accountTypes> getAllAccounts() {
		String jpql = "SELECT l FROM accountTypes l"; // Define a JPQL query to retrieve all account types
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class); // Create a typed query
																								// with the JPQL query
																								// and the accountTypes
																								// entity class
		return query.getResultList(); // Execute the query and return the list of account types
	}

	public List<accountTypes> getAllAccountDetails() {
		String jpql = "SELECT l FROM accountTypes l"; // Define a JPQL query to retrieve all account types
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class); // Create a typed query
																								// with the JPQL query
																								// and the accountTypes
																								// entity class
		return query.getResultList(); // Execute the query and return the list of account types
	}

	public accountTypes getSelectedAccountDetails(int accountType) {
		accountTypes account = entityManager.find(accountTypes.class, accountType); // Find the account type by its ID
		System.out.println("im in the dao of account types");
		System.out.println(account.getAccountType()); // Print the account type
		return account; // Return the account type
	}

	public void saveAccountTypes(accountTypes accountTypes) {
		entityManager.persist(accountTypes); // Merge the account type entity with the persistence context
	}

	// =================================================

	@Override
	public cashChest getallamount() {
		// Retrieve the total balance from all accounts
		String query = "SELECT SUM(a.balance) FROM Account a";
		Query q = entityManager.createQuery(query);
		Long totalBalance = (Long) q.getSingleResult();
		System.out.println("the total amount is :" + totalBalance);

		// Calculate the total loan amount minus deductions
		String jpql = "SELECT SUM(t.loanAmount - t.deductionAmt) FROM LoanAccount t";
		Long result = entityManager.createQuery(jpql, Long.class).getSingleResult();
		System.out.println("the total amount of result is :" + result);

		// Calculate the total amount started
		long started = totalBalance + result;

		// Retrieve all loans
		List<LoanAccount> loan = ll.getAllLoans();

		// Calculate the total difference in loan payments
		long totalDifference = 0L;
		for (LoanAccount account : loan) {
			// Calculate the monthly payment value
			long value1 = (account.getLoanAmount() / (account.getLoanDuration() * 12));
			System.out.println("the value1 is :" + value1);

			// Calculate the number of payments made
			long value2 = (account.getdeductionAmt() / value1);
			System.out.println("the value2 is :" + value2);

			int numberofpayed = (int) ((account.getLoanDuration() * 12) - value2);
			System.out.println("the numberofpayed is :" + numberofpayed);

			// Calculate the final value of the loan
			long finalvalue = (long) ((numberofpayed)
					* (s.calinterest(account.getLoanAmount(), account.getdeductionAmt(), account.getLoanDuration(),
							account.getInterestRate(), account.getLoanType())));
			System.out.println("the finalvalue is :" + finalvalue);

			// Update the total difference
			totalDifference += finalvalue;
			System.out.println("the total amount of this loan is :" + totalDifference);
		}
		System.out.println("the final amount is :" + totalDifference);

		// Calculate the main amount by summing the total balance, result, and total difference
		Long mainamount = totalBalance + result + totalDifference;

		// Create a cashChest object with the calculated values
		cashChest c = s.setcashchest(mainamount, totalDifference, started);

		return c;
	}

	// @Override
	// public void setTheLoanRepay(tempRepayment tarn, LoanAccount Loan) {
	// laonrepayamount += (tarn.getAmount() - (long) (Loan.getLoanAmount() / Loan.getLoanDuration()));
	// }

}