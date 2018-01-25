package org.academiadecodigo.hackathon.persistence;

public class AppUserDao extends JpaDao<User> implements UserDao<User> {

    public AppUserDao(){
        super(User.class);
    }

}
