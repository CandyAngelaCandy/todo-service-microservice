package com.thoughtworks.training.huangyanyan.todoserice.security;

import com.thoughtworks.training.huangyanyan.todoserice.client.UserClient;
import com.thoughtworks.training.huangyanyan.todoserice.dto.User;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

@Component
public class ToDoAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String internalToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        try {

            //String internalToken = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (!StringUtils.isEmpty(internalToken)) {

                int userID = Integer.parseInt(internalToken.split(":")[0]);
                String userName = internalToken.split(":")[1];

                User user = new User(userID,userName);

                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()));

            }

        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.format("authentication failed: %s", e.getMessage()));
            return;
        }


        filterChain.doFilter(request, response);

    }

}
