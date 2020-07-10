package com.initiative.Initiative.util;

import com.initiative.Initiative.DTO.Principal;
import com.initiative.Initiative.config.Secured;
import com.initiative.Initiative.exceptions.AuthorizationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.initiative.Initiative.config.Secured)")
    public Object secureEndpoint(ProceedingJoinPoint pjp) throws Throwable {

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured ctrlrAnnotation = method.getAnnotation(Secured.class);

        List<String> allowedRoles = Arrays.asList(ctrlrAnnotation.allowedRoles());
        Principal principal = (Principal) request.getAttribute("principal");
        if(principal == null) {
            throw new AuthorizationException("An unauthenticated request was made to a protected endpoint.");
        }

        if(!allowedRoles.contains(principal.getRole().toString())) {
            throw new AuthorizationException("A forbidden request was made by " + principal.getUsername());
        }

        return pjp.proceed();
    }
}
