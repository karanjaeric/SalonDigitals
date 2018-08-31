package com.thepensionapp.salondigitals;

/**
 * Created by ekaranja on 6/2/18.
 */

public class Customer {

    private String customerName;
    private String phoneNumber;
    private int points;

    public Customer(String customerName, String phoneNumber, int points) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.points = points;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
