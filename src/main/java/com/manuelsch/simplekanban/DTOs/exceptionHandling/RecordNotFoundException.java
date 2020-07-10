package com.manuelsch.simplekanban.DTOs.exceptionHandling;

/**
 * Is thrown whenever a database entry should exist but could not be found
 */
public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
