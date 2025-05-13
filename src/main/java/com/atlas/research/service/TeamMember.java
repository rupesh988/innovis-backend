package com.atlas.research.service;

import jakarta.persistence.Embeddable;

@Embeddable
public class TeamMember {

    private String name;
    private String role;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
