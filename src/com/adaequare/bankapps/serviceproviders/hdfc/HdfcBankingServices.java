package com.adaequare.bankapps.serviceproviders.hdfc;

import com.adaequare.bankapps.dtos.AccountDetails;
import com.adaequare.bankapps.dtos.AccountOpeningDetails;
import com.adaequare.bankapps.dtos.TransactionDetails;
import com.adaequare.bankapps.enums.TransactionType;
import com.adaequare.bankapps.services.BankingServices;

import java.util.*;

public class HdfcBankingServices implements BankingServices {

    private Map<Long, AccountDetails> accountDataStore = new HashMap();

    private float amount;
    @Override
    public AccountDetails openAccountWithDetails(AccountOpeningDetails accountOpeningDetails) throws Exception {

        if (!validateAccountOpeningDetails(accountOpeningDetails)) {
            throw new Exception("Invalid data provided");
        }


        AccountDetails accountDetails = new AccountDetails();

        accountDetails.setAccountNumber(new Random().nextLong());

        accountDetails.setAddress(accountOpeningDetails.getAddress());

        accountDetails.setFirstName(accountOpeningDetails.getFirstName());

        accountDetails.setLastName(accountOpeningDetails.getLastName());

        accountDataStore.put(accountDetails.getAccountNumber(), accountDetails);

        return accountDetails;


    }


    public boolean validateAccountOpeningDetails(AccountOpeningDetails accountOpeningDetails) {
        if (null == accountOpeningDetails) {
            return false;
        }

        if (accountOpeningDetails.getAge() < 16) {
            return false;
        }

        if (null == accountOpeningDetails.getFirstName() || accountOpeningDetails.getFirstName().isBlank()) {
            return false;
        }

        if (null == accountOpeningDetails.getLastName() || accountOpeningDetails.getLastName().isBlank()) {
            return false;
        }

        return true;
    }


    @Override
    public float depositAmount(long accountNumber, float deposit, TransactionType transactionType) {

        if(transactionType == TransactionType.DEBIT){
            throw new RuntimeException("Invalid transaction");
        }
        AccountDetails accountDetails = accountDataStore.get(accountNumber);
        float bankBalance = accountDetails.getBankBalance();
        accountDetails.setBankBalance(bankBalance + deposit);


        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setAmount(deposit);
        //transactionDetails.setTransactionTime(new Date());
        transactionDetails.setTransactionId(new Random().nextLong());
        transactionDetails.setTransactionType(transactionType);

        List<TransactionDetails> transactionDetailsList = accountDetails.getTransactionDetailsList();
        transactionDetailsList.add(transactionDetails);

        // Alternative to above 2 lines
        //accountDetails.getTransactionDetailsList().add(transactionDetails);


        return accountDetails.getBankBalance();
    }

    @Override
    public float withdrawAmount(long acctNumber, float withdraw, TransactionType transactionType ) {


        if(transactionType == TransactionType.CREDIT){
            throw new RuntimeException("Invalid transaction");
        }
        AccountDetails accountDetails = accountDataStore.get(acctNumber);


        float bankBalance = accountDetails.getBankBalance();

        if (withdraw > bankBalance) {
            throw new RuntimeException("In Sufficient balance");
        }

        accountDetails.setBankBalance(bankBalance - withdraw);


        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setAmount(withdraw);
        transactionDetails.setTransactionTime(new Date());
        transactionDetails.setTransactionId(new Random().nextLong());
        transactionDetails.setTransactionType(transactionType);

        accountDetails.getTransactionDetailsList().add(transactionDetails);

        return accountDetails.getBankBalance();
    }

    @Override
    public String transferAmount(float amount, long fromAccNumber, long toAccNumber) {

        AccountDetails fromAccountDetails = this.accountDataStore.get(fromAccNumber);

        AccountDetails toAccountDetails = this.accountDataStore.get(toAccNumber);

        if (null == fromAccountDetails) {
            throw new RuntimeException("Invalid from account details");
        }

        if (null == toAccountDetails) {
            throw new RuntimeException("Invalid to account details");
        }

        try {
            this.withdrawAmount(fromAccNumber, amount, TransactionType.TRANSFER);
            this.depositAmount(toAccNumber, amount, TransactionType.CREDIT);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception raised we need to roll back our transaction");
        }
        return "Amount transferred successfully";
    }

    public Map<Long, AccountDetails> getDataStore() {
        return accountDataStore;
    }
}
