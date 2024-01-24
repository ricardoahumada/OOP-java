package com.banana.persistence;

import com.banana.models.Student;

import java.sql.SQLException;

public interface StudentRepositoryNewInf {
        public Student get(int idx) throws SQLException;

}
