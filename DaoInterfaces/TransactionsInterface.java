package com.nkxgen.spring.jdbc.DaoInterfaces;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.EMIpay;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoanTransactions;
import com.nkxgen.spring.jdbc.model.Transaction;
import com.nkxgen.spring.jdbc.model.tempRepayment;
import com.nkxgen.spring.jdbc.model.transactioninfo;

public interface TransactionsInterface {

	public Account getAccountById(int id);

	public LoanAccount getLoanAccountById(long acnt_id);

	public void moneyDeposit(transactioninfo tempacc);

	public void loanRepayment(tempRepayment temprr);

	public void moneyWithdrawl(transactioninfo tempacc);

	public void loanWithdrawl(long id);

	public Transaction transactionSave(transactioninfo tarn);

	public void saveTransaction(Transaction t);

	public Transaction transactionSave1(transactioninfo tarn);

	public Customertrail getCustomerByLoanID(Long loanId);

	public EMIpay changeToEMI(LoanAccount account);

	public LoanTransactions loanTransactionRepay(tempRepayment tarn);

	public void saveLoanTransaction(LoanTransactions t);

	public LoanTransactions LoanTransactionwithdrawl(tempRepayment temp);

	public LoanApplication getLoanAccountApplicationById(long loanId);

}