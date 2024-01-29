package com.libri.demo.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LibroDAOImpl implements LibroDAO {
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_LIBRO = "select * from libri where id = ?";
    private final String SQL_GET_ALL = "select * from libri";
    private final String SQL_DELETE_LIBRO = "delete from libri where id = ?";
    private final String SQL_UPDATE_LIBRO = "update libri set titolo = ?, numero_pagine = ?, anno_pubblicazione = ?, id_genere = ? where id = ?";
    private final String SQL_CREATE_LIBRO = "insert into libri(titolo, numero_pagine, anno_pubblicazione, id_genere) values (?,?,?,?)";
    private final String SQL_FIND_LIBRI_BY_GENERE = "select * from libri where id_genere = ?";

    @Autowired
    public LibroDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Libro getLibroById(Long id){
        return jdbcTemplate.queryForObject(SQL_FIND_LIBRO, new Object[] {id}, new LibroMapper());
    }
    public List<Libro> getAllLibri(){
        return jdbcTemplate.query(SQL_GET_ALL, new LibroMapper());
    }
    public boolean deleteLibro(Libro libro){
        return jdbcTemplate.update(SQL_DELETE_LIBRO, libro.getId()) > 0;
    }
    public boolean updateLibro(Libro libro){
        return jdbcTemplate.update(SQL_UPDATE_LIBRO, libro.getTitolo(), libro.getNumero_pagine(), libro.getAnno_pubblicazione(), libro.getId_genere(), libro.getId()) > 0;
    }
    public boolean createLibro(Libro libro){
        return jdbcTemplate.update(SQL_CREATE_LIBRO, libro.getTitolo(), libro.getNumero_pagine(), java.sql.Date.valueOf(libro.getAnno_pubblicazione()), libro.getId_genere()) > 0;
    }
    public List<Libro> getLibriByGenere(int id_genere){
        return jdbcTemplate.query(SQL_FIND_LIBRI_BY_GENERE, new Object[] {id_genere}, new LibroMapper());
    }
    public List<Libro> getLibriByAutore(int id_autore){
        String query = "SELECT * FROM libri "+
                "join libro_autore on libro_autore.id_libro = libri.id "+
                "where libro_autore.id_autore = ?";
        return jdbcTemplate.query(query, new Object[] {id_autore}, new LibroMapper());
    }

}
