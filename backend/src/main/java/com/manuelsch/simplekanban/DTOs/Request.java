package com.manuelsch.simplekanban.DTOs;

import com.manuelsch.simplekanban.DTOs.exceptionHandling.InputValidationException;

import java.io.Serializable;

public interface Request extends Serializable {

    void validate() throws InputValidationException;

}
