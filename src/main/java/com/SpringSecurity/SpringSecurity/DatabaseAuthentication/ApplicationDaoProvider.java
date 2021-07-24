package com.SpringSecurity.SpringSecurity.DatabaseAuthentication;

import com.SpringSecurity.SpringSecurity.Security.PasswordEncoderConfig;
import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Repository("inMemory")
public class ApplicationDaoProvider implements ApplicationUserDao{

    private PasswordEncoder passwordEncoderConfig;

    List<ApplicationUser> applicationUsers;

    @Autowired
    public ApplicationDaoProvider(PasswordEncoder passwordEncoderConfig) {
        this.passwordEncoderConfig = passwordEncoderConfig;
        applicationUsers = Arrays.asList(
                new ApplicationUser(ApplicationUserRoles.ADMIN.getAuthorities(),
                        passwordEncoderConfig.encode("portal123"),
                        "dbadmin",
                        true,true,true,true),

                new ApplicationUser(ApplicationUserRoles.STUDENT.getAuthorities(),
                        passwordEncoderConfig.encode("portal123"),
                        "dbstudent",
                        true,true,true,true),

                new ApplicationUser(ApplicationUserRoles.ADMIN_TRAINEE.getAuthorities(),
                        passwordEncoderConfig.encode("portal123"),
                        "dbtrainee", true,true, true,true)
        );
    }


    @Override
    public ApplicationUser validateUser(String userName) {
        System.out.println("Received the request to validate the user");
        return applicationUsers.stream().filter(appUser -> appUser.getUsername().equals(userName)).findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with name - " + userName + "does not exists")
                );
    }
}
