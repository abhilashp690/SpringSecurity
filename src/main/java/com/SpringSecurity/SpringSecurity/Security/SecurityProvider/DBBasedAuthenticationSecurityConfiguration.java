package com.SpringSecurity.SpringSecurity.Security.SecurityProvider;

import com.SpringSecurity.SpringSecurity.DatabaseAuthentication.ApplicationUserService;
import com.SpringSecurity.SpringSecurity.Security.PasswordEncoderConfig;
import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserPermissions;
import com.SpringSecurity.SpringSecurity.Security.RolePermissions.ApplicationUserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.concurrent.TimeUnit;

//@Configuration
//@EnableWebSecurity
public class DBBasedAuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {


//    private PasswordEncoderConfig passwordEncoderConfig;
//
//    private ApplicationUserService userService;
//
//    @Autowired
//    public DBBasedAuthenticationSecurityConfiguration(PasswordEncoderConfig passwordEncoderConfig, ApplicationUserService userService) {
//        this.passwordEncoderConfig = passwordEncoderConfig;
//        this.userService = userService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("DAO Authentication Provider Mechanism ....");
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/","index" , "/css/*" , "/js/*")
//                .permitAll()
//                .antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())
//                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ApplicationUserRoles.ADMIN.name(),ApplicationUserRoles.ADMIN_TRAINEE.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                //.httpBasic();     // This is useful for http Basic Authentication Part
//
//
//                // This is useful for form Login Part.In form login,spring security returns a cookie jsession Id that is valid for specific life only.
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/loggedin")
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//                .key("Abhilash")
//                .and()
//                .logout()
//                .clearAuthentication(true)
//                .deleteCookies("JSESSIONID","remember-me")
//                .invalidateHttpSession(true)
//                .logoutSuccessUrl("/login");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(passwordEncoderConfig.passwordEncoder());
//        authenticationProvider.setUserDetailsService(userService);
//        return authenticationProvider;
//    }

}
