package com.assignment.rewards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class RewardPoints {

    @Id
    private int customerID;
    private int month;
    private int year;
    private long points;

    public RewardPoints() {
    }

    public RewardPoints(int customerID, int month, int year, long points) {
        this.customerID = customerID;
        this.month = month;
        this.year = year;
        this.points = points;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "RewardPoints{" +
                "customerID=" + customerID +
                ", month=" + month +
                ", year=" + year +
                ", points=" + points +
                '}';
    }
}
