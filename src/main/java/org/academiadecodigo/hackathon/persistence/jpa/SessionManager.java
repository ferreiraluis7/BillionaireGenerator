package org.academiadecodigo.hackathon.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class SessionManager {

    @PersistenceUnit(name = "unit")
    private EntityManagerFactory emf ;
    private EntityManager em;


    public void startSession(){
        if(em == null){
            em = emf.createEntityManager();
        }
    }

    public void stopSession(){
        if(em != null){
            em.close();
        }
        em = null;
    }

    public EntityManager getCurrentSession(){
        startSession();
        return em;
    }


}
