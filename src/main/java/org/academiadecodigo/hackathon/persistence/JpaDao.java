package org.academiadecodigo.hackathon.persistence;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class JpaDao<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager em;
    private Class<T> t;

    public JpaDao(Class<T> t) {
        this.t = t;
    }

    public void saveOrUpdate(T type) {
        em.merge(type);
    }

    public void delete(T type) {
        em.remove(type);
    }

    public List<T> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(t);

        Root<T> root = query.from(t);
        query.select(root);

        return new ArrayList<T>(em.createQuery(query).getResultList());
    }

    public int count() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(t);

        Root<T> root = query.from(t);
        query.select(root);

        return em.createQuery(query).getResultList().size();
    }

    public T findById(Integer id) {

        try {

            CriteriaBuilder builder = getEm().getCriteriaBuilder();

            CriteriaQuery<T> criteriaQuery = builder.createQuery(t);

            Root<T> root = criteriaQuery.from(t);

            criteriaQuery.select(root);

            criteriaQuery.where(builder.equal(root.get("id"), id));

            return getEm().createQuery(criteriaQuery).getSingleResult();

        } catch (NoResultException e) {

            return null;
        }
    }

    public EntityManager getEm() {
        return em;
    }
}
