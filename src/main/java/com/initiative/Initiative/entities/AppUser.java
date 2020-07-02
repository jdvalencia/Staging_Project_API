package com.initiative.Initiative.entities;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    private String lastName;

    @Column(nullable = false)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "appUser")
    private List<Event> events;

    @Enumerated(EnumType.STRING)
    private Role role;

    public AppUser(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String email, @NotBlank String username, @NotBlank String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        if(role == null){
            this.role = Role.USER;
        }
        else{
            this.role = role;
        }

    }

    public AppUser(int id, @NotBlank String username, @NotBlank String password, List<Event> events, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.events = events;
        this.role = role;
    }

    public AppUser(@NotBlank String username, @NotBlank String password, List<Event> events, Role role) {
        this.username = username;
        this.password = password;
        this.events = events;
        this.role = role;
    }

    public AppUser(@NotBlank String username, @NotBlank String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
