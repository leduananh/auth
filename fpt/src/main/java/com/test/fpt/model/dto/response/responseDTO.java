package com.test.fpt.model.dto.response;

public class responseDTO {
    Boolean error;
    String errorMsg;
    Integer status;
    Object data;


    public responseDTO(Boolean error, String errorMsg, Integer status) {
        this.error = error;
        this.errorMsg = errorMsg;
        this.status = status;
    }

    public responseDTO(Boolean error, String errorMsg, Integer status, Object data) {
        this.error = error;
        this.errorMsg = errorMsg;
        this.status = status;
        this.data = data;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
