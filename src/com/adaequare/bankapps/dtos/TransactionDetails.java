package com.adaequare.bankapps.dtos;

import com.adaequare.bankapps.enums.TransactionType;

import java.util.Date;

public class TransactionDetails {

    private long transactionId;
    private Date transactionTime;

    private float amount;

    private TransactionType transactionType;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Transaction details are ");
        result.append("transactionType ");
        result.append(this.getTransactionType());
        result.append(" Amount ");
        result.append(this.getAmount());
        return result.toString();
    }
}
