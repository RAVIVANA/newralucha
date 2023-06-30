package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.DaoInterfaces.LoanTypesInterface;
import com.nkxgen.spring.jdbc.model.LoansTypes;

@Repository
@Transactional
public class LoanTypesDAO implements LoanTypesInterface {

	@PersistenceContext
	private EntityManager entityManager;

	public List<LoansTypes> getAllLoans() {
		String jpql = "SELECT l FROM LoansTypes l"; // Define a JPQL query to retrieve all loan types
		TypedQuery<LoansTypes> query = entityManager.createQuery(jpql, LoansTypes.class); // Create a typed query using
																							// the JPQL query and
																							// specifying the result
																							// type as 'LoansTypes'
		return query.getResultList(); // Execute the query and return a list of all loan types
	}

	public List<LoansTypes> getAllLoanDetails() {
		String jpql = "SELECT l FROM LoansTypes l"; // Define a JPQL query to retrieve all loan types
		TypedQuery<LoansTypes> query = entityManager.createQuery(jpql, LoansTypes.class); // Create a typed query using
																							// the JPQL query and
																							// specifying the result
																							// type as 'LoansTypes'
		return query.getResultList(); // Execute the query and return a list of all loan types
	}

	public LoansTypes getSelectedLoanDetails(int loanType) {
		LoansTypes loan = entityManager.find(LoansTypes.class, loanType); // Find the loan type object with the given
																			// loanType using the entity manager
		System.out.println("im in the dao of loan types");
		System.out.println(loan.getLoanType());
		System.out.println(loan.getDescriptionForm());
		return loan; // Return the found loan type object
	}

	public void save(LoansTypes LoansTypes) {
		entityManager.merge(LoansTypes); // Merge the 'LoansTypes' object with the entity manager to update it in the
											// data store
	}

}
