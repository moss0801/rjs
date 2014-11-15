package com.moss.rjs.code;

import javax.servlet.http.HttpServletResponse;

public enum TicketErrorCode implements ErrorCode<TicketErrorCode>{
    CCC(1000),
    DDD(1001),
    DDDE(1)
    ;
    
    TicketErrorCode(int code) {
        this.code = code;
    }
    
    int code;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int statusCode() {
        return HttpServletResponse.SC_INTERNAL_SERVER_ERROR; // 500
    }

}
