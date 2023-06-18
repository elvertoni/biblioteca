package com.elvertoni.modelos;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "livro")

public class Livro extends Editora {

    private String titulo;
    private String autor;
    private String cdd;
    private int ano;
    private int edicao;

    public Livro() {
    }

    public Livro(String titulo, String autor, String cdd, int ano, int edicao) {
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

    @Override
    public String toString() {
        return "Livro [titulo = " + titulo + ", autor = " + autor + ", cdd = " + cdd + ", ano = " + ano + ", edicao = " + edicao + "]";
    }
}


