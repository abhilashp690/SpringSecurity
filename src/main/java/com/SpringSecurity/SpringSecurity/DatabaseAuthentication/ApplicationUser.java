package com.SpringSecurity.SpringSecurity.DatabaseAuthentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class ApplicationUser implements UserDetails {

    Set<? extends GrantedAuthority> authorities;
    String password;
    String userName;
    Boolean isAccountNonExpired;
    Boolean isAccountNonLocked;
    Boolean isCredentialNonExpired;
    Boolean isAccountEnabled;


    public ApplicationUser(Set<? extends GrantedAuthority> authorities,
                           String password,
                           String userName,
                           Boolean isAccountNonExpired,
                           Boolean isAccountNonLocked,
                           Boolean isCredentialNonExpired,
                           Boolean isAccountEnabled) {
        this.authorities = authorities;
        this.password = password;
        this.userName = userName;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isAccountEnabled = isAccountEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isAccountEnabled;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "authorities=" + authorities +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialNonExpired=" + isCredentialNonExpired +
                ", isAccountEnabled=" + isAccountEnabled +
                '}';
    }
}
