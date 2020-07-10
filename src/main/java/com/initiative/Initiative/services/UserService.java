package com.initiative.Initiative.services;

import com.initiative.Initiative.DTO.Credentials;
import com.initiative.Initiative.DTO.Principal;
import com.initiative.Initiative.entities.AppUser;
import com.initiative.Initiative.entities.Role;
import com.initiative.Initiative.exceptions.BadRequestException;
import com.initiative.Initiative.exceptions.ResourceNotFoundException;
import com.initiative.Initiative.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

@Service
public class UserService {

    @Autowired
    private AppUserRepository userRepository;

    public Principal findAppUserByCredentials(Credentials creds) {
        AppUser user;
        try {
            user = userRepository.findAppUserByUsernameAndPassword(creds.getUsername(), creds.getPassword());
        }
        catch (NoResultException e) {
            throw new ResourceNotFoundException("No user found", e);
        }
        return new Principal(user);
    }

    public Principal saveAppUser(AppUser user) {
        AppUser persisted;
        try {
            if(user.getRole() == null) {
                user.setRole(Role.USER);
            }
             persisted = userRepository.save(user);
        }
        catch (PersistenceException e) {
            throw new BadRequestException();
        }
        return new Principal(persisted);

    }
}
