package com.nkxgen.spring.jdbc.DaoInterfaces;

import java.util.List;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.LoanTransactions;
import com.nkxgen.spring.jdbc.model.Transaction;

public interface AccountProcessingDAO {

	public List<Account> getSavAcc(List<Account> acctype);

	public void executeProcedure(int accno);

	public List<Transaction> AccountTransactionStatementGeneration(int accno);

	public List<LoanTransactions> LoanTransactionStatementGeneration(int accno);
}
