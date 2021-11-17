package ProjetoESII.stubDB;


import ProjetoESII.*;
import ProjetoESII.Exceptions.InvalidEmprestimoException;
import ProjetoESII.Exceptions.InvalidExtensaoEmprestimoException;
import ProjetoESII.Exceptions.InvalidReplicaException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBAdapterStub implements InterfaceDB {

    private ArrayList<Utilizador> utilizadores = new ArrayList<>();
    private ArrayList<EBook> ebooks = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private ArrayList<Editora> editoras = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<ReplicaServidor> replicaServidores = new ArrayList<>();


    //User
    @Override
    public int addUser(Utilizador u) {
        if (u == null) return -1;
        utilizadores.add(u);
        return u.getIdUtilizador();
    }

    @Override
    public int removeUser(Utilizador u) {
        if (utilizadores.contains(u)) {
            utilizadores.remove(u);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUser(Utilizador u, String n, String e, String p, String es) {
        if (u == null || n == null || n.equals("") || p == null || p.equals("") || e == null || e.equals("") || es == null || es.equals("")) {
            return 0;
        }
        if (utilizadores.contains(u)) {
            int idx = utilizadores.indexOf(u);
            u.setNomeUtilizador(n);
            u.setEmailUtilizador(e);
            u.setPasswordUtilizador(p);
            u.setEstadoUtilizador(es);
            utilizadores.set(idx, u);
            return u.getIdUtilizador();
        }
        return 0;
    }

    @Override
    public Utilizador getUser(int id) {
        for (Utilizador u : utilizadores) {
            if (u.getIdUtilizador() == id) return u;
        }
        return null;
    }

    @Override
    public Utilizador loginUser(String email, String password) {
        if (email == null || email.equals("") || password == null || password.equals("")) {
            return null;
        }
        for (Utilizador u : utilizadores) {
            if (u.getEmailUtilizador().equals(email) && u.getPasswordUtilizador().equals(password))
                return u;
        }
        return null;
    }

    //EBook

    @Override
    public int addEbook(EBook ebook) {
        if (ebook == null) return -1;
        ebooks.add(ebook);
        return ebook.getIdEbook();
    }

    @Override
    public int removeEbook(EBook ebook) {
        if (ebooks.contains(ebook)) {
            ebooks.remove(ebook);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateEbook(EBook ebook, String autor, String formato, String titulo, String ISBN, String assinatura, Editora editora, String idioma, Float tamanhoFicheiro) {
        if (ebook == null || autor == null || autor.equals("") || formato == null || formato.equals("") || titulo == null || titulo.equals("") || ISBN == null || ISBN.equals("") || assinatura == null || assinatura.equals("") || editora == null || editora.equals("") || idioma == null || idioma.equals("") || tamanhoFicheiro == null)
            return 0;

        if (ebooks.contains(ebook)) {
            int idx = ebooks.indexOf(ebook);
            ebook.setAutor(autor);
            ebook.setFormato(formato);
            ebook.setTitulo(titulo);
            ebook.setISBN(ISBN);
            ebook.setHash(assinatura);
            ebook.setEditora(editora);
            ebook.setIdioma(idioma);
            ebook.setTamanhoFicheiro(tamanhoFicheiro);
            ebooks.set(idx, ebook);
            return ebook.getIdEbook();
        }
        return 0;
    }

    @Override
    public EBook getEbook(int idEbook) {
        for (EBook eBook : ebooks) {
            if (eBook.getIdEbook() == idEbook) return eBook;
        }
        return null;
    }


    //Emprestimo
    @Override
    public int addEmprestimo(Emprestimo emp) {
        if (emp == null) return -1;
        emprestimos.add(emp);
        return emp.getId_emprestimo();
    }

    @Override
    public int removeEmprestimo(Emprestimo emp) {
        if (emprestimos.contains(emp)) {
            emprestimos.remove(emp);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateEmprestimo(Emprestimo emp, LocalDate data_ini, LocalDate data_fim, int prolongacao, Utilizador user, ReplicaServidor replicaServidor, CopiaEBook copiaEBook, int assinatura) throws InvalidEmprestimoException, InvalidExtensaoEmprestimoException {
        if (emp == null || data_ini == null || data_fim == null || user == null || replicaServidor == null)
            return 0;

        if (emprestimos.contains(emp)) {
            int idx = emprestimos.indexOf(emp);
            emp.setProlongacao_emprestimo(prolongacao);
            emp.setUtilizador(user);
            emp.setData_emprestimo(data_ini);
            emp.setFim_emprestimo(data_fim);
            emp.setReplicaServidor(replicaServidor);
            emp.setCopiaEbook(copiaEBook);
            emp.setAssinatura(assinatura);
            return emp.getId_emprestimo();
        }
        return 0;
    }

    @Override
    public Emprestimo getEmprestimo(int idEmp) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId_emprestimo() == idEmp) return emprestimo;
        }
        return null;
    }

    @Override
    public EBook getEbookFromEmprestimo(int idEmp) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId_emprestimo() == idEmp) return emprestimo.getCopiaEbook().geteBook();
        }
        return null;
    }

    @Override
    public Utilizador getUtilizadorFromEmprestimo(int idEmp) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId_emprestimo() == idEmp) return emprestimo.getUtilizador();
        }
        return null;
    }

    @Override
    public ReplicaServidor getReplicaFromEmprestimo(int idEmp) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId_emprestimo() == idEmp) return emprestimo.getReplicaServidor();
        }
        return null;
    }

    // Editora
    @Override
    public int addEditora(Editora edit) {
        if (edit == null) return -1;
        editoras.add(edit);
        return edit.getIdEditora();
    }

    @Override
    public int removeEditora(Editora edit) {
        if (editoras.contains(edit)) {
            editoras.remove(edit);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateEditora(Editora edit, String nomeEditora, String morada) {
        if (edit == null || nomeEditora == null || nomeEditora.equals("") || morada == null || morada.equals(""))
            return 0;

        if (editoras.contains(edit)) {
            int idx = editoras.indexOf(edit);
            edit.setNomeEditora(nomeEditora);
            edit.setMorada(morada);
            return edit.getIdEditora();
        }
        return 0;
    }

    @Override
    public Editora getEditora(int idEdit) {
        for (Editora editora: editoras) {
            if (editora.getIdEditora() == idEdit) return editora;
        }
        return null;
    }

    //Funcionario
    @Override
    public int addFuncionario(Funcionario func) {
        if (func == null) return -1;
        funcionarios.add(func);
        return func.getIdFuncionario();
    }

    @Override
    public int removeFuncionario(Funcionario func) {
        if (funcionarios.contains(func)) {
            funcionarios.remove(func);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateFuncionario(Funcionario func, String emailFunc, String passFunc, String nomeFunc) {
        if (func == null || emailFunc == null || emailFunc.equals("") || passFunc == null || passFunc.equals("") || nomeFunc == null || nomeFunc.equals(""))
            return 0;

        if (funcionarios.contains(func)) {
            int idx = funcionarios.indexOf(func);
            func.setEmailFuncionario(emailFunc);
            func.setPasswordFuncionario(passFunc);
            func.setNomeFuncionario(nomeFunc);
            return func.getIdFuncionario();
        }
        return 0;
    }

    @Override
    public Funcionario getFuncionario(int idFunc) {
        for (Funcionario funcionario: funcionarios) {
            if (funcionario.getIdFuncionario() == idFunc) return funcionario;
        }
        return null;
    }

    //Replica Servidor
    @Override
    public int addReplica(ReplicaServidor replica) {
        if (replica == null) return -1;
        replicaServidores.add(replica);
        return replica.getId_replicaServidor();
    }

    @Override
    public int removeReplica(ReplicaServidor replica){
        if (replicaServidores.contains(replica)) {
            replicaServidores.remove(replica);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateReplica(ReplicaServidor replica, String localizacao) throws InvalidReplicaException {
        if (replica == null || localizacao == null || localizacao.equals(""))
            return 0;

        if (replicaServidores.contains(replica)) {
            int idx = funcionarios.indexOf(replica);
            replica.setLocalização_ReplicaServidor(localizacao);
            return replica.getId_replicaServidor();
        }
        return 0;
    }

    @Override
    public ReplicaServidor getReplica(int idReplica) {
        for (ReplicaServidor replicaServidor: replicaServidores) {
            if (replicaServidor.getId_replicaServidor() == idReplica) return replicaServidor;
        }
        return null;
    }

}
