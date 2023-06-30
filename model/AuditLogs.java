package com.nkxgen.spring.jdbc.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event")
    private String event;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    
    private String username;

    public AuditLogs() {
    }

    public AuditLogs(String event, Timestamp timestamp, String username) {
        this.event = event;
        this.timestamp = timestamp;
        this.username = username;
    }


    // Getters and Setters

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AuditLogs [id=" + id + ", event=" + event + ", timestamp=" + timestamp + ", username=" + username + "]";
	}



   
}
