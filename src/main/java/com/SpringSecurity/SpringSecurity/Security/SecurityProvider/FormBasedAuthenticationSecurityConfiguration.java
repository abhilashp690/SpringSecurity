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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.concurrent.TimeUnit;

//@Configuration
//@EnableWebSecurity
public class FormBasedAuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private PasswordEncoderConfig passwordEncoderConfig;
//
//
//    @Autowired
//    public FormBasedAuthenticationSecurityConfiguration(PasswordEncoderConfig passwordEncoderConfig) {
//        this.passwordEncoderConfig = passwordEncoderConfig;
//        System.out.println("In order to use form based authentication,comment @Service annotation of ApplicationUserService");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("***************Form Based Authentication request ");
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
//
//                // This is useful for form Login Part.In form login,spring security returns a cookie jsession Id that is valid for specific life only.
//                .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .defaultSuccessUrl("/loggedin")
//                .and()
//                .rememberMe()
//                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
//                    .key("Abhilash")
//                .and()
//                .logout()
//                    .clearAuthentication(true)
//                    .deleteCookies("JSESSIONID","remember-me")
//                    .invalidateHttpSession(true)
//                    .logoutSuccessUrl("/login");
//    }
//
//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//       UserDetails adminUser = User.builder()
//               .username("formadmin")
//               .password(passwordEncoderConfig.passwordEncoder().
//                       encode("portal123"))
//               .authorities(ApplicationUserRoles.ADMIN.getAuthorities())
//               .build();
//
//       UserDetails studentUser = User.builder()
//                .username("formstudent")
//                .password(passwordEncoderConfig.passwordEncoder().
//                        encode("portal123"))
//                .authorities(ApplicationUserRoles.STUDENT.getAuthorities())
//                .build();
//
//        UserDetails adminTraineeUser = User.builder()
//                .username("formtrainee")
//                .password(passwordEncoderConfig.passwordEncoder().
//                        encode("portal123"))
//                .authorities(ApplicationUserRoles.ADMIN_TRAINEE.getAuthorities())
//                .build();
//
//       return new InMemoryUserDetailsManager(adminUser,studentUser,adminTraineeUser);
//    }

}
