package com.manuelsch.simplekanban.DTOs;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;

public interface Request {

    void validate() throws InputValidationException;

}
