package ProjetoESII;

import ProjetoESII.Exceptions.InvalidEmprestimoException;
import ProjetoESII.Exceptions.InvalidExtensaoEmprestimoException;

import java.time.LocalDate;

public class Emprestimo {

    private int id_emprestimo=0;
    private LocalDate data_emprestimo;
    private LocalDate fim_emprestimo;
    private int prolongacao_emprestimo=0;
    private Utilizador utilizador;
    private ProjetoESII.ReplicaServidor replicaServidor;
    private CopiaEBook copiaEBook;
    private int assinatura=0;

    public Emprestimo(int id_emprestimo, LocalDate data_emprestimo, LocalDate fim_emprestimo, Utilizador utilizador , CopiaEBook copiaEBook, int assinatura, int prolongacao_emprestimo) throws InvalidEmprestimoException {
        if (id_emprestimo<=0 || id_emprestimo >=2000)
            throw new InvalidEmprestimoException("Id Emprestimo Invalido");

        if (utilizador.getEstadoUtilizador().equals("inativo") || utilizador==null)
            throw new InvalidEmprestimoException("Utilizador desativado");

        if (data_emprestimo.isEqual(fim_emprestimo))
            throw new InvalidEmprestimoException("Data de inicio do emprestimo igual a data de fim");

        if (data_emprestimo.isBefore(LocalDate.now()) || fim_emprestimo.isBefore(data_emprestimo))
            throw new InvalidEmprestimoException("Data inválida!!");

        if (copiaEBook == null)
            throw new InvalidEmprestimoException("EBook null");

        if (assinatura != 1)
            throw new InvalidEmprestimoException("Assinatura inválida");

        if(prolongacao_emprestimo < 0 || prolongacao_emprestimo > 2)
            throw new InvalidEmprestimoException("Prolongação do empréstimo inválida");

        this.id_emprestimo=id_emprestimo;
        this.data_emprestimo=data_emprestimo;
        this.fim_emprestimo =fim_emprestimo;
        this.utilizador=utilizador;
        this.copiaEBook=copiaEBook;
        this.assinatura=assinatura;
        this.prolongacao_emprestimo=prolongacao_emprestimo;
    }

    //Prolongar o empréstimo
    public void prolongarEmprestimo() throws InvalidExtensaoEmprestimoException {
        if(prolongacao_emprestimo <= 0 || prolongacao_emprestimo > 2){
            throw new InvalidExtensaoEmprestimoException("Prolongação de empréstimo inválida");
        }
        this.prolongacao_emprestimo++;
        this.fim_emprestimo = this.fim_emprestimo.plusMonths(1);
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getFim_emprestimo() {
        return fim_emprestimo;
    }

    public void setFim_emprestimo(LocalDate fim_emprestimo) throws InvalidEmprestimoException {
        if (data_emprestimo.isEqual(fim_emprestimo) || fim_emprestimo.isBefore(data_emprestimo))
            throw new InvalidEmprestimoException("Data de inicio do emprestimo igual a data de fim");
        this.fim_emprestimo = fim_emprestimo;
    }

    public int getProlongacao_emprestimo() {
        return prolongacao_emprestimo;
    }

    public void setProlongacao_emprestimo(int prolongacao_emprestimo) throws InvalidExtensaoEmprestimoException {
        if (prolongacao_emprestimo < 0 || prolongacao_emprestimo > 2) {
            throw new InvalidExtensaoEmprestimoException("Atingiu o limite de prolongações");
        }
        this.prolongacao_emprestimo++;
        this.fim_emprestimo =this.fim_emprestimo.plusMonths(1);
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) throws InvalidEmprestimoException {
        if (utilizador.getEstadoUtilizador().equals("inativo"))
            throw new InvalidEmprestimoException("Utilizador desativado");
        this.utilizador = utilizador;
    }

    public ReplicaServidor getReplicaServidor() {
        return replicaServidor;
    }

    public void setReplicaServidor(ReplicaServidor replicaServidor) throws InvalidEmprestimoException {
        if (replicaServidor==null)
            throw new InvalidEmprestimoException("Replica Servidor Null");
        this.replicaServidor = replicaServidor;
    }

    public CopiaEBook getCopiaEbook() {
        return copiaEBook;
    }

    public void setCopiaEbook(CopiaEBook copiaEBook) throws InvalidEmprestimoException {
        if (copiaEBook==null)
            throw new InvalidEmprestimoException("Copia Ebook null");
        this.copiaEBook = copiaEBook;
    }

    public int getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(int assinatura) {
        this.assinatura = assinatura;
    }

}
