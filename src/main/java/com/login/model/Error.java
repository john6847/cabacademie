package com.login.model;

import lombok.Data;

/**
 * Created by Dany on 27/05/2018.
 */

public class Error {

    private String reason;

    private String message;

    public Error(String reason, String message) {
        this.reason = reason;
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
