package com.millan.challenge.solution.service;


import com.millan.challenge.solution.exception.FailedToLoginException;
import com.millan.challenge.solution.exception.JwtAuthenticationException;
import com.millan.challenge.solution.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class UserAuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    // placeholder for code which could eventually be an authentication to a server via db or other auth service
    public String authenticateUser(String username, String password) throws FailedToLoginException {
        boolean isAuthenticated = false;
        if (username.equals("testuser1") && password.equals("test123")) {
            isAuthenticated = true;
        } else if (username.equals("jp") && password.equals("test123")) {
            isAuthenticated = true;
        }

        if (isAuthenticated) {
            try {
                return jwtService.generateToken(username);
            } catch (URISyntaxException | IOException e) {
                throw new FailedToLoginException(e.getMessage());
            }
        }
        throw new FailedToLoginException("unable to authenticate user " + username);
    }

    public User authenticateToken(String jwtToken) throws JwtAuthenticationException {

        try {
            String username = jwtService.verifyToken(jwtToken);
            List<String> userRoles = userService.getUserRoles(username);

            User user = new User();
            user.setUsername(username);
            user.setUserRoles(userRoles);
            return user;
        } catch (IOException | URISyntaxException e) {
            throw new JwtAuthenticationException(e.getMessage(), e);
        }
    }

}
