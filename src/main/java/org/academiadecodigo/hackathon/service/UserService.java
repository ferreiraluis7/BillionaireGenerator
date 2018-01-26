package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;

public interface UserService {

    void addUser(User user);
    void removeUser(User user);
    boolean authenticate(String username, String password);
    User findbyName(String username);
    User findbyEmail(String email);
    void setCurrentUser(User currentUser);
}
