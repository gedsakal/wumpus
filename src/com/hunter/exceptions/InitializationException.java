package com.hunter.exceptions;

public class InitializationException extends Exception {

    String cause;

    public InitializationException(String cause){
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return "WUMPUS Game InitializationException";
    }
}
