package com.moss.rjs.code;

/**
 * 에러를 관리하는 Enum을 위한 interface<br />
 * @author moss
 *
 */
public interface ErrorCode<T> {
    
    int getCode();
    
    String name();
    
    int statusCode();
}
