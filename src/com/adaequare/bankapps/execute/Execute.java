package com.adaequare.bankapps.execute;

import com.adaequare.bankapps.dtos.AccountDetails;

import com.adaequare.bankapps.dtos.AccountOpeningDetails;
import com.adaequare.bankapps.dtos.Address;
import com.adaequare.bankapps.dtos.TransactionDetails;
import com.adaequare.bankapps.enums.TransactionType;
import com.adaequare.bankapps.serviceproviders.hdfc.HdfcBankingServices;
import com.adaequare.bankapps.services.BankingServices;
import com.adaequare.bankapps.services.BankingServicesFactory;

import java.util.*;

public class Execute {


    public static void main(String[] args) throws Exception {
        BankingServicesFactory bankingServicesFactory = new BankingServicesFactory();
        BankingServices bankingServices = bankingServicesFactory.createBankingService("DSFJSKAFJ");
        if (bankingServices instanceof HdfcBankingServices) {
            HdfcBankingServices hdfcService = (HdfcBankingServices) bankingServices;

            hdfcService.hdfcAdditionalService();


            AccountOpeningDetails accountOpeningDetails = new AccountOpeningDetails();

            accountOpeningDetails.setFirstName("Kishore");
            accountOpeningDetails.setLastName("Oggu");

            accountOpeningDetails.setAge(20);


            Address address = new Address();
            address.setCity("HYd");
            address.setPin(500049);

            accountOpeningDetails.setAddress(address);


            AccountDetails accountDetails = bankingServices.openAccountWithDetails(accountOpeningDetails);
            System.out.println("1 : Account id is : " + accountDetails.getAccountNumber());

            AccountOpeningDetails accountOpeningDetails2 = new AccountOpeningDetails();
            accountOpeningDetails2.setFirstName("Praveen");
            accountOpeningDetails2.setLastName("Surname");
            accountOpeningDetails2.setAge(19);

            Address address2 = new Address();
            address2.setCity("HYd");
            address2.setPin(500049);

            accountOpeningDetails2.setAddress(address2);

            AccountDetails accountDetails2 = bankingServices.openAccountWithDetails(accountOpeningDetails2);
            System.out.println("2 : Account id is : " + accountDetails2.getAccountNumber());




            hdfcService.depositAmount(accountDetails.getAccountNumber(), 10000, TransactionType.CREDIT);

            System.out.println("After deposit " + accountDetails);
            hdfcService.transferAmount(2000, accountDetails.getAccountNumber(), accountDetails2.getAccountNumber());
            System.out.println("Updated balance details " + accountDetails);
        }
    }

}


