package com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT;

import com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT.model.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JWTAuthenticationProvider extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationProvider(AuthenticationManager authenticationManager) {
         this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserData userDetails = new ObjectMapper().readValue(request.getInputStream(),
                    UserData.class);
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),userDetails.getPassword())
            );
            return auth;
        } catch(IOException ie){
            throw new RuntimeException(ie);
        }
        catch (BadCredentialsException ex) {
            System.out.println("User authentication failed....");
        }
        return null;
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("Authentication success :- ");
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(SignatureAlgorithm.HS256 , "someSecureKey")
                .compact();

        response.setHeader("Authorization","Bearer " + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        UserData userDetails = new ObjectMapper().readValue(request.getInputStream(),
                UserData.class);
        System.out.println("Unsuccessful Authentication request attempted from :- " + userDetails);
    }
}
