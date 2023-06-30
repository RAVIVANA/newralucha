package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banktransaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tran_id")
	private int tran_id;

	@Column(name = "tran_anct_id")
	private int tran_anct_id;

	@Column(name = "tran_date")
	private String tran_date;

	@Column(name = "tran_type")
	private String tran_type;

	@Column(name = "tran_mode")
	private String tran_mode;

	@Column(name = "tran_amount")
	private double tran_amount;

	@Column(name = "tran_processedby")
	private int tran_processedby;

	public Transaction() {
		// Default constructor required by JPA
	}

	public void setTran_id(int tran_id) {
		this.tran_id = tran_id;
	}

	public void setTran_anct_id(int tran_anct_id) {
		this.tran_anct_id = tran_anct_id;
	}

	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public void setTran_mode(String tran_mode) {
		this.tran_mode = tran_mode;
	}

	public void setTran_amount(double tran_amount) {
		this.tran_amount = tran_amount;
	}

	public void setTran_processedby(int tran_processedby) {
		this.tran_processedby = tran_processedby;
	}

	public int getTran_id() {
		return tran_id;
	}

	public int getTran_anct_id() {
		return tran_anct_id;
	}

	public String getTran_type() {
		return tran_type;
	}

	public String getTran_mode() {
		return tran_mode;
	}

	public double getTran_amount() {
		return tran_amount;
	}

	public int getTran_processedby() {
		return tran_processedby;
	}

	// public TransactionByUser(int tran_id, int tran_anct_id, String tran_date, String tran_type, String tran_mode,
	// double tran_amount, int tran_processedby) {
	// this.tran_id = tran_id;
	// this.tran_anct_id = tran_anct_id;
	// this.tran_date = tran_date;
	// this.tran_type = tran_type;
	// this.tran_mode = tran_mode;
	// this.tran_amount = tran_amount;
	// this.tran_processedby = tran_processedby;
	// }
}