package com.SpringSecurity.SpringSecurity.Security.RolePermissions;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,
            ApplicationUserPermissions.COURSE_WRITE,
            ApplicationUserPermissions.STUDENT_READ,
            ApplicationUserPermissions.STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,
            ApplicationUserPermissions.STUDENT_READ));

    private final Set<ApplicationUserPermissions> userPermissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public Set<ApplicationUserPermissions> getUserPermissions() {
        return userPermissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getUserPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())
        ).collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
