package com.libri.demo.libro;

import java.time.LocalDate;
import java.util.Date;

public class Libro {
    private Long id;
    private String titolo;
    private int numero_pagine;
    private LocalDate anno_pubblicazione;
    private int id_genere;

    public Libro() {
    }

    public Libro(Long id, String titolo, int numero_pagine, LocalDate anno_pubblicazione, int id_genere) {
        this.id = id;
        this.titolo = titolo;
        this.numero_pagine = numero_pagine;
        this.anno_pubblicazione = anno_pubblicazione;
        this.id_genere = id_genere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    public LocalDate getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(LocalDate anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getId_genere() {
        return id_genere;
    }

    public void setId_genere(int id_genere) {
        this.id_genere = id_genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", numero_pagine=" + numero_pagine +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", id_genere=" + id_genere +
                '}';
    }
}
