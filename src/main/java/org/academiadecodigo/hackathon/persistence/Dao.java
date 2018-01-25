package org.academiadecodigo.hackathon.persistence;

import java.util.List;

public interface Dao<T> {

    void saveOrUpdate(T type);
    void delete(T type);
    List<T> findAll();
    int count();
    T findById(Integer id);
}
