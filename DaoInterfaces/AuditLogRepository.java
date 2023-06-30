package com.nkxgen.spring.jdbc.DaoInterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nkxgen.spring.jdbc.model.AuditLogs;

public interface AuditLogRepository extends JpaRepository<AuditLogs, Long> {

	Page<AuditLogs> findAllByOrderByTimestampDesc(Pageable pageable);

	Page<AuditLogs> findAll(Pageable pageable);
}
