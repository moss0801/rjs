package com.moss.rjs.code;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorCodeManager {
    private Map<Integer, ErrorCode<?>> errorCodeMap = new HashMap<Integer, ErrorCode<?>>();
    
    public void addErrorCode(Class<? extends ErrorCode<?>> errorCodeClass) {
        Assert.notNull(errorCodeClass, "### addErrorCode(): errorCodeClass can not be null.");
        
        // 정의된 ErrorCode가 있는지 확인
        Object[] enumConstants = errorCodeClass.getEnumConstants();
        if (enumConstants.length == 0)
            return;
        
        // errorCodeMap에 ErrorCode 등록
        for (Object value : errorCodeClass.getEnumConstants()) {
            ErrorCode<?> errorCode = (ErrorCode<?>)value;
            // 등록여부 확인
            int code = errorCode.getCode();
            if (errorCodeMap.containsKey(errorCode.getCode())) {
                ErrorCode<?> addedErrorCode = errorCodeMap.get(code);
                log.error("### errorCode is already added. code={}, addedErrorCode={}, failErrorCode={}",
                        code, addedErrorCode.getClass().getSimpleName() + "." + addedErrorCode.name(), errorCode.getClass().getSimpleName() + "." + errorCode.name());
            } else {
                errorCodeMap.put(errorCode.getCode(), errorCode);
            }
        }
    }
    
    public ErrorCode<?> getErrorCode(int code) {
        return errorCodeMap.get(code);
    }
}
