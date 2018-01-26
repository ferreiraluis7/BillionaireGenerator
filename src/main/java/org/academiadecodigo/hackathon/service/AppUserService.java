package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.persistence.UserDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AppUserService implements UserService {

    private User currentUser;

    private UserDao<User> userDao;

    public AppUserService(UserDao userDao){

        this.userDao = userDao;

    }

    @Override
    public void addUser(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public void removeUser(User user) {
        userDao.delete(user);
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = findbyName(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public User findbyName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public User findbyEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

}
