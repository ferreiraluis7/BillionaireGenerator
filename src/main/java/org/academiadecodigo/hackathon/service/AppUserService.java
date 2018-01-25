package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.persistence.UserDao;

public class AppUserService implements UserService {

    private User currentUser;

    private UserDao<User> userDao;

    public AppUserService(UserDao userDao){

        this.userDao = userDao;

    }

    public void addUser(User user) {
        userDao.saveOrUpdate(user);
    }

    public void removeUser(User user) {
        userDao.delete(user);
    }

    public boolean authenticate(String username, String password) {
        User user = findbyName(username);
        return user != null && user.getPassword().equals(password);
    }

    public User findbyName(String username) {
        return userDao.findByName(username);
    }

    public User findbyEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
