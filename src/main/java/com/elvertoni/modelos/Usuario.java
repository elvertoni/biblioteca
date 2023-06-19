package com.elvertoni.modelos;

import javax.persistence.*;
import org.mindrot.jbcrypt.BCrypt;



@Entity
@Table(name = "Usuario")
public class Usuario {

    // Declaração dos atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "endereco")
    protected String endereco;

    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password;

    // Construtor vazio
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(String nome, String endereco, String username, String password) {
        this.nome = nome;
        this.endereco = endereco;
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Criptografar a senha usando o BCrypt
        String passwordCrypto = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = passwordCrypto;
    }


    // Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


    
