package com.libri.demo.autore;

public class Autore {
    private Long id;
    private String nome;
    private String cognome;
    private int anno_nascita;

    public Autore() {
    }

    public Autore(Long id, String nome, String cognome, int anno_nascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.anno_nascita = anno_nascita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAnno_nascita() {
        return anno_nascita;
    }

    public void setAnno_nascita(int anno_nascita) {
        this.anno_nascita = anno_nascita;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", anno_nascita=" + anno_nascita +
                '}';
    }
}
