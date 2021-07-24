package com.SpringSecurity.SpringSecurity.DatabaseAuthentication;

public interface ApplicationUserDao {
    public ApplicationUser validateUser(String userName);
}
