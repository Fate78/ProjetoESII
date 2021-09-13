package ProjetoESII;

import ProjetoESII.Exceptions.InvalidPermissaoLeituraException;

import java.time.*;

public class PermissaoLeitura {
    private Emprestimo emprestimo;
    private String estadoUtilizador;
    private LocalDate dataAtual;

    public boolean validarLeitura(Emprestimo emprestimo, LocalDate dataAtual) throws InvalidPermissaoLeituraException {
        this.emprestimo = emprestimo;
        estadoUtilizador = emprestimo.getUtilizador().getEstadoUtilizador();

        if(dataAtual.isBefore(emprestimo.getData_emprestimo()) || dataAtual.isAfter(emprestimo.getFim_emprestimo()) || estadoUtilizador.equals("inativo")){
            throw new InvalidPermissaoLeituraException("Permissão de leitura inválida");
        }
        return true;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public String getEstadoUtilizador() {
        return estadoUtilizador;
    }

    public void setEstadoUtilizador(String estadoUtilizador) {
        this.estadoUtilizador = estadoUtilizador;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }
}


