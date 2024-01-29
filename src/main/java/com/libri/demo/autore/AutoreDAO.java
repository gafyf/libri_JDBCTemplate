package com.libri.demo.autore;

import java.util.List;

public interface AutoreDAO {
    Autore getAutoreById(Long id);
    List<Autore> getAllAutori();
    boolean createAutore(Autore autore);
    boolean updateAutore(Autore autore);
    boolean deleteAutore(Autore autore);
}
