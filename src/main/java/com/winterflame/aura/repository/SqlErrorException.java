package com.winterflame.aura.repository;

public class SqlErrorException extends RuntimeException {

    public SqlErrorException(String message) {
        super(message);
    }

    public SqlErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlErrorException(Throwable cause) {
        super(cause);
    }
}
