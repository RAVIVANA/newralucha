package com.nkxgen.spring.jdbc.DaoInterfaces;

import java.util.List;

import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerSub;
import com.nkxgen.spring.jdbc.model.Customertrail;

public interface CustomerDaoInterface {

	void saveCustomer(Customertrail customer);

	Customertrail getCustomerById(Long id);

	void saveCustomertoDb(Customer customer);

	List<Customertrail> getAllCustomers();

	void updateCustomerDataById(Customertrail updatedCustomer);

	void deleteCusById(Customertrail cus);

	Customertrail getRealCustomerById(Long id);

	void changethese(Customertrail customer2, CustomerSub customerSub);

}
