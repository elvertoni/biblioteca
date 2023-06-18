package com.elvertoni.modelos;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_Editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected static String nome;
    protected static String cnpj;

    public Editora() {
    }

    public Editora(String nome, String cnpj) {
        Editora.nome = nome;
        Editora.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Editora.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        Editora.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Editora [nome=" + nome + ", cnpj=" + cnpj + "]";
    }

}
