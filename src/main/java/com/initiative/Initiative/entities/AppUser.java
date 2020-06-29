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
    private String username;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "appUser")
    private List<Event> events;

    public AppUser(int id, @NotBlank String username, @NotBlank String password, List<Event> events) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.events = events;
    }

    public AppUser(@NotBlank String username, @NotBlank String password, List<Event> events) {
        this.username = username;
        this.password = password;
        this.events = events;
    }
}
