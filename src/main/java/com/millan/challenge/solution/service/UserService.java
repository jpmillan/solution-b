package com.millan.challenge.solution.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    // placeholder for code which could eventually be a db check for roles based on username
    public List<String> getUserRoles(String username) {

        List<String> userRoles = new ArrayList<String>();

        if (username != null && username.equals("testuser1")) {
            return Arrays.asList("ROLE_USER");
        }  else if (username != null && username.equals("jp")) {
            return Arrays.asList("ROLE_USER");
        }
        return userRoles;
    }


}
