package com.nkxgen.spring.jdbc.DaoInterfaces;

import java.util.List;

import com.nkxgen.spring.jdbc.model.AuditLogs;

public interface AuditLogDAO {

	void saveAudit(AuditLogs auditLogs);

	List<AuditLogs> getAllAuditLogs();
}
