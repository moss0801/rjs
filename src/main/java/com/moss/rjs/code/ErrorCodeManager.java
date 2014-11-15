package com.moss.rjs.code;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorCodeManager {
    private Map<Integer, ErrorCode<?>> errorCodeMap = new HashMap<Integer, ErrorCode<?>>();
    
    public void addErrorCode(Class<? extends ErrorCode<?>> errorCodeClass) {
        // errorCoeClass null 체크
        if (null == errorCodeClass) {
            log.error("### errorCodeClass can not be null.");
            return;
        }
        // errorCoeClass enum 여부 체크
        if (!errorCodeClass.isEnum()) {
            log.error("### class is not enum, errorCodeClass={}", errorCodeClass.getName());
            return;
        }
            
        Object[] enumConstants = errorCodeClass.getEnumConstants();
        if (enumConstants.length == 0)
            return;
        
        for (Object value : errorCodeClass.getEnumConstants()) {
            ErrorCode<?> errorCode = (ErrorCode<?>)value;
            errorCodeMap.put(errorCode.getCode(), errorCode);
        }
    }
    
    public ErrorCode<?> getErrorCode(int code) {
        return errorCodeMap.get(code);
    }
}
