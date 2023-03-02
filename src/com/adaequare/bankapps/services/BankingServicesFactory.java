package com.adaequare.bankapps.services;

import com.adaequare.bankapps.serviceproviders.hdfc.AxisBankingServices;
import com.adaequare.bankapps.serviceproviders.hdfc.HdfcBankingServices;

public class BankingServicesFactory {

    public BankingServices createBankingService(){
        BankingServices bankingServices = new AxisBankingServices();
        return bankingServices;
    }

    public BankingServices createBankingService(String bankingServiceImplType){
        BankingServices bankingServices = null;
        if(bankingServiceImplType.equals("HDFC")){
            bankingServices = new HdfcBankingServices();
        }else if(bankingServiceImplType.equals("AXIS")){
            bankingServices = new AxisBankingServices();
        }
        return bankingServices;
    }
}
