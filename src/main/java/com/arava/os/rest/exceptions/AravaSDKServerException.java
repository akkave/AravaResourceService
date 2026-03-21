package com.arava.os.rest.exceptions;

import com.arava.AravaResourceService.exceptions.AravaBaseException;

/**
 * Exception in case of retryable server errors
 */
public class AravaSDKServerException extends AravaBaseException {
    public AravaSDKServerException(String message, Throwable cause) {
        super(message, cause, true);
    }
}
