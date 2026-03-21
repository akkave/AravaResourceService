package com.arava.os.rest.exceptions;

import com.arava.AravaResourceService.exceptions.AravaBaseException;

/**
 * Exception in case of retryable server errors
 */
public class AravaSDKClientException extends AravaBaseException  {

    public AravaSDKClientException(String message, Throwable cause) {
        super(message, cause, false);
    }
}
