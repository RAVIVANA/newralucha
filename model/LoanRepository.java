package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<LoanAccount> getLoanAccountsByType(String loanType) {
		String jpql = "SELECT la FROM LoanAccount la WHERE la.loanType = :loanType";
		TypedQuery<LoanAccount> query = entityManager.createQuery(jpql, LoanAccount.class);
		query.setParameter("loanType", loanType);
		return query.getResultList();
	}
}
