package com.initiative.Initiative.DTO;

import com.initiative.Initiative.entities.AppUser;
import com.initiative.Initiative.entities.Role;

import java.util.Objects;

public class Principal {

    private int id;

    private String username;

    private Role role;

    public Principal() {
    }

    public Principal(AppUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
    }

    public Principal(int id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Principal principal = (Principal) o;
        return id == principal.id &&
                Objects.equals(username, principal.username) &&
                Objects.equals(role, principal.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role);
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
