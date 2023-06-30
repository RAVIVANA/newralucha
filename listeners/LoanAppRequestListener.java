package com.nkxgen.spring.jdbc.listeners;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.nkxgen.spring.jdbc.DaoInterfaces.AuditLogDAO;
import com.nkxgen.spring.jdbc.events.LoanAppRequestEvent;
import com.nkxgen.spring.jdbc.model.AuditLogs;

@Controller
public class LoanAppRequestListener {

	@Autowired
	private AuditLogDAO auditLogDAO;

	@EventListener
	public void onEvent(LoanAppRequestEvent event) {
		auditLogDAO.saveAudit(
				new AuditLogs(event.getEvent(), new Timestamp(System.currentTimeMillis()), event.getUsername()));
		System.out.println(event.getEvent());
	}

}
