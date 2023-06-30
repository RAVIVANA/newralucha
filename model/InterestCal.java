package com.nkxgen.spring.jdbc.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@NamedStoredProcedureQuery(name = "smi", procedureName = "smi", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "acc", type = Integer.class) })

@Table(name = "gvacc")
public class InterestCal {

	@Id
	int accno;
	String accname;
	Date op_date;
	double currentbal;
	String tr_type;

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public Date getOp_date() {
		return op_date;
	}

	public void setOp_date(Date op_date) {
		this.op_date = op_date;
	}

	public double getCurrentbal() {
		return currentbal;
	}

	public void setCurrentbal(double currentbal) {
		this.currentbal = currentbal;
	}

	public String getTr_type() {
		return tr_type;
	}

	public void setTr_type(String tr_type) {
		this.tr_type = tr_type;
	}

}
