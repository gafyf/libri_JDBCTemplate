package com.libri.demo.libro;

import com.libri.demo.autore.Autore;
import com.libri.demo.autore.AutoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/libro")
@CrossOrigin(origins = "http://localhost:8080")
public class LibroController {
    private final LibroDAO libroDAO;
    private final AutoreDAO autoreDAO;
    @Autowired
    public LibroController(LibroDAO libroDAO, AutoreDAO autoreDAO) {
        this.libroDAO = libroDAO;
        this.autoreDAO = autoreDAO;
    }

    @GetMapping
    public List<Libro> getAllLibri() { return libroDAO.getAllLibri();}

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id){
        return libroDAO.getLibroById(id);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteLibro(@PathVariable Long id){
        return libroDAO.deleteLibro(libroDAO.getLibroById(id));
    }

    @PutMapping("/update/{id}/{str}")
    public boolean updateLibro(@PathVariable Long id, @PathVariable String str){
        Libro libro = libroDAO.getLibroById(id);
        libro.setTitolo(str);
        libro.setNumero_pagine(libro.getNumero_pagine());
        libro.setAnno_pubblicazione(libro.getAnno_pubblicazione());
        libro.setId_genere(libro.getId_genere());
        System.out.println(libro.toString());
        return libroDAO.updateLibro(libro);
    }

    @PostMapping("/create")
    public boolean createLibro(@RequestBody Libro libro){
        System.out.println(libro.toString());
        return libroDAO.createLibro(libro);
    }

    @GetMapping("/genere/{id_genere}")
    public List<Libro> libriByGenere(@PathVariable int id_genere){
        return libroDAO.getLibriByGenere(id_genere);
    }
    @GetMapping("/autore/{id_autore}")
    public List<Libro> libriByAutore(@PathVariable int id_autore){
        List<Libro> lista = new ArrayList<>();
        try {
            lista = libroDAO.getLibriByAutore(id_autore);
            System.out.println(lista.toString());
        }
        catch (Exception i){
            System.out.println(i);
        }

        return lista;
    }

}
