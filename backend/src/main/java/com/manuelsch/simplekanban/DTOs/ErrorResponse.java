package com.manuelsch.simplekanban.DTOs;

/**
 * The REST API response that is sent if some error occurred
 */
public class ErrorResponse implements Response {

    private boolean error;
    private String errorMsg;

    public ErrorResponse(String errorMsg) {
        this.error = true;
        this.errorMsg = errorMsg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
