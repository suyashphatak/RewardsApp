package com.assignment.rewards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class CustomerTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transId;

    private int customerId;
    private String spentDetails;
    private BigDecimal amount;
    private LocalDate date;

    public CustomerTransaction() {
    }

    public CustomerTransaction(int transId, int customerId, String spentDetails, BigDecimal amount, LocalDate date) {
        this.transId = transId;
        this.customerId = customerId;
        this.spentDetails = spentDetails;
        this.amount = amount;
        this.date = date;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getSpentDetails() {
        return spentDetails;
    }

    public void setSpentDetails(String spentDetails) {
        this.spentDetails = spentDetails;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomerTransaction{" +
                "transId=" + transId +
                ", customerId=" + customerId +
                ", spentDetails='" + spentDetails + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
