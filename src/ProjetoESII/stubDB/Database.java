package ProjetoESII.stubDB;

import ProjetoESII.*;
import ProjetoESII.Exceptions.InvalidEmprestimoException;
import ProjetoESII.Exceptions.InvalidExtensaoEmprestimoException;
import ProjetoESII.Exceptions.InvalidReplicaException;

import java.time.LocalDate;

public class Database {

    private InterfaceDB interfaceDB = new DBAdapterStub();

    public synchronized int addUser(Utilizador u) {
        return interfaceDB.addUser(u);
    }

    public synchronized int removeUser(Utilizador u) {
        return interfaceDB.removeUser(u);
    }

    public synchronized int updateUser(Utilizador u, String nome, String email, String password, String estado) {
        return interfaceDB.updateUser(u, nome, email, password, estado);
    }

    public synchronized Utilizador getUser(int id) {
        return interfaceDB.getUser(id);
    }

    public synchronized Utilizador loginUser(String email, String password) {
        return interfaceDB.loginUser(email, password);
    }


    //EBOOK
    public synchronized int addEbook(EBook ebook) {
        return interfaceDB.addEbook(ebook);
    }

    public synchronized int removeEbook(EBook ebook) {
        return interfaceDB.removeEbook(ebook);
    }

    public synchronized int updateEbook(EBook ebook, String autor, String formato, String titulo, String ISBN, String assinatura, Editora editora, String idioma, Float tamanhoFicheiro) {
        return interfaceDB.updateEbook(ebook, autor, formato, titulo, ISBN, assinatura, editora, idioma, tamanhoFicheiro);
    }

    public synchronized EBook getEbook(int idEbook) {
        return interfaceDB.getEbook(idEbook);
    }

    //Emprestimo
    public synchronized int addEmprestimo(Emprestimo emp) {
        return interfaceDB.addEmprestimo(emp);
    }

    public synchronized int removeEmprestimo(Emprestimo emp) {
        return interfaceDB.removeEmprestimo(emp);
    }

    public synchronized int updateEmprestimo(Emprestimo emp, LocalDate data_ini, LocalDate data_fim, int prolongacao, Utilizador user, ReplicaServidor replicaServidor, CopiaEBook copiaEBook, int assinatura) throws InvalidEmprestimoException, InvalidExtensaoEmprestimoException {
        return interfaceDB.updateEmprestimo(emp, data_ini, data_fim, prolongacao, user, replicaServidor, copiaEBook, assinatura);
    }

    public synchronized Emprestimo getEmprestimo(int idEmp) {
        return interfaceDB.getEmprestimo(idEmp);
    }

    public synchronized EBook getEbookFromEmprestimo(int idEmp) {
        return interfaceDB.getEbookFromEmprestimo(idEmp);
    }

    public synchronized Utilizador getUtilizadorFromEmprestimo(int idEmp) {
        return interfaceDB.getUtilizadorFromEmprestimo(idEmp);
    }

    public synchronized ReplicaServidor getReplicaFromEmprestimo(int idEmp) {
        return interfaceDB.getReplicaFromEmprestimo(idEmp);
    }

    //Editora
    public synchronized int addEditora(Editora edit) {
        return interfaceDB.addEditora(edit);
    }

    public synchronized int removeEditora(Editora edit) {
        return interfaceDB.removeEditora(edit);
    }

    public synchronized int updateEditora(Editora edit, String nomeEditora, String morada){
        return interfaceDB.updateEditora(edit, nomeEditora, morada);
    }

    public synchronized Editora getEditora(int idEdit){
        return interfaceDB.getEditora(idEdit);
    }

    //Funcionario
    public synchronized int addFuncionario(Funcionario func) {
        return interfaceDB.addFuncionario(func);
    }

    public synchronized int removeFuncionario(Funcionario func) {
        return interfaceDB.removeFuncionario(func);
    }

    public synchronized int updateFuncionario(Funcionario func, String emailFunc, String passFunc, String nomeFunc) {
        return interfaceDB.updateFuncionario(func, emailFunc, passFunc, nomeFunc);
    }

    public synchronized Funcionario getFuncionario(int idFunc) {
        return interfaceDB.getFuncionario(idFunc);
    }

    //Replica Servidor
    public synchronized int addReplica(ReplicaServidor replica) {
        return interfaceDB.addReplica(replica);
    }

    public synchronized int removeReplica(ReplicaServidor replica) {
        return interfaceDB.removeReplica(replica);
    }

    public synchronized int updateReplica(ReplicaServidor replica, String localizacao) throws InvalidReplicaException {
        return interfaceDB.updateReplica(replica, localizacao);
    }

    public synchronized ReplicaServidor getReplica(int idReplica) {
        return interfaceDB.getReplica(idReplica);
    }
}