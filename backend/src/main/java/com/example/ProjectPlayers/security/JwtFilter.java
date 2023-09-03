package com.example.ProjectPlayers.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtFilter  extends OncePerRequestFilter {
	
	private JwtService jwtService;
	private CustomUserDetailService customUserDetailService;
	 @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	        final String header = request.getHeader("Authorization");
	        final String jwt;
	        final String username;
	        if (header == null || !header.startsWith("Bearer ")) {
	            filterChain.doFilter(request, response);
	            return;
	        }
	        jwt = header.substring(7);
	        username = jwtService.extractUsername(jwt);

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
	            if (jwtService.validateToken(jwt, userDetails)) {
	                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	            }
	        }
	        

	        filterChain.doFilter(request, response);
	    }

}
