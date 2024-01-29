package com.libri.demo.autore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/autore")
public class AutoreController {
    private final AutoreDAO autoreDAO;
    @Autowired
    public AutoreController(AutoreDAO autoreDAO) {
        this.autoreDAO = autoreDAO;
    }

    @GetMapping()
    public List<Autore> getAllAutori(){
        return autoreDAO.getAllAutori();
    }
    @GetMapping("/{id}")
    public Autore getLibroById(@PathVariable Long id){
        return autoreDAO.getAutoreById(id);
    }
    @PostMapping("/create")
    public boolean createAutore(@RequestBody Autore autore){
        return autoreDAO.createAutore(autore);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteAutore(@PathVariable Long id){
        return autoreDAO.deleteAutore(autoreDAO.getAutoreById(id));
    }
    @PutMapping("/update/{id}")
    public boolean updateAutore(@PathVariable Long id, @RequestBody Autore autore){
        Autore newAutore = autoreDAO.getAutoreById(id);
        newAutore.setNome(autore.getNome());
        newAutore.setCognome(autore.getCognome());
        newAutore.setAnno_nascita(autore.getAnno_nascita());
        return autoreDAO.updateAutore(newAutore);
    }

}
