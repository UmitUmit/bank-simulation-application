package com.cydeo.banksimulation.exception;

public class AccountOwnerShipException extends RuntimeException {
    //I didn't extend Throwable, because it covers error, I don't want to cover error
    public AccountOwnerShipException(String message) {
    }
}
