package com.assignment.rewards.dto;

import java.util.Map;

public class RewardsMessageDTO {

    private int customerId;
    private Map<String, Long> perMonth;
    private long total;

    public RewardsMessageDTO() {
    }

    public RewardsMessageDTO(int customerId, Map<String, Long> perMonth, long total) {
        this.customerId = customerId;
        this.perMonth = perMonth;
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Map<String, Long> getPerMonth() {
        return perMonth;
    }

    public void setPerMonth(Map<String, Long> perMonth) {
        this.perMonth = perMonth;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RewardsMessageDTO{" +
                "customerId=" + customerId +
                ", perMonth=" + perMonth +
                ", total=" + total +
                '}';
    }
}
