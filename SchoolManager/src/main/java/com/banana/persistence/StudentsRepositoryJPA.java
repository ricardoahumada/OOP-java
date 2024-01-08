package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;

@Setter
@Getter
public class StudentsRepositoryJPA implements StudentsRepositoryInf{

    private String urlConn;

    private EntityManager em;

    @Override
    public void add(Student estudiante) {
        em.getTransaction().begin();
        if(estudiante.isValid()) {
            em.persist(estudiante);
            em.getTransaction().commit();
        }else {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Student get(int idx) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public String getUrlConn() {
        return null;
    }
}
