package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.Bal.CustomerSetter;
import com.nkxgen.spring.jdbc.DaoInterfaces.CustomerDaoInterface;
import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerSub;
import com.nkxgen.spring.jdbc.model.Customertrail;

@Repository
@Transactional
public class CustomerDao implements CustomerDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CustomerSetter s;

	@Override
	public void saveCustomer(Customertrail customer) {
		entityManager.merge(customer);

	}

	@Override
	public Customertrail getCustomerById(Long id) {
		// Retrieve customer data from the table based on the ID
		Customertrail customer = entityManager.find(Customertrail.class, id);
		return customer;
	}

	@Override
	public void saveCustomertoDb(Customer customer) {
		entityManager.persist(customer); // Persist the 'customer' object by adding it to the entity manager
	}

	@Override
	public List<Customertrail> getAllCustomers() {
		String jpql = "SELECT la FROM Customertrail la"; // Define a JPQL query to retrieve all customer objects
		TypedQuery<Customertrail> query = entityManager.createQuery(jpql, Customertrail.class); // Create a typed query
																								// using the JPQL query
																								// and specifying the
																								// result type as
																								// 'Customertrail'
		return query.getResultList(); // Execute the query and return a list of all customer objects
	}

	@Override
	public void updateCustomerDataById(Customertrail updatedCustomer) {
		entityManager.merge(updatedCustomer); // Merge the 'updatedCustomer' object with the entity manager to update it
												// in the data store
	}

	@Override
	public void deleteCusById(Customertrail cus) {
		// TODO Auto-generated method stub
		// Assuming Customertrail class has an 'id' property

		long customerId = cus.getId(); // Extract the 'id' property from the 'cus' object and store it in 'customerId'
										// variable

		Customertrail customer = entityManager.find(Customertrail.class, customerId); // Find the customer object with
																						// the given 'customerId' using
																						// the entity manager

		if (customer != null) { // If a customer object is found
			entityManager.remove(customer); // Remove the customer object from the entity manager
			System.out.println("Customer with ID " + customerId + " has been deleted successfully.");
		} else { // If no customer object is found
			System.out.println("Customer with ID " + customerId + " does not exist.");
		}
	}

	@Override
	public Customertrail getRealCustomerById(Long customerId) {
		Customertrail customer = entityManager.find(Customertrail.class, customerId); // Find the customer object with
																						// the given 'customerId' using
																						// the entity manager

		return customer; // Return the found customer object, or null if no customer is found
	}

	@Override
	public void changethese(Customertrail customer2, CustomerSub customerSub) {
		Customertrail customer = s.changing(customer2, customerSub); // Call a method 'changing' from a service or
																		// utility class 's' to modify the 'customer2'
																		// object and assign the modified customer to
																		// 'customer' variable

		entityManager.merge(customer); // Merge the modified 'customer' object with the entity manager to update it in
										// the data store
	}

}