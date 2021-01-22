package com.millan.challenge.solution.controller;

import com.millan.challenge.solution.exception.FailedToLoginException;
import com.millan.challenge.solution.model.Authentication;
import com.millan.challenge.solution.model.UserCredentials;
import com.millan.challenge.solution.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginControiler {

    @Autowired
    private UserAuthenticationService authenticationService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Authentication userLogin(@RequestBody UserCredentials userCredentials) throws FailedToLoginException {

        if (userCredentials == null || (userCredentials.getUsername() == null || userCredentials.getPassword() == null)) {
            throw new FailedToLoginException("Missing login credentials ");
        }

        String token = authenticationService.authenticateUser(userCredentials.getUsername(), userCredentials.getPassword());

        if (token != null) {
            Authentication authenticationResponse = new Authentication();
            authenticationResponse.setUsername(userCredentials.getUsername());
            authenticationResponse.setToken(token);
            return authenticationResponse;
        }
        throw new FailedToLoginException(String.format(" unable to authenticate user [%s] ", userCredentials.getUsername()));
    }

}
