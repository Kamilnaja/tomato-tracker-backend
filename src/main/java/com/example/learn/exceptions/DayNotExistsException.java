package com.example.learn.exceptions;

public class DayNotExistsException extends RuntimeException {
    public DayNotExistsException() {
    }

    public DayNotExistsException(String message) {
        super(message);
    }

    public DayNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DayNotExistsException(Throwable cause) {
        super(cause);
    }

    public DayNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
