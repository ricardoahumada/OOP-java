package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsRepositoryDataTest {

    @Autowired
    StudentsRepositoryData repoStudents;

    @Test
    @Transactional
    void getById() throws SQLException {
//        Student aStudent = repoStudents.getById(1L);
        Optional<Student> op = repoStudents.findById(1L);
        Student aStudent = op.get();
        System.out.println("aStudent:"+aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);

    }

    

}