package com.efostach.ams.controller.exceptions;

public class OperationNotExecutedException extends Exception {

    public OperationNotExecutedException(String message){
        super(message);
    }
}
