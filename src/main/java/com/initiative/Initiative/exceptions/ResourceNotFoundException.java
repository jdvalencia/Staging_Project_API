package com.initiative.Initiative.exceptions;

public class RequestNotFoundException extends ControllerException {

    public RequestNotFoundException() {
        super("An invalid request was made!", 400);
    }

    public RequestNotFoundException(String message) {
        super(message, 400);
    }

    public RequestNotFoundException(String message, Throwable cause) {
        super(message, cause, 400);
    }

    public RequestNotFoundException(Throwable cause) {
        super(cause, 400);
    }
}
