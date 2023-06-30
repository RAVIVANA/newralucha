package com.nkxgen.spring.jdbc.Bal;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;

import com.nkxgen.spring.jdbc.DaoInterfaces.TransactionsInterface;
import com.nkxgen.spring.jdbc.ViewModels.CustomerViewModel;
import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerSub;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.EMIpay;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoanTransactions;
import com.nkxgen.spring.jdbc.model.Transaction;
import com.nkxgen.spring.jdbc.model.cashChest;
import com.nkxgen.spring.jdbc.model.tempRepayment;
import com.nkxgen.spring.jdbc.model.transactioninfo;

public class CustomerSetter {
	static int value = 0;
	@Autowired
	private static TransactionsInterface ti;

	public static Customer dotheservice(Customertrail customertrail) {
		Customer customer = new Customer();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile1(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public static Customertrail dotheservice1(Customertrail customertrail) {
		Customertrail customer = new Customertrail();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile1(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public static Customertrail dotheservice2(CustomerViewModel customertrail) {
		Customertrail customer = new Customertrail();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile1(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public Customertrail changing(Customertrail customer2, CustomerSub customerSub) {
		customer2.setcustTitle(customerSub.getTitle());
		customer2.setcust_mobile1(customerSub.getPhoneNo());
		customer2.setcust_raddress(customerSub.getAddress());
		return customer2;
	}

	public Transaction transactionSet(transactioninfo tarn) {
		Transaction t = new Transaction();

		t.setTran_anct_id(tarn.getAccountNumber());
		t.setTran_date(tarn.getDate());
		// t.setTran_type();
		t.setTran_mode("cash");
		t.setTran_amount(tarn.getAmount());
		t.setTran_processedby(1);
		return t;
	}

	// =============================================================================
	public EMIpay changeToEmiObj(LoanAccount account, TransactionsInterface ti) {
		this.ti = ti;
		EMIpay obj1 = new EMIpay();
		obj1.setLoanId(account.getLoanId());
		// obj.setAccountHolder(account.);
		obj1.setLoanType(account.getLoanType());
		obj1.setLoanamount(account.getLoanAmount());
		obj1.setLoanduration(account.getLoanDuration());
		obj1.setNOI(account.getLoanDuration() * 12);
		obj1.setInterestRate(account.getInterestRate());
		obj1.setLoan_pending(account.getdeductionAmt());

		obj1.setPaidMonths(
				CustomerSetter.calPM(account.getdeductionAmt(), account.getLoanAmount(), account.getLoanDuration()));

		obj1.setEMI(
				CustomerSetter.calEMI(account.getLoanAmount(), account.getLoanDuration(), account.getdeductionAmt()));
		obj1.setInterest(CustomerSetter.calinterest(account.getLoanAmount(), account.getdeductionAmt(),
				account.getLoanDuration(), account.getInterestRate(), account.getLoanType()));
		obj1.setTotal(CustomerSetter.total(account.getLoanAmount(), account.getLoanDuration(),
				account.getInterestRate(), account.getdeductionAmt(), account.getLoanType()));
		obj1.setPastDue(CustomerSetter.pastdue(account.getLoanId(), account.getdeductionAmt(), account.getLoanAmount(),
				account.getLoanDuration(), account.getInterestRate(), account.getLoanType()));
		obj1.setTotalWithPenalty(CustomerSetter.totalwithpenalty(account.getLoanAmount(), account.getLoanDuration(),
				account.getInterestRate(), account.getdeductionAmt(), account.getLoanType()));
		obj1.setComplete(
				CustomerSetter.complete(account.getLoanDuration(), account.getdeductionAmt(), account.getLoanAmount(),
						account.getInterestRate(), account.getLoanType(), account.getLoanDuration() * 12));
		return obj1;
	}

	public static int calPM(double damount, double lamount, int duration) {
		int x = (int) ((int) (lamount - damount) / (lamount / (duration * 12)));
		return x;
	}

	public static double calEMI(double lamount, int duration, double damount) {
		if (damount == 0) {
			return 0;
		} else {
			double value1 = (lamount / (duration * 12));
			return value1;
		}
	}

	public static double calinterest(double lamount, double damount, int duration, double ir, String typee) {
		if (damount == 0) {
			return 0;
		} else {

			String s1 = typee;
			String s2 = "Personal";
			if (s1.equals(s2) || s1.equals(s1)) {
				double value1 = ((lamount * duration * ir) / 1200);
				return value1;
			} else {
				int n = (12 * duration);
				double r = (ir / 1200);
				double value = lamount * r * (Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);
				double value1 = value - (lamount / (duration * 12));
				return value1;
			}

		}

	}

	public static int total(double lamount, int duration, double ir, double damount, String typee) {
		double value2 = (calinterest(lamount, damount, duration, ir, typee) + calEMI(lamount, duration, damount));
		int x = (int) Math.ceil(value2);
		return x;

	}

	public static int pastdue(long LoanId, double damount, double lamount, int duration, double ir, String typee) {

		// System.out.println("++++++++++++++++++++++++++++++++++++++++");
		LoanAccount account = ti.getLoanAccountById((long) LoanId);
		System.out.println("the account name is:" + account.getLoanAmount());
		//
		LoanApplication Application = ti.getLoanAccountApplicationById(account.getloanappId());
		System.out.println("the processed date is :" + Application.getCreatedDate());
		//
		System.out.println("++++++-------------------------");
		// String startDateString = (String) account.getProcessDate();

		// System.out.println(account.getProcessDate());
		// String endDateString = LocalDate.now().toString();

		// String startDateString = Application.getApplicationDate();
		// String endDateString = "2023-06-29";

		LocalDate startDate = LocalDate.parse(Application.getApplicationDate());
		LocalDate endDate = LocalDate.now();

		int pm = calPM(damount, lamount, duration);

		// Calculate the difference in months
		Period period = Period.between(startDate, endDate);
		int months = period.getYears() * 12 + period.getMonths();

		int pereachmonth = total(lamount, duration, ir, damount, typee);

		int pastduee = months - pm;
		pastduee = pastduee * pereachmonth;
		// System.out.println("Number of months between the two dates: " + months);

		return pastduee;
	}

	public static int totalwithpenalty(double lamount, int duration, double ir, double damount, String typee) {
		double value1 = total(lamount, duration, ir, damount, typee); // + pastdue();
		int x = (int) Math.ceil(value1);
		return x;
	}

	public static int complete(int duration, double damount, double lamount, double ir, String typee, int noi) {
		String s1 = typee;
		String s2 = "PL";
		if (s1.equals(s2)) {

			double value1 = ((((lamount * duration * ir) / 100) + lamount) / 12)
					* (noi - calPM(damount, lamount, duration));

			int x = (int) Math.ceil(value1);
			return x;
		} else {

			int n = (12 * duration);
			double r = (ir / 1200);
			double value = lamount * r * (Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);

			long value2 = (long) (value * (noi - calPM(damount, lamount, duration)));
			// long value2 = (long) (damount + service.pastdue());
			// long value2 = (long) (service.calintereLunt, damount, duration, ir, typee) + damount +
			// service.pastdue());
			int x = (int) Math.ceil(value2);
			return x;
		}

	}

	public cashChest setcashchest(Long totalBalance, long value, long started) {
		cashChest c = new cashChest();
		c.settotalamount(totalBalance);
		c.setloaninterest(value);
		c.setstartedamount(started);
		return c;
	}

	// ======================================================================================================

	public LoanTransactions loantransactionSet(tempRepayment lt) {
		LoanTransactions obj = new LoanTransactions();
		obj.setLoanId(lt.getLoanid());
		obj.setEmi(lt.getEMI());
		obj.setInterest(lt.getInterest());
		obj.setTotal(lt.getTotal());
		obj.setAmount(lt.getAmount());
		obj.setComplete(lt.getComplete());
		obj.setDate(lt.getDate());
		obj.setInstallmentNo(lt.getinstallment_no());
		obj.setProcessedBy(1);
		return obj;

	}

	public tempRepayment setthistarn(transactioninfo tarn) {
		tempRepayment t = new tempRepayment();
		t.setLoanid(tarn.getAccountNumber());
		t.setDate(tarn.getDate());
		t.setTotal((int) tarn.getAmount());
		return t;
	}

}
// =========================================================
