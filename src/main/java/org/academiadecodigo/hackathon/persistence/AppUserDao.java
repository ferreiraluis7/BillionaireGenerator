package org.academiadecodigo.hackathon.persistence;

import org.academiadecodigo.hackathon.model.User;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AppUserDao extends JpaDao<User> implements UserDao<User> {



    public AppUserDao(){
        super(User.class);
    }

    @Override
    public User findByName(String username) {
         try {

             CriteriaBuilder builder = getEm().getCriteriaBuilder();

             CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

             Root<User> root = criteriaQuery.from(User.class);

             criteriaQuery.select(root);

             criteriaQuery.where(builder.equal(root.get("username"), username));

             return getEm().createQuery(criteriaQuery).getSingleResult();

         } catch (NoResultException e) {

             return null;
         }
    }

    @Override
    public User findByEmail(String email) {
        try {

            CriteriaBuilder builder = getEm().getCriteriaBuilder();

            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

            Root<User> root = criteriaQuery.from(User.class);

            criteriaQuery.select(root);

            criteriaQuery.where(builder.equal(root.get("email"), email));

            return getEm().createQuery(criteriaQuery).getSingleResult();

        } catch (NoResultException e) {

            return null;
        }
    }


}
