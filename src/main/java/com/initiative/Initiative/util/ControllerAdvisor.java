package com.initiative.Initiative.util;

import com.initiative.Initiative.DTO.ErrorResponse;
import com.initiative.Initiative.exceptions.AuthorizationException;
import com.initiative.Initiative.exceptions.BadRequestException;
import com.initiative.Initiative.exceptions.ControllerException;
import com.initiative.Initiative.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Component
@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler
    public ErrorResponse handleException(ControllerException e, HttpServletResponse resp) {
        ErrorResponse err = new ErrorResponse(e);

        if(e instanceof BadRequestException) {
            resp.setStatus(400);
        }
        else if(e instanceof ResourceNotFoundException) {
            resp.setStatus(404);
        }
        else if(e instanceof AuthorizationException) {
            resp.setStatus(403);
        }

        return err;
    }
}
