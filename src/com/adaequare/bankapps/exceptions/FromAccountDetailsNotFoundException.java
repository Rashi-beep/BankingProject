package com.adaequare.bankapps.exceptions;

public class FromAccountDetailsNotFoundException extends RuntimeException{
    public FromAccountDetailsNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
