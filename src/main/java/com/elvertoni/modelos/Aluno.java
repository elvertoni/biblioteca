package com.elvertoni.modelos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "aluno")

public class Aluno extends Usuario {
    private int rgm;
    private String curso;

    public Aluno() {
    }

    public Aluno(String nome, String endereco, String username, String password, int rgm, String curso) {
        super(nome, endereco, username, password);
        this.rgm = rgm;
        this.curso = curso;
    }

    public int getRgm() {
        return rgm;
    }

    public void setRgm(int rgm) {
        this.rgm = rgm;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
