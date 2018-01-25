package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.models.User;

public interface UserService {

    void addUser(User user);
    void removeUser(User user);
    boolean authenticate(String username, String email);
    User findbyName(String username);
    User findbyEmail(String email);
}
