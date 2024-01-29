package com.libri.demo.libroautore;

import com.libri.demo.autore.Autore;
import com.libri.demo.libro.Libro;

public class LibroAutore {
    private int id_autore;
    private int id_libro;

    public LibroAutore() {
    }

    public LibroAutore(int id_autore, int id_libro) {
        this.id_autore = id_autore;
        this.id_libro = id_libro;
    }
    public int getId_autore() {
        return id_autore;
    }

    public void setId_autore(int id_autore) {
        this.id_autore = id_autore;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }



    @Override
    public String toString() {
        return "LibroAutore{" +
                "id_autore=" + id_autore +
                ", id_libro=" + id_libro +
                '}';
    }
}
