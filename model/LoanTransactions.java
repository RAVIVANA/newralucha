package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoanTransactions")
public class LoanTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tran_id")
    private int tran_id;
    
    @Column(name = "processedBy")
    private int processedBy;
    
    @Column(name = "tran_loan_id")
    private int loanId;

    @Column(name = "emi")
    private double emi;

    @Column(name = "interest")
    private double interest;
    
   @Column(name="tran_type")
   private String type;

    @Column(name = "total")
    private double total;

    @Column(name = "amount")
    private double amount;

    @Column(name = "complete")
    private double complete;

    @Column(name = "date")
    private String date;

    @Column(name = "installment_no")
    private int installmentNo;
    

    public LoanTransactions() {

    }
    //=====getters==================

    public int getLoanId() {
        return loanId;
    }
    
    public double getEmi() {
        return emi;
    }

    public double getInterest() {
        return interest;
    }
    public double getTotal() {
        return total;
    }

    public double getAmount() {
        return amount;
    }
    
    public double getComplete() {
        return complete;
    }
    public String getDate() {
        return date;
    }
    public int getInstallmentNo() {
        return installmentNo;
    }
    public int getTran_id() {
        return tran_id;
    }

    public int getProcessedBy() {
        return processedBy;
    }

    public String getType() {
        return type;
    }
    
    //settersss

    
    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    
    public void setInterest(double interest) {
        this.interest = interest;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setComplete(double complete) {
        this.complete = complete;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInstallmentNo(int installmentNo) {
        this.installmentNo = installmentNo;
    }
    
    public void setTran_id(int tran_id) {
        this.tran_id = tran_id;
    }

    public void setProcessedBy(int processedBy) {
        this.processedBy = processedBy;
    }

    public void setType(String type) {
        this.type = type;
    }
}
