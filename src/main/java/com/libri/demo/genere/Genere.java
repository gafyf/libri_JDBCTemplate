package com.libri.demo.genere;

public class Genere {
    private Long id;
    private String descrizione;

    public Genere(){

    }
    public Genere(Long id, String descrizione){
        this.id = id;
        this.descrizione = descrizione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Genere{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
