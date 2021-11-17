package ProjetoESII.stubDB;

import ProjetoESII.*;
import ProjetoESII.Exceptions.InvalidEmprestimoException;
import ProjetoESII.Exceptions.InvalidExtensaoEmprestimoException;
import ProjetoESII.Exceptions.InvalidReplicaException;

import java.time.LocalDate;

public interface InterfaceDB {

    // User
    int addUser(Utilizador u);

    int removeUser(Utilizador u);

    int updateUser(Utilizador u, String nome, String email, String password, String estado);

    Utilizador getUser(int id);

    Utilizador loginUser(String email, String password);

    // EBook
    int addEbook(EBook ebook);

    int removeEbook(EBook ebook);

    int updateEbook(EBook ebook, String autor, String formato, String titulo, String ISBN, String assinatura, Editora editora, String idioma, Float tamanhoFicheiro);

    EBook getEbook(int idEbook);

    // Emprestimo
    int addEmprestimo(Emprestimo emp);

    int removeEmprestimo(Emprestimo emp);

    int updateEmprestimo(Emprestimo emp, LocalDate data_ini, LocalDate data_fim, int prolongacao, Utilizador user, ReplicaServidor replicaServidor, CopiaEBook copiaEBook, int assinatura)  throws InvalidEmprestimoException, InvalidExtensaoEmprestimoException;

    Emprestimo getEmprestimo(int idEmp);

    EBook getEbookFromEmprestimo(int idEmp);

    Utilizador getUtilizadorFromEmprestimo(int idEmp);

    ReplicaServidor getReplicaFromEmprestimo(int idEmp);


    // Editora
    int addEditora(Editora edit);

    int removeEditora(Editora edit);

    int updateEditora(Editora edit, String nomeEditora, String morada);

    Editora getEditora(int idEdit);

    //Funcionario
    int addFuncionario(Funcionario func);

    int removeFuncionario(Funcionario func);

    int updateFuncionario(Funcionario func, String emailFunc, String passFunc, String nomeFunc) ;

    Funcionario getFuncionario(int idFunc);

    //Replica Servidor
    int addReplica(ReplicaServidor replica);

    int removeReplica(ReplicaServidor replica);

    int updateReplica(ReplicaServidor replica, String localizacao) throws InvalidReplicaException;

    ReplicaServidor getReplica(int idReplica);

}