package com.adaequare.bankapps.services;

import com.adaequare.bankapps.dtos.AccountDetails;
import com.adaequare.bankapps.dtos.AccountOpeningDetails;
import com.adaequare.bankapps.enums.TransactionType;

public interface BankingServices {
    AccountDetails openAccountWithDetails(AccountOpeningDetails accountOpeningDetails) throws Exception;

    float depositAmount(long acctNumber, float deposit, TransactionType transactionType);

    float withdrawAmount(long acctNumber, float withdraw, TransactionType transactionType);

    String transferAmount(float amount, long fromAccNumber, long toAccNumber);
}
