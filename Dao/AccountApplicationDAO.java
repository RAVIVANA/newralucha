package com.nkxgen.spring.jdbc.Dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.DaoInterfaces.AccountApplicationDaoInterface;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.AccountApplication;
import com.nkxgen.spring.jdbc.model.Accountdocument;

@Repository
@Transactional
public class AccountApplicationDAO implements AccountApplicationDaoInterface {
	AccountApplicationDAO() {

	}

	@PersistenceContext
	private EntityManager entityManager;

	public void save(AccountApplication accountApplication) {
		entityManager.persist(accountApplication); // Persist the AccountApplication object to the database
	}

	/*
	 * public List<AccountApplication> getAccountsappByType(String value) {
	 * System.out.println("neeraj function loki vacahav repository lo : " + value);
	 * 
	 * // Create a JPQL query to select AccountApplication objects based on the given type value String jpql =
	 * "SELECT la FROM AccountApplication la WHERE la.acap_acty_id = :value"; TypedQuery<AccountApplication> query =
	 * entityManager.createQuery(jpql, AccountApplication.class);
	 * 
	 * // Set the value parameter in the query query.setParameter("value", value);
	 * 
	 * // Execute the query and retrieve the list of AccountApplication objects List<AccountApplication> list1 =
	 * query.getResultList();
	 * 
	 * if (!list1.isEmpty()) { // If the list is not empty, retrieve the acap_acty_id of the first object for testing
	 * AccountApplication firstAccount = list1.get(0); String acapActyId = firstAccount.getAcap_acty_id();
	 * System.out.println("acap_acty_id of first object: " + acapActyId); }
	 * 
	 * return list1; }
	 */

	public List<AccountApplication> getAccountsappByType(String value) {
		System.out.println("neeraj function loki vacahav repository lo : " + value);

		// Create a JPQL query to select AccountApplication objects based on the given type value
		String jpql = "SELECT la FROM AccountApplication la WHERE la.acap_acty_id = :value";
		TypedQuery<AccountApplication> query = entityManager.createQuery(jpql, AccountApplication.class);

		// Set the value parameter in the query
		query.setParameter("value", value);

		// Execute the query and retrieve the list of AccountApplication objects
		List<AccountApplication> list1 = query.getResultList();

		Iterator<AccountApplication> iterator = list1.iterator();

		while (iterator.hasNext()) {
			AccountApplication application = iterator.next();
			if (application.getStatus().equals("approved")) {
				iterator.remove();
			}
		}

		return list1;
	}

	public List<Account> getAccountsByType(String acnt_acty_id) {
		// Create a JPQL query to select Account objects based on the given account type ID
		String jpql = "SELECT la FROM Account la WHERE la.accountTypeId = :acnt_acty_id";
		TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);

		// Set the acnt_acty_id parameter in the query
		query.setParameter("acnt_acty_id", acnt_acty_id);

		// Execute the query and retrieve the list of Account objects
		return query.getResultList();
	}

	public List<Account> getAccountssByType(String acnt_acty_id) {
		// Create a JPQL query to select Account objects based on the given account type ID
		String jpql = "SELECT la FROM Account la WHERE la.accountTypeId = :acnt_acty_id";
		TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);

		// Set the acnt_acty_id parameter in the query
		query.setParameter("acnt_acty_id", acnt_acty_id);

		// Execute the query and retrieve the list of Account objects
		return query.getResultList();
	}

	public void saveAccount(Account account) {
		// Merge the account object with the entity manager to ensure it's in a managed state
		Account mergedAccount = entityManager.merge(account);

		// Persist the merged account object to the database
		entityManager.persist(mergedAccount);
	}

	public void saveAccountdocument(Accountdocument accountdocument) {
		// Merge the account document object with the entity manager to ensure it's in a managed state
		Accountdocument mergedAccount = entityManager.merge(accountdocument);

		// Persist the merged account document object to the database
		entityManager.persist(mergedAccount);
	}

	@Override
	public List<Account> getall() {
		// Define the JPQL query to select all accounts
		String query = "SELECT l FROM Account l";

		// Create a TypedQuery using the query string and specifying the Account class as the result type
		TypedQuery<Account> query1 = entityManager.createQuery(query, Account.class);

		// Execute the query and return the list of Account objects
		return query1.getResultList();
	}

	public Account mergeAccount(Account account) {
		return entityManager.merge(account);
	}
	// public String gettheid(String inputValue) {
	// String jpql = "SELECT e.id FROM AccountType e WHERE e.value = :inputValue";
	// TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
	// query.setParameter("inputValue", inputValue);
	// return query.getSingleResult();
	// }

	@Override
	public AccountApplication getAccountApplicationById(Long applicationId) {

		AccountApplication AccountApplication = entityManager.find(AccountApplication.class, applicationId);
		System.out.println("in the accountapplication dao: " + AccountApplication.getStatus());
		return AccountApplication;
	}

	public void savetheAccountapp(AccountApplication accountApplication) {
		entityManager.merge(accountApplication); // Persist the AccountApplication object to the database
	}

	@Override
	public Account getAccountById(Long num) {
		Account Account = entityManager.find(Account.class, num);

		return Account;
	}
}
