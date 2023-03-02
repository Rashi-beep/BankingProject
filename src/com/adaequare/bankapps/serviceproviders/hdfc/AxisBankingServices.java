package com.adaequare.bankapps.serviceproviders.hdfc;

import com.adaequare.bankapps.dtos.AccountDetails;
import com.adaequare.bankapps.dtos.AccountOpeningDetails;
import com.adaequare.bankapps.enums.TransactionType;
import com.adaequare.bankapps.services.BankingServices;

public class AxisBankingServices implements BankingServices {

    public void axisBankAdditionalService(){

    }
    @Override
    public AccountDetails openAccountWithDetails(AccountOpeningDetails accountOpeningDetails) throws Exception {
        return null;
    }

    @Override
    public float depositAmount(long acctNumber, float deposit, TransactionType transactionType) {
        return 0;
    }

    @Override
    public float withdrawAmount(long acctNumber, float withdraw, TransactionType transactionType) {
        return 0;
    }

    @Override
    public String transferAmount(float amount, long fromAccNumber, long toAccNumber) {
        return null;
    }
}
