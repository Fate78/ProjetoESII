package ProjetoESII;

import ProjetoESII.Exceptions.EmprestimoException;
import ProjetoESII.Exceptions.ExtensaoEmprestimoException;

import java.time.LocalDate;

public class Emprestimo {

    private int id_emprestimo=0;
    private LocalDate data_emprestimo;
    private LocalDate fimdata_emprestimo;
    private int extensao_emprestimo=0;
    private Utilizador utilizador;
    private ProjetoESII.ReplicaServidor replicaServidor;
    private CopiaEBook copiaEbook;
    private int assinatura=0;

    public Emprestimo(int id_emprestimo, LocalDate data_emprestimo, LocalDate fimdata_emprestimo, Utilizador utilizador , CopiaEBook copiaEBook, int assinatura) throws EmprestimoException {
        if (id_emprestimo<=0 || id_emprestimo >=2000)
            throw new EmprestimoException("Id Emprestimo Invalido");

        if (utilizador.getEstadoUtilizador().equals(false) || utilizador==null)
            throw new EmprestimoException("Utilizador desativado");

        if (data_emprestimo.isEqual(fimdata_emprestimo))
            throw new EmprestimoException("Data de inicio do emprestimo igual a data de fim");

        if (data_emprestimo.isBefore(LocalDate.now()) || fimdata_emprestimo.isBefore(data_emprestimo))
            throw new EmprestimoException("Data inválida!!");

        if (copiaEbook == null)
            throw new EmprestimoException("EBook null");

        this.id_emprestimo=id_emprestimo;
        this.data_emprestimo=data_emprestimo;
        this.fimdata_emprestimo=fimdata_emprestimo;
        this.utilizador=utilizador;
        this.copiaEbook=copiaEbook;
        this.assinatura=assinatura;
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

    public LocalDate getFimdata_emprestimo() {
        return fimdata_emprestimo;
    }

    public void setFimdata_emprestimo(LocalDate fimdata_emprestimo) throws EmprestimoException{
        if (data_emprestimo.isEqual(fimdata_emprestimo) || fimdata_emprestimo.isBefore(data_emprestimo))
            throw new EmprestimoException("Data de inicio do emprestimo igual a data de fim");
        this.fimdata_emprestimo = fimdata_emprestimo;
    }

    public int getExtensao_emprestimo() {
        return extensao_emprestimo;
    }

    public void setExtensao_emprestimo(int extensao_emprestimo) throws ExtensaoEmprestimoException {
        if (extensao_emprestimo<0 || extensao_emprestimo>100) {
            System.out.println("Atingiu o limite de extensões");
            throw new ExtensaoEmprestimoException("Atingiu o limite de extensões");
        }
        this.extensao_emprestimo++;
        this.fimdata_emprestimo=this.fimdata_emprestimo.plusMonths(1);
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) throws EmprestimoException{
        if (utilizador.getEstadoUtilizador().equals(false))
            throw new EmprestimoException("Utilizador desativado");
        this.utilizador = utilizador;
    }

    public ReplicaServidor getReplicaServidor() {
        return replicaServidor;
    }

    public void setReplicaServidor(ReplicaServidor replicaServidor) throws EmprestimoException{
        if (replicaServidor==null)
            throw new EmprestimoException("Replica Servidor Null");
        this.replicaServidor = replicaServidor;
    }

    public CopiaEBook getCopiaEbook() {
        return copiaEbook;
    }

    public void setCopiaEbook(CopiaEBook copiaEbook) throws EmprestimoException{
        if (copiaEbook==null)
            throw new EmprestimoException("Copia Ebook null");
        this.copiaEbook = copiaEbook;
    }

    public int getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(int assinatura) {
        this.assinatura = assinatura;
    }
}
