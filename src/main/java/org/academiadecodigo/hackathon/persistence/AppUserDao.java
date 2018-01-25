package org.academiadecodigo.hackathon.persistence;

import org.academiadecodigo.hackathon.models.User;

import javax.persistence.NoResultException;

public class AppUserDao extends JpaDao<User> implements UserDao<User> {

    public AppUserDao(){
        super(User.class);
    }

    @Override
    public User findByName(String username) {
         try {

             return getEm().find(User.class,username);

         } catch (NoResultException e) {

             return null;
         }
    }

    @Override
    public User findByEmail(String email) {
        try {

            return getEm().find(User.class,email);

        } catch (NoResultException e) {

            return null;
        }
    }
}
