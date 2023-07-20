package com.rocketscience.rs.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SUPER_ADMIN,
    ADMIN,
    MENTOR,
    STUDENT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}