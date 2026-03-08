package com.insurance.ai.common.exceptions;

public class AiIntegrationException extends RuntimeException {
    public AiIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
