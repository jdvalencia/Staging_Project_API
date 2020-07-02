package com.initiative.Initiative.controllers;

import com.initiative.Initiative.DTO.Credentials;
import com.initiative.Initiative.DTO.Principal;
import com.initiative.Initiative.config.JwtConfig;
import com.initiative.Initiative.config.TokenGenerator;
import com.initiative.Initiative.entities.AppUser;
import com.initiative.Initiative.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser user) {
        return userService.saveAppUser(user);
    }

    @PostMapping("/auth")
    public Principal authUser(@RequestBody Credentials creds, HttpServletResponse resp) {

        Principal payload = userService.findAppUserByCredentials(creds);
        resp.setHeader(JwtConfig.HEADER, TokenGenerator.createJwt(payload));
        return payload;
    }
}
