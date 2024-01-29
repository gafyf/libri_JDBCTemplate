package com.libri.demo.genere;

import java.util.List;

public interface GenereDAO {
    Genere getGenereById(Long id);
    List<Genere> getAllGenere();
    boolean deleteGenere(Genere genere);
    boolean updateGenere(Genere genere);
    boolean createGenere(Genere genere);

    List<Genere> getGenereByDescrizione(String descrie);
}
