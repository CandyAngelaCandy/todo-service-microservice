package com.thoughtworks.training.HuangYanyan.todoserice.security;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.UserRepository;
import com.thoughtworks.training.HuangYanyan.todoserice.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;

@Component
public class ToDoAuthFilter extends OncePerRequestFilter {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        try {

            String token = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (!StringUtils.isEmpty(token)) {
                User user = findUserByToken(token);

                SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(user, null
                                    , Collections.emptyList()));

                User userhh = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

                System.out.println(userhh.getId());
            }

        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.format("authentication failed: %s", e.getMessage()));
            return;
        }


        filterChain.doFilter(request, response);

    }

    private boolean validateToken(String token) {
        String[] userPass = token.split(":");
        String userName = userPass[0];
        String password = userPass[1];
        return userService.verify(userName, password);
    }


    public User findUserByToken(String token) {

        Integer userId = Jwts.parser()
                .setSigningKey("kitty".getBytes())
                .parseClaimsJws(token)
                .getBody()
                .get("userId", Integer.class);

        return userRepository.findOne(userId);
    }
}
