package com.initiative.Initiative.exceptions;

public class ResourceNotFoundException extends ControllerException {

    public ResourceNotFoundException() {
        super("Resource was not found!", 404);
    }

    public ResourceNotFoundException(String message) {
        super(message, 404);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause, 404);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause, 404);
    }
}
