package com.nkxgen.spring.jdbc.DaoInterfaces;

import com.nkxgen.spring.jdbc.ViewModels.CustomerViewModel;
import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerSub;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.EMIpay;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanTransactions;
import com.nkxgen.spring.jdbc.model.Transaction;
import com.nkxgen.spring.jdbc.model.cashChest;
import com.nkxgen.spring.jdbc.model.tempRepayment;
import com.nkxgen.spring.jdbc.model.transactioninfo;

public interface CustomerSetterInterface {

	Customer dotheservice(Customertrail customertrail);

	Customertrail dotheservice1(Customertrail customertrail);

	Customertrail dotheservice2(CustomerViewModel customertrail);

	Customertrail changing(Customertrail customer2, CustomerSub customerSub);

	Transaction transactionSet(transactioninfo tarn);

	EMIpay changeToEmiObj(LoanAccount account);

	int calPM(double damount, double lamount, int duration);

	double calEMI(double lamount, int duration, double damount);

	double calinterest(double lamount, double damount, int duration, double ir, String typee);

	int total(double lamount, int duration, double ir, double damount, String typee);

	int complete(int duration, double damount, double lamount, double ir, String typee, int noi);

	cashChest setcashchest(Long totalBalance, long value, long started);

	LoanTransactions loantransactionSet(tempRepayment lt);

	tempRepayment setthistarn(transactioninfo tarn);
}
