package com.SpringSecurity.SpringSecurity.Security.SecurityProvider;

import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserPermissions;
import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserRoles;
import jdk.jfr.Enabled;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class BasicAuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*")
//                .permitAll()
//                .antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())
//                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRoles.ADMIN.name(), ApplicationUserRoles.ADMIN_TRAINEE.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
}
