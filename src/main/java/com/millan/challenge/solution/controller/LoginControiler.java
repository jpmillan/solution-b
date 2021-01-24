package com.millan.challenge.solution.controller;

import com.millan.challenge.solution.exception.FailedToLoginException;
import com.millan.challenge.solution.model.Authentication;
import com.millan.challenge.solution.model.UserCredentials;
import com.millan.challenge.solution.service.UserAuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
public class LoginControiler {

    @Autowired
    private UserAuthenticationService authenticationService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Authentication> userLogin(@RequestBody UserCredentials userCredentials) {

        if (userCredentials == null || (userCredentials.getUsername() == null || userCredentials.getPassword() == null)) {
            log.error("Missing login credentials");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        String token = null;
        try {
            token = authenticationService.authenticateUser(userCredentials.getUsername(), userCredentials.getPassword());
        } catch (FailedToLoginException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }


        if (token != null) {
            Authentication authenticationResponse = new Authentication();
            authenticationResponse.setUsername(userCredentials.getUsername());
            authenticationResponse.setToken(token);
            return ok(authenticationResponse);
        }
        log.error(" unable to authenticate user [%s] "+ userCredentials.getUsername());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
