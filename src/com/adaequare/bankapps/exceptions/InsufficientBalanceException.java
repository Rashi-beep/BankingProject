package com.adaequare.bankapps.exceptions;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String errorMsg){
        super(errorMsg);
    }

}
