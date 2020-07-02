package com.initiative.Initiative.repositories;

import com.initiative.Initiative.entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    public AppUser findAppUserByUsernameAndPassword(String username, String password);
}
