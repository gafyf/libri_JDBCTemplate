package com.libri.demo.genere;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GenereMapper implements RowMapper<Genere> {
    public Genere mapRow(ResultSet resultSet, int i) throws SQLException{
        Genere genere = new Genere();
        genere.setId(resultSet.getLong("id"));
        genere.setDescrizione(resultSet.getString("descrizione"));
        return genere;
    }
}
