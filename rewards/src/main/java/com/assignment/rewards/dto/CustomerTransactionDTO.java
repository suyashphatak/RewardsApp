package com.assignment.rewards.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerTransactionDTO {

    private int customerId;
    private String spentDetails;
    private BigDecimal amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    public CustomerTransactionDTO() {
    }

    public CustomerTransactionDTO(int customerId, String spentDetails, BigDecimal amount, LocalDate date) {
        this.customerId = customerId;
        this.spentDetails = spentDetails;
        this.amount = amount;
        this.date = date;
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
        return "CustomerTransactionDTO{" +
                "customerId=" + customerId +
                ", spentDetails='" + spentDetails + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
