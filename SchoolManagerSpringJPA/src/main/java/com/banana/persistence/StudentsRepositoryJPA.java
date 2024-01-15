package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Setter
@Getter
@Repository
public class StudentsRepositoryJPA implements StudentsRepositoryInf {

    private String urlConn;

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(Student estudiante) {
        em.persist(estudiante);
    }

    @Override
    @Transactional
    public Student update(Student estudiante) {
        if (estudiante.isValid()) {
            Student aStd = em.find(Student.class, estudiante.getId());
            aStd.setNombre(estudiante.getNombre());
            aStd.setApellido(estudiante.getApellido());
            return aStd;
        } else {
            return null;
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
