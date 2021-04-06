package com.duydoanx.film.exception;

public class ItemAddFailureException extends RuntimeException{

    public ItemAddFailureException() {
        super();
    }

    public ItemAddFailureException(String message) {
        super(message);
    }

    public ItemAddFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemAddFailureException(Throwable cause) {
        super(cause);
    }

    protected ItemAddFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
