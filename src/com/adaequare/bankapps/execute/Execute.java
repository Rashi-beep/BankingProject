package com.adaequare.bankapps.execute;

import com.adaequare.bankapps.dtos.AccountDetails;
import com.adaequare.bankapps.dtos.AccountOpeningDetails;
import com.adaequare.bankapps.dtos.Address;
import com.adaequare.bankapps.serviceproviders.hdfc.HdfcBankingServices;
import com.adaequare.bankapps.services.BankingServices;

import java.util.*;

public class Execute {

    public static void main(String[] args) throws Exception {
        BankingServices bankingServices = new HdfcBankingServices();

        AccountOpeningDetails accountOpeningDetails = new AccountOpeningDetails();

        accountOpeningDetails.setFirstName("Kishore");
        accountOpeningDetails.setLastName("Oggu");

        accountOpeningDetails.setAge(20);


        Address address= new Address();
        address.setCity("HYd");
        address.setPin(500049);

        accountOpeningDetails.setAddress(address);




        AccountDetails accountDetails = bankingServices.openAccountWithDetails(accountOpeningDetails);
        System.out.println("1 : Account id is : " + accountDetails.getAccountNumber() );

        AccountOpeningDetails accountOpeningDetails2 = new AccountOpeningDetails();
        accountOpeningDetails2.setFirstName("Praveen");
        accountOpeningDetails2.setLastName("Surname");
        accountOpeningDetails2.setAge(19);

        Address address2= new Address();
        address2.setCity("HYd");
        address2.setPin(500049);

        accountOpeningDetails2.setAddress(address2);

        AccountDetails accountDetails2 = bankingServices.openAccountWithDetails(accountOpeningDetails2);
        System.out.println("2 : Account id is : " + accountDetails2.getAccountNumber() );


        if(bankingServices instanceof HdfcBankingServices){
            HdfcBankingServices hdfcService = (HdfcBankingServices) bankingServices;

            Map<Long, AccountDetails> dataStore = hdfcService.getDataStore();


            Set<Long> accountNumbers = dataStore.keySet();

            Iterator<Long> iterator = accountNumbers.iterator();

            while(iterator.hasNext()){
                Long accountNumber = iterator.next();
                AccountDetails accDetails = dataStore.get(accountNumber);
                System.out.println("Account Number : " + accountNumber + " Account details :" + accDetails );
            }



        }












    }

}
