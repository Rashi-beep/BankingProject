package com.adaequare.bankapps.dtos;

import java.util.ArrayList;
import java.util.List;

public class AccountDetails {

    private long accountNumber;
    private String firstName;
    private String lastName;


    private Address address;


    private float bankBalance;

    List<TransactionDetails> transactionDetailsList;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(float bankBalance) {
        this.bankBalance = bankBalance;
    }

    public List<TransactionDetails> getTransactionDetailsList() {
        if (null == transactionDetailsList) {
            transactionDetailsList = new ArrayList<>();
        }
        return transactionDetailsList;
    }

    public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
        this.transactionDetailsList = transactionDetailsList;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "accountNumber=" + accountNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", bankBalance=" + bankBalance +
                ", transactionDetailsList=" + getTransactionDetailsList() +
                '}';
    }
}
