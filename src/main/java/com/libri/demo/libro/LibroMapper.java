package com.libri.demo.libro;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroMapper implements RowMapper<Libro> {
    public Libro mapRow(ResultSet resultSet, int i) throws SQLException {
        Libro libro = new Libro();
        libro.setId(resultSet.getLong("id"));
        libro.setTitolo(resultSet.getString("titolo"));
        libro.setAnno_pubblicazione(resultSet.getDate("anno_pubblicazione").toLocalDate());
        libro.setNumero_pagine(resultSet.getInt("numero_pagine"));
        libro.setId_genere(resultSet.getInt("id_genere"));
        return libro;
    }
}





