package com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT.filter;


import com.SpringSecurity.SpringSecurity.DatabaseAuthentication.ApplicationUserService;
import com.SpringSecurity.SpringSecurity.Security.SecurityProvider.JWT.JwtValidator.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;
    private ApplicationUserService userService;

    public JwtFilter(JwtUtil jwtUtil , ApplicationUserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = httpServletRequest.getHeader("Authorization");
        System.out.println("Header Details :- " + authHeader);
        if(authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        try {
            String token = authHeader.substring(7);
            String userName = jwtUtil.extractUsername(token);
            UserDetails userDetails = userService.loadUserByUsername(userName);
            if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                        userName,
                        null,
                        userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(userAuth);
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }
        } catch (Exception e){
            System.out.println("JWT Exception Caught ......" + e);
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
    }
}
