package org.academiadecodigo.hackathon.persistence;

public interface UserDao<User> extends Dao<User> {


    User findByName(String username);
    User findByEmail(String email);
}
