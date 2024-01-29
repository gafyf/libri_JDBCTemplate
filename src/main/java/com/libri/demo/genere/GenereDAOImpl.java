package com.libri.demo.genere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Component
public class GenereDAOImpl implements GenereDAO {
    JdbcTemplate jdbcTemplate;
    private final String SQL_FIND_GENERE = "select * from genere where id = ?";
    private final String SQL_DELETE_GENERE = "delete from genere where id = ?";
    private final String SQL_UPDATE_GENERE = "update genere set descrizione = ? where id = ?";
    private final String SQL_GET_ALL = "select * from genere";
    private final String SQL_INSERT_GENERE = "insert into genere(descrizione) values (?)";
    private final String SQL_GET_DESCRIZIONE = "select * from genere where descrizione like ? ";
    @Autowired
    public GenereDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Genere getGenereById(Long id){
        return jdbcTemplate.queryForObject(SQL_FIND_GENERE, new Object[] {id}, new GenereMapper());
    }
    public List<Genere> getAllGenere(){
        return jdbcTemplate.query(SQL_GET_ALL, new GenereMapper());
    }
    public boolean deleteGenere(Genere genere){
        return jdbcTemplate.update(SQL_DELETE_GENERE, genere.getId()) > 0;
    }
    public boolean updateGenere(Genere genere){
        return jdbcTemplate.update(SQL_UPDATE_GENERE, genere.getDescrizione(), genere.getId()) > 0;
    }
    public boolean createGenere(Genere genere){
        return jdbcTemplate.update(SQL_INSERT_GENERE, genere.getDescrizione()) > 0;
    }
    public List<Genere> getGenereByDescrizione(String descrizione){
        descrizione = descrizione.trim();
        String search = "%"+descrizione+"%";
        return jdbcTemplate.query(SQL_GET_DESCRIZIONE, new Object[]{search}, new GenereMapper());
    }
}
