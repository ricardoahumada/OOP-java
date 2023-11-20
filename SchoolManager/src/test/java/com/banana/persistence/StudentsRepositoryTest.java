package com.banana.persistence;

import com.banana.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsRepositoryTest {

    private ApplicationContext context;
    private StudentsRepositoryInf repoStudents;

    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        repoStudents = context.getBean(StudentsRepositoryInf.class);
    }

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(repoStudents);
    }


    @Test
    void getById() {
        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    void add() {
        Student newStd = new Student(6L, "El nuevo", "Apellido", 2);
        System.out.println(newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(6L);
        assertEquals(aStudent.getId(), 6L);
    }

    @Test
    void get() {
        Student aStudent = repoStudents.get(2);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 3L);
        assertNotNull(aStudent);
    }
}