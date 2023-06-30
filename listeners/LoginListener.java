package com.nkxgen.spring.jdbc.listeners;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nkxgen.spring.jdbc.DaoInterfaces.AuditLogDAO;
import com.nkxgen.spring.jdbc.events.LoginEvent;
import com.nkxgen.spring.jdbc.model.AuditLogs;

@Component
public class LoginListener {
	@Autowired
	private AuditLogDAO auditLogDAO;

	@EventListener
	public void login(LoginEvent event) {
		auditLogDAO.saveAudit(
				new AuditLogs(event.getEvent(), new Timestamp(System.currentTimeMillis()), event.getUsername()));
		System.out.println(event.getEvent());
	}
}
