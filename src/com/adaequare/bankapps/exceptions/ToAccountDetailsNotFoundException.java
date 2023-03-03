package com.adaequare.bankapps.exceptions;

public class ToAccountDetailsNotFoundException extends RuntimeException{

    public ToAccountDetailsNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
