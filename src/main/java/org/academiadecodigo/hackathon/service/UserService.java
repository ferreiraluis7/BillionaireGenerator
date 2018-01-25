package org.academiadecodigo.hackathon.service;

public interface UserService {

    void addUser(User user);
    void removeUser(User user);
    boolean authenticate(String username, String email);
    User findbyName(String username);
    User findbyEmail(String email);
}
