package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.Bal.CustomerSetter;
import com.nkxgen.spring.jdbc.Bal.ViewInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.CustomerDaoInterface;
import com.nkxgen.spring.jdbc.ViewModels.CustomerViewModel;
import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerSub;
import com.nkxgen.spring.jdbc.model.Customertrail;

@Controller
public class customercontroller {
	@Autowired
	private CustomerDaoInterface cd;
	@Autowired
	ViewInterface v;

	@RequestMapping(value = "/customer_data_trail_save", method = RequestMethod.POST)
	public String customerDataSaveToDb(@Validated CustomerViewModel customer, Model model) {
		// Print the new customer ID
		System.out.println("this is my new customer id : " + customer.getId());

		// Perform service operations on the customer view model to generate the customer trail
		Customertrail cus = CustomerSetter.dotheservice2(customer);

		// Check if the customer trail has an ID
		if (cus.getId() != null) {
			// Update the existing customer trail in the database
			cd.saveCustomer(cus);
		} else {
			// Save the new customer trail to the database
			cd.saveCustomer(cus);
		}

		// Return the view name "Account_new_application_form" to render the page
		return "account-new-application-form";
	}

	// =================================================
	// real saving
	@RequestMapping(value = "/saveToCustomerDatabase", method = RequestMethod.POST)
	public String saveToCustomerDatabase(@RequestParam("CustomerId") Long customerId) {
		// Convert the customerId to a long value
		long customerid = customerId;

		// Print the customerid value
		System.out.println("print the value: " + customerid);

		// Retrieve the Customertrail object from the database using the customerid
		Customertrail cus = cd.getCustomerById(customerid);

		// Print the ID of the retrieved Customertrail object
		System.out.println("print the value returning: " + cus.getId());

		// Perform service operations on the Customertrail object to generate the Customer object
		Customer customer = CustomerSetter.dotheservice(cus);

		// Save the Customer object to the database
		cd.saveCustomertoDb(customer);

		// Change the return to the view name "Account_new_application_form" to render the page
		return "account-new-application-form";
	}

	// =========================================================
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public String getAllCustomers(Model model) {
		// Retrieve a list of all customers
		List<Customer> customerList = v.getAllCustomers();

		// Add the customerList as an attribute to the model
		model.addAttribute("customerList", customerList);

		// Return the view name "customer_edit_details_form" to render the page
		return "customer-edit-details-form";
	}

	// ===============================================================
	// editing the existing data
	// =========================================================
	@RequestMapping(value = "/customerDataUpdation", method = RequestMethod.POST)
	public String CustomerDataUpdation(Customertrail updatedCustomer) {
		// Update the customer data based on the provided updatedCustomer object
		cd.updateCustomerDataById(updatedCustomer);

		// Return the view name "customer_edit_details_form" to render the page
		return "customer-edit-details-form";
	}

	// =========================================================================================
	@RequestMapping(value = "/saveToCustomersubDatabase", method = RequestMethod.POST)
	public String saveToCustomersubDatabase(@Validated CustomerSub CustomerSub, Model model) {
		// Get the real customer by the provided CustomerId from the CustomerSub object
		Customertrail customer2 = cd.getRealCustomerById(CustomerSub.getCustomerId());

		// Change the properties of customer2 based on the values from the CustomerSub object
		cd.changethese(customer2, CustomerSub);

		// Return the view name "Any_Type_account_info" to render the page
		return "any-Type-account-info";
	}

}