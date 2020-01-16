package com.mycompany.web.mvc.model;

import java.util.Arrays;
import java.util.List;

public class User {
    private static List<String> users = Arrays.asList("John", "Mary", "Tom", "Jane");
    
    public boolean isMember(String username) {
        return users.stream().anyMatch(user -> user.equalsIgnoreCase(username));
    }
    
}
