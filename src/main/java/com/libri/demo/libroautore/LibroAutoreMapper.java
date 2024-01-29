package com.libri.demo.libroautore;

import com.libri.demo.autore.Autore;
import com.libri.demo.libro.Libro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroAutoreMapper implements RowMapper<LibroAutore> {
    @Override
    public LibroAutore mapRow(ResultSet rs, int i) throws SQLException{
        LibroAutore libroAutore = new LibroAutore();
        libroAutore.setId_autore(rs.getInt("id_autore"));
        libroAutore.setId_libro(rs.getInt("id_libro"));

        return libroAutore;
    }

}
