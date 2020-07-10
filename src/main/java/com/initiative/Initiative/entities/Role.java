package com.initiative.Initiative.entities;

public enum Role {

    ADMIN("Admin"), DEV("Dev"), USER("User"), LOCKED("Locked");

    private final String roleName;

    public String getRoleName() {
        return roleName;
    }

    Role(String roleName) {
        this.roleName = roleName;
    }

    public static Role getByName(String name) {
        for (Role role: Role.values()) {
            if(role.roleName.equalsIgnoreCase(name)) {
                return role;
            }
        }
        return LOCKED;
    }
}
