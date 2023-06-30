package com.nkxgen.spring.jdbc.DaoInterfaces;

import java.util.List;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.AccountApplication;
import com.nkxgen.spring.jdbc.model.Accountdocument;

public interface AccountApplicationDaoInterface {
	void save(AccountApplication accountApplication);

	List<AccountApplication> getAccountsappByType(String value);

	List<Account> getAccountsByType(String acnt_acty_id);

	void saveAccount(Account account);

	void saveAccountdocument(Accountdocument accountdocument);

	List<Account> getall();

	List<Account> getAccountssByType(String acnt_acty_id);

	public Account mergeAccount(Account account);

	AccountApplication getAccountApplicationById(Long applicationId);

	void savetheAccountapp(AccountApplication accountap);

	Account getAccountById(Long num);
}