package com.SpringSecurity.SpringSecurity.DatabaseAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserDao userService;

    @Autowired
    public ApplicationUserService(@Qualifier("inMemory") ApplicationUserDao userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ApplicationUser user = userService.validateUser(userName);
        System.out.println("User Information is :- " + user);
        return user;
    }
}
