package ProjetoESII;

import ProjetoESII.Exceptions.InvalidFraudeException;
import java.time.LocalDate;

public class Fraude {

    private int id_fraude;
    private Emprestimo emprestimo;
    private Funcionario funcionario;
    private LocalDate dataFraude;

    public Fraude(int id_fraude, Emprestimo emprestimo, Funcionario funcionario) throws InvalidFraudeException{

        if(id_fraude <= 0 || id_fraude >= 1000) {
            throw new InvalidFraudeException("Id de Fraude inválido");
        }

        if(funcionario == null) {
            throw new InvalidFraudeException("Funcionário inválido");
        }

        if (emprestimo == null) {
            throw new InvalidFraudeException("Empréstimo Inválido");
        }


        this.id_fraude = id_fraude;
        this.emprestimo = emprestimo;
        this.funcionario = funcionario;
        this.dataFraude = LocalDate.now();
    }

    public int getId_fraude() {
        return id_fraude;
    }

    public void setId_fraude(int id_fraude) {
        this.id_fraude = id_fraude;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataFraude() {
        return dataFraude;
    }

    public void setDataFraude(LocalDate dataFraude) {
        this.dataFraude = dataFraude;
    }
}
