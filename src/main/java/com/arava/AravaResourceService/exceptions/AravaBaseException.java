package com.arava.AravaResourceService.exceptions;

public abstract class AravaBaseException extends RuntimeException {

    private final boolean isRetryable;

    public AravaBaseException(String message, Throwable cause, boolean isRetryable) {
        super(message, cause);
        this.isRetryable = isRetryable;
    }
}
