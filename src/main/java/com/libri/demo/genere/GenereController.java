package com.libri.demo.genere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/genere")
@CrossOrigin(origins = "http://localhost:8080")

public class GenereController {
    private final GenereDAO genereDAO;
    @Autowired
    public GenereController(GenereDAO genereDAO) {
        this.genereDAO = genereDAO;
    }
    @GetMapping
    public List<Genere> getAllGenere(){
        return genereDAO.getAllGenere();
    }
    @GetMapping("/{id}")
    public Genere getGenereById(@PathVariable Long id){
        return genereDAO.getGenereById(id);
    }

    @PutMapping("/{id}/update-descrizione")
    public ResponseEntity<String> updateGenereDescrizione(
            @PathVariable Long id,
            @RequestBody Genere updatedGenere
    ) {
        try {
            Genere existingGenere = genereDAO.getGenereById(id);

            if (existingGenere == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genere not found");
            }

            // Update only the description
            existingGenere.setDescrizione(updatedGenere.getDescrizione());

            boolean updated = genereDAO.updateGenere(existingGenere);

            if (updated) {
                return ResponseEntity.ok("Genere updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Genere");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


    @GetMapping("/desc/{descrizione}")
    public List<Genere> getDescrizione(@PathVariable(required = false) String descrizione){
        if(descrizione == null || descrizione.trim().isEmpty()){
            return getAllGenere();
        }
        return genereDAO.getGenereByDescrizione(descrizione);
    }

}
