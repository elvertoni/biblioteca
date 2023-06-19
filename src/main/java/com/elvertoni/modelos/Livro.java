package com.elvertoni.modelos;

import javax.persistence.*;

@Entity
@Table(name = "livro")

public class Livro extends Editora {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "cdd")
    private String cdd;

    @Column(name = "ano")
    private int ano;

    @Column(name = "edicao")
    private int edicao;

    // Construtor vazio
    public Livro() {
    }

    // Construtor com parâmetros
    public Livro(String nome, String cnpj, String titulo, String autor, String cdd, int ano, int edicao) {
        super(nome, cnpj);
        this.titulo = titulo;
        this.autor = autor;
        this.cdd = cdd;
        this.ano = ano;
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCdd() {
        return cdd;
    }

    public void setCdd(String cdd) {
        this.cdd = cdd;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }


    // Getters e Setters
   

}
