package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.DaoInterfaces.BankUserInterface;
import com.nkxgen.spring.jdbc.model.BankUser;

@Service
public class BankUserService implements BankUserInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean saveBankUser(BankUser bankUser) {
		// Persist the BankUser object in the database
		entityManager.persist(bankUser);
		return true;
	}

	public BankUser getBankUserById(long busr_id) {
		// Retrieve a BankUser object from the database based on the provided ID
		return entityManager.find(BankUser.class, busr_id);
	}

	public List<BankUser> getAllBankUsers() {
		// Retrieve all BankUser objects from the database, ordered by busr_id in ascending order
		return entityManager.createQuery("SELECT u FROM BankUser u ORDER BY u.busr_id ASC").getResultList();
	}

	@Transactional
	public BankUser saveUser(BankUser bankUser) {
		// Merge the BankUser object in the database, which will either update an existing record or create a new one
		return entityManager.merge(bankUser);
	}

	@Transactional
	public List<BankUser> getBankUsersByDesignation(String designation) {
		// Retrieve a list of BankUser objects from the database based on the provided designation
		return entityManager.createQuery("SELECT bu FROM BankUser bu WHERE bu.busr_desg = :designation", BankUser.class)
				.setParameter("designation", designation).getResultList();
	}

	@Transactional
	public List<BankUser> getBankUsersByDesignation(BankUser bankUser) {
		// Retrieve a list of BankUser objects from the database based on the designation of the provided BankUser
		// object
		return entityManager.createQuery("SELECT bu FROM BankUser bu WHERE bu.busr_desg = :designation", BankUser.class)
				.setParameter("designation", bankUser.getBusr_desg()).getResultList();
	}

}