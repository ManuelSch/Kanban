package com.manuelsch.simplekanban.DTOs;

/**
 * The REST API response that is sent if the request was successful
 */
public class SuccessResponse<D> implements Response {

    private D data;

    public SuccessResponse(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
