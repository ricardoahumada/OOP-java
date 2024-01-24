package com.banana.persistence;

import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;

public interface StudentRepositoryNewJPAInf extends JpaRepository<Student, Long>, StudentRepositoryNewInf {

}
