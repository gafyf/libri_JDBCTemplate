package com.libri.demo.libro;

import java.util.List;

public interface LibroDAO {
    Libro getLibroById(Long id);
    List<Libro> getAllLibri();
    boolean deleteLibro(Libro libro);
    boolean updateLibro(Libro libro);
    boolean createLibro(Libro libro);
    List<Libro> getLibriByGenere(int id_genere);
    List<Libro> getLibriByAutore(int id_autore);

}



