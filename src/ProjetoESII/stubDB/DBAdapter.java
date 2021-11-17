package ProjetoESII.stubDB;

import ProjetoESII.*;
import ProjetoESII.Exceptions.InvalidEmprestimoException;
import ProjetoESII.Exceptions.InvalidExtensaoEmprestimoException;
import ProjetoESII.Exceptions.InvalidReplicaException;

import java.time.LocalDate;

public class DBAdapter implements InterfaceDB {
    private String connection = "";


    //User
    @Override
    public int addUser(Utilizador u) {
        return -1;
    }

    @Override
    public int removeUser(Utilizador u) {
        return 0;
    }

    @Override
    public int updateUser(Utilizador u, String nome, String email, String password, String estado) {
        return 0;
    }

    @Override
    public Utilizador getUser(int id) {
        return null;
    }

    @Override
    public Utilizador loginUser(String email, String password) {
        return null;
    }


    //EBook
    @Override
    public int addEbook(EBook ebook) { return -1; }

    @Override
    public int removeEbook(EBook ebook) { return 0; }

    @Override
    public int updateEbook(EBook ebook, String autor, String formato, String titulo, String ISBN, String assinatura, Editora editora, String idioma, Float tamanhoFicheiro) { return 0; }

    @Override
    public EBook getEbook(int idEbook) { return null; }

    // Emprestimo
    @Override
    public int addEmprestimo(Emprestimo emp) {
        return -1;
    }

    @Override
    public int removeEmprestimo(Emprestimo emp) {
        return 0;
    }

    @Override
    public int updateEmprestimo(Emprestimo emp, LocalDate data_ini, LocalDate data_fim, int prolongacao, Utilizador user, ReplicaServidor replicaServidor, CopiaEBook copiaEBook, int assinatura)  throws InvalidEmprestimoException, InvalidExtensaoEmprestimoException{
        return 0;
    }

    @Override
    public Emprestimo getEmprestimo(int idEmp) {
        return null;
    }

    @Override
    public EBook getEbookFromEmprestimo(int idEmp) {
        return null;
    }

    @Override
    public Utilizador getUtilizadorFromEmprestimo(int idEmp) {
        return null;
    }

    @Override
    public ReplicaServidor getReplicaFromEmprestimo(int idEmp) {
        return null;
    }


    // Editora
    @Override
    public int addEditora(Editora edit) {
        return -1;
    }

    @Override
    public int removeEditora(Editora edit) {
        return 0;
    }

    @Override
    public int updateEditora(Editora edit, String nomeEditora, String morada) {
        return 0;
    }

    @Override
    public Editora getEditora(int idEdit) {
        return null;
    }

    //Funcionario
    @Override
    public int addFuncionario(Funcionario func) {
        return -1;
    }

    @Override
    public int removeFuncionario(Funcionario func) {
        return 0;
    }

    @Override
    public int updateFuncionario(Funcionario func, String emailFunc, String passFunc, String nomeFunc) {
        return 0;
    }

    @Override
    public Funcionario getFuncionario(int idFunc) {
        return null;
    }

    //Replica Servidor
    @Override
    public int addReplica(ReplicaServidor replica) {
        return -1;
    }

    @Override
    public int removeReplica(ReplicaServidor replica) {
        return 0;
    }

    @Override
    public int updateReplica(ReplicaServidor replica, String localizacao) throws InvalidReplicaException {
        return 0;
    }

    @Override
    public ReplicaServidor getReplica(int idReplica) {
        return null;
    }
}
