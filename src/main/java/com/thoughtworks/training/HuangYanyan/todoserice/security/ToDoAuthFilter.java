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

    @Autowired
    private UserClient userClient;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        try {

            String token = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (!StringUtils.isEmpty(token)) {

//                RestTemplate restTemplate = new RestTemplate();
//                ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/verification",token,User.class);
//                User user = responseEntity.getBody();

                User user = userClient.verifyToken(token);

                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()));

            }

        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.format("authentication failed: %s", e.getMessage()));
            return;
        }


        filterChain.doFilter(request, response);

    }

//    public int findUserByToken(String token) {
//
//        int userId = Jwts.parser()
//                .setSigningKey("kitty".getBytes(Charset.forName("UTF-8")))
//                .parseClaimsJws(token)
//                .getBody()
//                .get("userId", Integer.class);
//
//        return userId;
//    }

}
