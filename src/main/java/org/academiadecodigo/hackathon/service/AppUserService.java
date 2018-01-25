package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.persistence.UserDao;

public class AppUserService implements UserService {

    private UserDao<User> dao;

    public void addUser(User user) {
        dao.saveOrUpdate(user);
    }

    public void removeUser(User user) {
        dao.delete(user);
    }

    public boolean authenticate(String username, String email) {
        return findbyName(username)!= null && findbyEmail(email) != null;
    }

    public User findbyName(String username) {
        return dao.findByName(username);
    }

    public User findbyEmail(String email) {
        return dao.findByEmail(email);
    }
}
