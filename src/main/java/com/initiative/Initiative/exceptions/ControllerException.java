package com.initiative.Initiative.exceptions;

public class ControllerException extends RuntimeException {

    public int status;

    public ControllerException(int status) {
        this.status = status;
    }

    public ControllerException(String message, int status) {
        super(message);
        this.status = status;
    }

    public ControllerException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public ControllerException(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
