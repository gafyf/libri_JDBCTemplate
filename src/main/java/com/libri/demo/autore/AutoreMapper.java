package com.libri.demo.autore;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoreMapper implements RowMapper<Autore> {
    public Autore mapRow(ResultSet resultSet, int i) throws SQLException{
        Autore autore = new Autore();
        autore.setId(resultSet.getLong("id"));
        autore.setNome(resultSet.getString("nome"));
        autore.setCognome(resultSet.getString("cognome"));
        autore.setAnno_nascita(resultSet.getInt("anno_nascita"));
        return autore;
    }
}
