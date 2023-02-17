package com.adaequare.bankapps.services;

import com.adaequare.bankapps.dtos.AccountDetails;
import com.adaequare.bankapps.dtos.AccountOpeningDetails;

public interface BankingServices {
    AccountDetails openAccountWithDetails(AccountOpeningDetails accountOpeningDetails) throws Exception;

    float depositAmount(long acctNumber, float deposit);

    float withdrawAmount(float withdraw);

    String transferAmount(float amount, Object accountDetails);
}
