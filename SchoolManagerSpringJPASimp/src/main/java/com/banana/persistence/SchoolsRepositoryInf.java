package com.banana.persistence;

import com.banana.models.School;

import java.sql.SQLException;

public interface SchoolsRepositoryInf {
    public School add(School escuela) throws SQLException;

    public School update(School escuela) throws SQLException;

    public School getById(Long id) throws SQLException;

    public School getAll() throws SQLException;
}
