package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.DaoInterfaces.AuditLogDAO;
import com.nkxgen.spring.jdbc.model.AuditLogs;

@Repository
public class AuditDAOImpl implements AuditLogDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveAudit(AuditLogs audits) {
		// Print a message indicating that the audit is saved
		System.out.println("Audit Saved " + audits);

		// Persist the audit log object in the database
		entityManager.persist(audits);
	}

	@Transactional
	public List<AuditLogs> getAllAuditLogs() {
		// Create a typed query to retrieve all audit logs from the database, ordered by ID in descending order
		TypedQuery<AuditLogs> query = entityManager.createQuery("SELECT a FROM AuditLogs a ORDER BY a.id DESC",
				AuditLogs.class);

		// Execute the query and return the list of audit logs
		return query.getResultList();
	}
}
