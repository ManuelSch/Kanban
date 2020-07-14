package com.manuelsch.simplekanban.DTOs.exceptionHandling;

/**
 * Is thrown whenever the user sends a request with invalid input
 */
public class InputValidationException extends Exception {

    public InputValidationException(String message) {
        super(message);
    }

}
