package com.libri.demo.libroautore;

import com.libri.demo.autore.Autore;
import com.libri.demo.libro.Libro;

import java.util.List;

public interface LibroAutoreDAO {
    List<LibroAutore> getAll();
    boolean createLibroAutore(LibroAutore libroAutore);
    boolean updateLibroAutore(LibroAutore libroAutore);
    boolean deleteLibroAutore(LibroAutore libroAutore);
    List<LibroAutore> getByAutore(Long id_autore);
    List<LibroAutore> getByLibro(int id_libro);

}
