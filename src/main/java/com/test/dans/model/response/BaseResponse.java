package com.test.dans.model.response;

public class BaseResponse <T>{
    private String message;
    private Integer responseCode;
    private T data;

    public BaseResponse(){

    }

    public BaseResponse(String message, Integer responseCode, T data) {
        this.message = message;
        this.responseCode = responseCode;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
