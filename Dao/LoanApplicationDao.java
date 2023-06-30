package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.Bal.CustomerSetter;
import com.nkxgen.spring.jdbc.DaoInterfaces.LoanApplicationDaoInterface;
import com.nkxgen.spring.jdbc.InputModels.LoanApplicationInput;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;

@Repository
@Transactional
public class LoanApplicationDao implements LoanApplicationDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	CustomerSetter s;

	@Override
	public List<LoanApplication> getLoanApplicationByValue(String value) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.loanTypeId = :value and la.status=:val"; // Define a
																											// JPQL
																											// query to
																											// retrieve
																											// loan
																											// application
																											// objects
																											// based on
																											// the loan
																											// type ID
																											// and
																											// status
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class); // Create a typed
																									// query using the
																									// JPQL query and
																									// specifying the
																									// result type as
																									// 'LoanApplication'
		query.setParameter("value", value); // Set the value of the 'value' parameter in the query to the provided
											// 'value' value
		query.setParameter("val", "waiting"); // Set the value of the 'val' parameter in the query to "waiting"
		return query.getResultList(); // Execute the query and return a list of loan application objects matching the
										// loan type ID and status
	}

	@Override
	public void saveLoanApplication(LoanApplication loanApplication) {
		entityManager.persist(loanApplication); // Persist the 'loanApplication' object by adding it to the entity
												// manager
	}

	@Override
	public void updateLoanApplication(LoanApplicationInput loanApplication) {
		LoanApplication la = entityManager.find(LoanApplication.class, loanApplication.getId()); // Find the loan
																									// application
																									// object with the
																									// given ID using
																									// the entity
																									// manager
		la.LoanApplication(loanApplication); // Update the properties of the loan application object using the provided
												// loan application input
		entityManager.merge(la); // Merge the updated loan application object with the entity manager to update it in
									// the data store
	}

	@Override
	public List<LoanApplication> getLoanApplicationsByStatus(String status) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.status = :status"; // Define a JPQL query to retrieve
																						// loan application objects
																						// based on the status
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class); // Create a typed
																									// query using the
																									// JPQL query and
																									// specifying the
																									// result type as
																									// 'LoanApplication'
		query.setParameter("status", status); // Set the value of the 'status' parameter in the query to the provided
												// 'status' value
		return query.getResultList(); // Execute the query and return a list of loan application objects matching the
										// status
	}

	@Override
	public List<LoanAccount> getLoanAccountsByLoanType(String loanType) {
		String queryStr = "SELECT la FROM LoanAccount la WHERE la.loanType = :loanType"; // Define a JPQL query to
																							// retrieve loan account
																							// objects based on the loan
																							// type
		TypedQuery<LoanAccount> query = entityManager.createQuery(queryStr, LoanAccount.class); // Create a typed query
																								// using the JPQL query
																								// and specifying the
																								// result type as
																								// 'LoanAccount'
		query.setParameter("loanType", loanType); // Set the value of the 'loanType' parameter in the query to the
													// provided 'loanType' value
		return query.getResultList(); // Execute the query and return a list of loan account objects matching the loan
										// type
	}

	@Override
	public void deleteApplication(int loanId) {
		LoanApplication loanApplication = entityManager.find(LoanApplication.class, loanId); // Find the loan
																								// application object
																								// with the given
																								// 'loanId' using the
																								// entity manager

		if (loanApplication != null) { // If a loan application object is found
			entityManager.remove(loanApplication); // Remove the loan application object from the entity manager
		}
	}

	@Override
	public void approveApplication(int loanId, long custId) {
		LoanApplication loanApplication = entityManager.find(LoanApplication.class, loanId);
		// Find the loan

		// application object
		// with the given
		// 'loanId' using the
		// entity manager

		Customertrail customer = entityManager.find(Customertrail.class, custId); // Find the customer object with the
																					// given 'custId' using the entity
																					// manager

		LoanAccount l = new LoanAccount(); // Create a new LoanAccount object

		l.setValuesFromLoanAccount(loanApplication); // Set the values of the LoanAccount object using the loan
														// application object

		entityManager.persist(l); // Persist the LoanAccount object by adding it to the entity manager
	}

	public List<LoanAccount> getAllLoans() {
		String jpql = "SELECT l FROM LoanAccount l"; // Define a JPQL query to retrieve all loan account objects
		TypedQuery<LoanAccount> query = entityManager.createQuery(jpql, LoanAccount.class); // Create a typed query
																							// using the JPQL query and
																							// specifying the result
																							// type as 'LoanAccount'
		return query.getResultList(); // Execute the query and return a list of all loan account objects
	}

	@Override
	public LoanApplication getLoanApplicationByid(long accountType) {

		LoanApplication LoanApplication = entityManager.find(LoanApplication.class, accountType);
		return LoanApplication;

	}

	@Override
	public void saveTheApprovedLoanApplication(LoanApplication loanapp) {
		entityManager.merge(loanapp);

	}

}
