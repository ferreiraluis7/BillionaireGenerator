package org.academiadecodigo.hackathon.persistence;

public interface UserDao {

    void saveOrUpdate(User user);
    void delete(User user);
    User findByName(String username);
    User findByEmail(String email);
}
