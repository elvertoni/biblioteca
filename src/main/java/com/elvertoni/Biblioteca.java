package com.elvertoni;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.elvertoni.dao.EditoraDAO;
import com.elvertoni.dao.UsuarioDAO;
import com.elvertoni.modelos.Aluno;
import com.elvertoni.modelos.Editora;
import com.elvertoni.modelos.Livro;
import com.elvertoni.modelos.Usuario;

public class Biblioteca {
    private static EntityManagerFactory emf;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");


        // Instanciação dos objetos DAO
        UsuarioDAO uDao = new UsuarioDAO();
        EditoraDAO eDao = new EditoraDAO();
        
        /*********** SALVAR OBJETOS NO BANCO DE DADOS ******************/

        // Instanciar usuários
        Usuario u1 = new Usuario(   "Elvertoni", 
                                    "rua 1", 
                                    "elvertoni", 
                                    "123456");

        Usuario u2 = new Usuario(   "João",
                                    "rua 2",
                                    "joao",
                                    "789456");

        Usuario u3 = new Usuario(   "Maria",
                                    "rua 3",
                                    "maria",
                                    "963258");

        
        // Instanciar alunos
        Aluno a1 = new Aluno(   "Aluno 1",
                                "rua 4",
                                "aluno1",
                                "741258",
                                111111,
                                "Enfermagem");

        Aluno a2 = new Aluno(   "Aluno 2",  
                                "rua 5",
                                "aluno2",
                                "852147",
                                222222,
                                "Pedagogia");

        Aluno a3 = new Aluno(   "Aluno 3",  
                                "rua 6",
                                "aluno3",
                                "963258",
                                333333,
                                "Medicina");


        // Instanciar editoras
        Editora e1 = new Editora(   "Editora 1",
                                    "000.111");

        Editora e2 = new Editora(   "Editora 2",
                                    "000.222");

        Editora e3 = new Editora(   "Editora 3",
                                    "000.333");

        

        // Instanciar livros
        






        // Salva os objetos no banco
        // Salva os usuários
        uDao.salvarUsuario(u1);
        uDao.salvarUsuario(u2);
        uDao.salvarUsuario(u3);

        // Salva os alunos
        uDao.salvarUsuario(a1);
        uDao.salvarUsuario(a2);
        uDao.salvarUsuario(a3);

        // Salva as editoras
        eDao.salvarEditora(e1);
        eDao.salvarEditora(e2);
        eDao.salvarEditora(e3);

        //Salva os livros
        eDao.salvarEditora(l1);
        eDao.salvarEditora(l2);
        eDao.salvarEditora(l3);
    }

    public static void menu() {
        int op = 0;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Editora");
            System.out.println("2 - Listar Editora");
            System.out.println("3 - Atualizar Editora");
            System.out.println("4 - Excluir Editora");
            System.out.println("5 - Cadastrar Livro");
            System.out.println("6 - Listar Livro");
            System.out.println("7 - Atualizar Livro");
            System.out.println("8 - Excluir Livro");
            System.out.println("9 - Cadastrar Usuario");
            System.out.println("10 - Listar Usuario");
            System.out.println("11 - Atualizar Usuario");
            System.out.println("12 - Excluir Usuario");
            System.out.println("13 - Cadastrar Aluno");
            System.out.println("14 - Listar Aluno");
            System.out.println("15 - Atualizar Aluno");
            System.out.println("16 - Excluir Aluno");
            System.out.println("00 - Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarEditora();
                    break;
                case 2:
                    listarEditoras();
                    break;
                case 3:
                    atualizarEditora();
                    break;
                case 4:
                    excluirEditora();
                    break;
                case 5:
                    cadastrarLivro();
                    break;
                case 6:
                    listarLivros();
                    break;
                case 7:
                    atualizarLivro();
                    break;
                case 8:
                    excluirLivro();
                    break;
                case 9:
                    cadastrarUsuario();
                    break;
                case 10:
                    listarUsuarios();
                    break;
                case 11:
                    atualizarUsuario();
                    break;
                case 12:
                    excluirUsuario();
                    break;
                case 13:
                    cadastrarAluno();
                    break;
                case 14:
                    listarAlunos();
                    break;
                case 15:
                    atualizarAluno();
                    break;
                case 16:
                    excluirAluno();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

            emf.close();
        } while (op != 0);
    }

    // Métodos para manipulação da editora
    private static void cadastrarEditora() {
        System.out.println("Cadastro de Editora");

        System.out.println("Informe o nome da editora:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o CNPJ da editora:");
        String cnpj = sc.nextLine();

        Editora editora = new Editora(nome, cnpj);
        EditoraDAO.salvarEditora(editora);

        System.out.println("Editora cadastrada com sucesso!");
    }

    private static void listarEditoras() {
        System.out.println("Lista de Editoras:");

        for (Editora editora : EditoraDAO.buscarTodasEditoras()) {
            System.out.println("Nome: " + editora.getNome());
            System.out.println("CNPJ: " + editora.getCnpj());
            System.out.println("--------------------");
        }
    }

    private static void atualizarEditora() {
        System.out.println("Atualização de Editora");

        System.out.println("Informe o nome da editora:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o CNPJ da editora:");
        String cnpj = sc.nextLine();

        Editora editora = new Editora(nome, cnpj);
        EditoraDAO.editarEditora(editora);

        System.out.println("Editora atualizada com sucesso!");
    }

    private static void excluirEditora(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Exclusão de Editora");

        System.out.println("Informe o nome da editora:");
        scanner.nextLine(); // Limpar o buffer
        String nome = scanner.nextLine();

        Editora editora = EditoraDAO.buscarEditoraPorNome(nome);
        EditoraDAO.excluirEditora(editora);

        System.out.println("Editora excluída com sucesso!");

    }

    // Métodos para manipulação do livro
    private static void cadastrarLivro(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Cadastro de Livro");

        System.out.println("Informe o nome do livro:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o autor do livro:");
        String autor = sc.nextLine();

        System.out.println("Informe o CDD do livro:");
        String cdd = sc.nextLine();

        System.out.println("Informe o ano do livro:");
        int ano = sc.nextInt();

        System.out.println("Informe a edição do livro:");
        int edicao = scanner.nextInt();

        Livro livro = new Livro(nome, autor, cdd, ano, edicao);
        EditoraDAO.salvarEditora(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void listarLivros(EditoraDAO EditoraDAO) {
        System.out.println("Lista de Livros:");

        for (Livro livro : EditoraDAO.buscarTodosLivros()) {
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("CDD: " + livro.getCdd());
            System.out.println("Ano: " + livro.getAno());
            System.out.println("Edição: " + livro.getEdicao());
            System.out.println("--------------------");
        }
    }

    private static void atualizarLivro(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Atualização de Livro");

        System.out.println("Informe o nome do livro:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o autor do livro:");
        String autor = sc.nextLine();

        System.out.println("Informe o CDD do livro:");
        String cdd = sc.nextLine();

        System.out.println("Informe o ano do livro:");
        int ano = sc.nextInt();

        System.out.println("Informe a edição do livro:");
        int edicao = sc.nextInt();

        Livro livro = new Livro(nome, autor, cdd, ano, edicao);
        EditoraDAO.editarEditora(livro);

        System.out.println("Livro atualizado com sucesso!");

    }

    private static void excluirLivro(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Exclusão de Livro");

        System.out.println("Informe o nome do livro:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        Livro livro = EditoraDAO.buscarLivroPorNome(nome);
        EditoraDAO.excluirEditora(livro);

        System.out.println("Livro excluído com sucesso!");
    }

    // Métodos para manipulação do usuário
    private static void cadastrarUsuario(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Cadastro de Usuario");

        System.out.println("Informe o nome do usuario:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o endereço do usuario:");
        String endereco = sc.nextLine();

        Usuario usuario = new Usuario(nome, endereco);
        EditoraDAO.salvarEditora(usuario);

        System.out.println("Usuario cadastrado com sucesso!");
    }

    private static void listarUsuarios(EditoraDAO EditoraDAO) {
        System.out.println("Lista de Usuarios:");

        for (Usuario usuario : EditoraDAO.buscarTodosUsuarios()) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Endereço: " + usuario.getEndereco());
            System.out.println("--------------------");
        }
    }

    private static void atualizarUsuario(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Atualização de Usuario");

        System.out.println("Informe o nome do usuario:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o endereço do usuario:");
        String endereco = sc.nextLine();

        Usuario usuario = new Usuario(nome, endereco);
        EditoraDAO.editarEditora(usuario);

        System.out.println("Usuario atualizado com sucesso!");
    }

    private static void excluirUsuario(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Exclusão de Usuario");

        System.out.println("Informe o nome do usuario:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        Usuario usuario = EditoraDAO.buscarUsuarioPorNome(nome);
        EditoraDAO.excluirEditora(usuario);

        System.out.println("Usuario excluído com sucesso!");
    }

    // Métodos para manipulação do aluno
    private static void cadastrarAluno(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Cadastro de Aluno");

        System.out.println("Informe o nome do aluno:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o endereço do aluno:");
        String endereco = sc.nextLine();

        System.out.println("Informe a matricula do aluno:");
        int matricula = sc.nextInt();

        System.out.println("Informe o curso do aluno:");
        String curso = sc.nextLine();

        Aluno aluno = new Aluno(nome, endereco, matricula, curso);
        EditoraDAO.salvarEditora(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        System.out.println("Lista de Alunos:");

        for (Aluno aluno : EditoraDAO.buscarTodosAlunos()) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Curso: " + aluno.getCurso());
            System.out.println("--------------------");
        }
    }

    private static void atualizarAluno(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Atualização de Aluno");

        System.out.println("Informe o nome do aluno:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        System.out.println("Informe o endereço do aluno:");
        String endereco = sc.nextLine();

        System.out.println("Informe a matricula do aluno:");
        int matricula = sc.nextInt();

        System.out.println("Informe o curso do aluno:");
        String curso = sc.nextLine();

        Aluno aluno = new Aluno(nome, endereco, matricula, curso);
        EditoraDAO.editarEditora(aluno);

        System.out.println("Aluno atualizado com sucesso!");
    }

    private static void excluirAluno(Scanner scanner, EditoraDAO EditoraDAO) {
        System.out.println("Exclusão de Aluno");

        System.out.println("Informe o nome do aluno:");
        sc.nextLine(); // Limpar o buffer
        String nome = sc.nextLine();

        Aluno aluno = EditoraDAO.buscarAlunoPorNome(nome);
        EditoraDAO.excluirEditora(aluno);

        System.out.println("Aluno excluído com sucesso!");
    }

}