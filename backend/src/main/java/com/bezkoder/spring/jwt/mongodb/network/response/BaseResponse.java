package com.bezkoder.spring.jwt.mongodb.network.response;

public class BaseResponse {

    private Boolean status;
    private String message;
    private Object data;

    public BaseResponse(String message,Boolean status ){
        this.status = status;
        this.message = message;
    }


    public BaseResponse(String message,Boolean status,Object data ){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
