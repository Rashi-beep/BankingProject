package com.adaequare.bankapps.services;

import com.adaequare.bankapps.enums.BankName;
import com.adaequare.bankapps.serviceproviders.hdfc.AxisBankingServices;
import com.adaequare.bankapps.serviceproviders.hdfc.HdfcBankingServices;

public class BankingServicesFactory {

    public BankingServices createBankingService(){
        BankingServices bankingServices = new AxisBankingServices();
        return bankingServices;
    }

    public BankingServices createBankingService(BankName bankingServiceImplType){
        BankingServices bankingServices = null;
        if(bankingServiceImplType == BankName.HDFC){
            bankingServices = new HdfcBankingServices();
        }else if(bankingServiceImplType == BankName.AXIS){
            bankingServices = new AxisBankingServices();
        }


        switch (bankingServiceImplType){
            case AXIS:
                bankingServices = new AxisBankingServices();
                break;
            case HDFC:
                bankingServices = new HdfcBankingServices();
                break;
            case ICICI: break;
        }
        return bankingServices;
    }
}
