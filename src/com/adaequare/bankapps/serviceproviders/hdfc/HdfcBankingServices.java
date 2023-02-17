package com.adaequare.bankapps.serviceproviders.hdfc;

import com.adaequare.bankapps.dtos.AccountDetails;
import com.adaequare.bankapps.dtos.AccountOpeningDetails;
import com.adaequare.bankapps.services.BankingServices;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HdfcBankingServices implements BankingServices {

    private Map<Long, AccountDetails> accountDataStore = new HashMap();


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
    public float depositAmount(long accountNumber, float deposit) {
        AccountDetails accountDetails = accountDataStore.get(accountNumber);
        float bankBalance = accountDetails.getBankBalance();
        accountDetails.setBankBalance(bankBalance + deposit);
        return accountDetails.getBankBalance();
    }

    @Override
    public float withdrawAmount(float withdraw) {
        return 0;
    }

    @Override
    public String transferAmount(float amount, Object accountDetails) {
        return null;
    }


    public Map<Long, AccountDetails> getDataStore(){
        return accountDataStore;
    }
}
