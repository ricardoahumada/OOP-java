package com.banana.persistence;

import com.banana.models.AClass;

import java.sql.SQLException;

public interface AClassRepositoryInf {
    public AClass add(AClass clase) throws SQLException;

    public AClass update(AClass clase) throws SQLException;

    public AClass getById(Long id) throws SQLException;
    public AClass getAll() throws SQLException;
}
