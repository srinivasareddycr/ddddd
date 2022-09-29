package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String authHeader = httpRequest.getHeader("authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer")) {
			throw new ServletException("Missing or invalid authentication header");
		}
		String jwtToken = authHeader.substring(7);

		System.out.println(authHeader);

		Claims claims = Jwts.parser().setSigningKey("my secret sign").parseClaimsJws(jwtToken).getBody();

		httpRequest.setAttribute("username", claims);

		chain.doFilter(request, response);
	}

}
