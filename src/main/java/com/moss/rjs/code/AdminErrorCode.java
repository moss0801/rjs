package com.moss.rjs.code;

import javax.servlet.http.HttpServletResponse;


public enum AdminErrorCode implements ErrorCode<AdminErrorCode> {
    AAA(1, HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    BBB(2, HttpServletResponse.SC_BAD_REQUEST),
    ;
    
    AdminErrorCode(int code, int statusCode) {
        this.code = code;
        this.statusCode = statusCode;
    }
    
    int code;
    int statusCode;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int statusCode() {
        return statusCode;
    }

}
