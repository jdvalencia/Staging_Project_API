package com.initiative.Initiative.exceptions;

public class AuthorizationException extends ControllerException {

    public AuthorizationException() {
        super("You do not have permission to perform that action.", 403);
    }

    public AuthorizationException(String message) {
        super(message, 403);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause, 403);
    }

    public AuthorizationException(Throwable cause) {
        super(cause, 403);
    }
}
