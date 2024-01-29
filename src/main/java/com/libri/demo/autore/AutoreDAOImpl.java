package com.libri.demo.autore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class AutoreDAOImpl implements AutoreDAO{
    JdbcTemplate jdbcTemplate;
    private final String SQL_FIND_AUTORE = "select * from autore where id = ?";
    private final String SQL_ALL_AUTORI = "select * from autore";
    private final String SQL_DELETE_AUTORE = "delete from autore where id = ?";
    private final String SQL_UPDATE_AUTORE = "update autore set nome = ?, cognome = ?, anno_nascita = ? where id = ?";
    private final String SQL_CREATE_AUTORE = "insert into autore (nome, cognome, anno_nascita) values (?,?,?)";

    @Autowired
    public AutoreDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Autore getAutoreById(Long id){
        return jdbcTemplate.queryForObject(SQL_FIND_AUTORE, new Object[]{id}, new AutoreMapper());
    }
    public List<Autore> getAllAutori(){
        return jdbcTemplate.query(SQL_ALL_AUTORI, new AutoreMapper());
    }
    public boolean deleteAutore(Autore autore){
        return jdbcTemplate.update(SQL_DELETE_AUTORE, autore.getId()) > 0;
    }
    public boolean updateAutore(Autore autore){
        return jdbcTemplate.update(SQL_UPDATE_AUTORE, autore.getNome(), autore.getCognome(), autore.getAnno_nascita(), autore.getId()) > 0;
    }
    public boolean createAutore(Autore autore){
        return jdbcTemplate.update(SQL_CREATE_AUTORE, autore.getNome(), autore.getCognome(), autore.getAnno_nascita()) > 0;
    }
}
