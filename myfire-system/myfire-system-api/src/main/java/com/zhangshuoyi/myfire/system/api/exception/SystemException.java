package com.zhangshuoyi.myfire.system.api.exception;

/**
 * 系统模块异常
 */
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

}
