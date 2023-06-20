package com.elvertoni.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEmprestimo;
    private String dataDevolucao;

    @OneToOne
    private Aluno aluno;

    @OneToMany
    private Livro livro;

    public Emprestimo() {
    }

    public Emprestimo(String dataEmprestimo, String dataDevolucao, Aluno aluno, Livro livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.aluno = aluno;
        this.livro = livro;
    }
}
