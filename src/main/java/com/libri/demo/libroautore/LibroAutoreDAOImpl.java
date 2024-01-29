package com.libri.demo.libroautore;

import com.libri.demo.libro.Libro;
import com.libri.demo.libro.LibroDAO;
import com.libri.demo.libro.LibroDAOImpl;
import com.libri.demo.libro.LibroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class LibroAutoreDAOImpl implements LibroAutoreDAO{
    JdbcTemplate jdbcTemplate;
    private final String SQL_ALL = "select * from libro_autore";
    private final String SQL_CREATE = "insert into libro_autore (id_libro, id_autore) values (?,?)";
    private final String SQL_UPDATE = "update libro_autore set id_libro = ?, id_autore = ? where id_libro = ? and id_autore = ?";
    private final String SQL_DELETE = "delete from libro_autore where id_libro = ? and id_autore = ?";
    private final String SQL_GET_BY_AUTORE = "select * from libro_autore where libro_autore.id_autore = ?";
    private final String SQL_GET_BY_LIBRO = "select * from libro_autore where libro_autore.id_libro = ?";
    @Autowired
    public LibroAutoreDAOImpl(DataSource dataSource){ jdbcTemplate = new JdbcTemplate(dataSource);}

    public List<LibroAutore> getAll(){
        return jdbcTemplate.query(SQL_ALL, new LibroAutoreMapper());
    }
    public boolean createLibroAutore(LibroAutore libroAutore){
        return  jdbcTemplate.update(SQL_CREATE, libroAutore.getId_libro(), libroAutore.getId_autore()) > 0;
    }
    public boolean updateLibroAutore(LibroAutore libroAutore){
        return jdbcTemplate.update(SQL_UPDATE, libroAutore.getId_libro(), libroAutore.getId_autore(), libroAutore.getId_libro(), libroAutore.getId_autore()) > 0;
    }
    public boolean deleteLibroAutore(LibroAutore libroAutore){
        return jdbcTemplate.update(SQL_DELETE, libroAutore.getId_libro(), libroAutore.getId_autore()) > 0;
    }
    public List<LibroAutore> getByAutore(Long id_autore){
        return jdbcTemplate.query(SQL_GET_BY_AUTORE, new Object[]{id_autore}, new LibroAutoreMapper());

    }
    public List<LibroAutore> getByLibro(int id_libro){
        return jdbcTemplate.query(SQL_GET_BY_LIBRO, new Object[]{id_libro}, new LibroAutoreMapper());
    }
}
