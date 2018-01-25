package org.academiadecodigo.hackathon.service;

public interface UserService {

    void addUser(User user);
    void removeUser(User user);
    boolean authentication(String username, String email);
    User findByname(String username);
    User findByEmail(String email);

}
