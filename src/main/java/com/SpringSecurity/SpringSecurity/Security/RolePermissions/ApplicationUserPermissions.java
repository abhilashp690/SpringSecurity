package com.SpringSecurity.SpringSecurity.Security.RolePermissions;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public enum ApplicationUserPermissions {
    STUDENT_READ("student_read"),
    STUDENT_WRITE("student_write"),
    COURSE_READ("course_read"),
    COURSE_WRITE("course_write");

    private final String permission;

    ApplicationUserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
