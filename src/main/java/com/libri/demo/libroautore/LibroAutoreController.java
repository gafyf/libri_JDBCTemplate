package com.libri.demo.libroautore;

import com.libri.demo.autore.Autore;
import com.libri.demo.libro.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/libriautore")
public class LibroAutoreController {
    private final LibroAutoreDAO libroAutoreDAO;
    @Autowired
    public LibroAutoreController(LibroAutoreDAO libroAutoreDAO){
        this.libroAutoreDAO = libroAutoreDAO;
    }
    @GetMapping()
    public List<LibroAutore> getAll(){
        return libroAutoreDAO.getAll();
    }

    @GetMapping("/autore/{id_autore}")
    public List<LibroAutore> getByAutore(@PathVariable Long id_autore){
        return libroAutoreDAO.getByAutore(id_autore);
    }
    @GetMapping("/libro/{id_libro}")
    public List<LibroAutore> getByLibro(@PathVariable int id_libro){
        return libroAutoreDAO.getByLibro(id_libro);
    }
    @PostMapping("/create")
    public boolean createLibroAutore(@RequestBody LibroAutore libroAutore){
        libroAutore.setId_libro(libroAutore.getId_libro());
        libroAutore.setId_autore(libroAutore.getId_autore());
        return libroAutoreDAO.createLibroAutore(libroAutore);
    }
    @PutMapping("/update")
    public boolean updateLibroAutore(@RequestBody LibroAutore libroAutore){
        libroAutore.setId_libro(libroAutore.getId_libro());
        libroAutore.setId_autore(libroAutore.getId_autore());
        return libroAutoreDAO.updateLibroAutore(libroAutore);
    }
    @DeleteMapping("/delete/{id_libro}/{id_autore}")
    public boolean deleteLibroAutore(@PathVariable Long id_libro, @PathVariable Long id_autore){
        LibroAutore libroAutore = new LibroAutore();
        libroAutore.setId_libro(id_libro.intValue());
        libroAutore.setId_autore(id_autore.intValue());
        return libroAutoreDAO.deleteLibroAutore(libroAutore);
    }
}
