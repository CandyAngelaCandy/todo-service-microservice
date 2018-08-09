package com.thoughtworks.training.huangyanyan.todoserice.security;

import com.thoughtworks.training.huangyanyan.todoserice.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
public class ToDoAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        log.info("incoming request {}", request.getServletPath());

        String internalToken = request.getHeader(HttpHeaders.AUTHORIZATION);


        try {

            //String internalToken = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (!StringUtils.isEmpty(internalToken)) {

                int userID = Integer.parseInt(internalToken.split(":")[0]);
                String userName = internalToken.split(":")[1];

                User user = new User(userID, userName);

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
