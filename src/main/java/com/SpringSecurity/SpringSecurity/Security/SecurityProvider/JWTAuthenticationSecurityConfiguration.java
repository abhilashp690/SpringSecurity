package com.SpringSecurity.SpringSecurity.Security.SecurityProvider;

import com.SpringSecurity.SpringSecurity.DatabaseAuthentication.ApplicationUserService;
import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserPermissions;
import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserRoles;
import com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT.JWTAuthenticationProvider;
import com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT.JwtValidator.JwtUtil;
import com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class JWTAuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("JWT Authentication Provider Mechanism ....");

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JWTAuthenticationProvider(authenticationManager()))
                .addFilterBefore(new JwtFilter(new JwtUtil(),userService) , JWTAuthenticationProvider.class)
                .authorizeRequests()
                .antMatchers("/","index" , "/css/*" , "/js/*")
                .permitAll()
                .antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())
                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ApplicationUserRoles.ADMIN.name(),ApplicationUserRoles.ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated();
    }
}
