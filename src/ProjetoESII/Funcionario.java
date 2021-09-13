package ProjetoESII;

import ProjetoESII.Exceptions.InvalidFuncionarioException;

public class Funcionario {

    private Integer idFuncionario;
    private String emailFuncionario;
    private String passwordFuncionario;
    private String nomeFuncionario;

    public Funcionario(Integer idFuncionario, String nomeFuncionario, String emailFuncionario, String passwordFuncionario) throws InvalidFuncionarioException{

        if (idFuncionario <= 0 || idFuncionario >= 1000){
            throw new InvalidFuncionarioException("Id de funcionário inválido");
        }

        if (emailFuncionario == null || emailFuncionario.length() > 30 || emailFuncionario.equals("")){
            throw new InvalidFuncionarioException("Email de funcionário inválido");
        }

        if (passwordFuncionario.length() < 7 || passwordFuncionario == null || passwordFuncionario.equals("") || passwordFuncionario.length() >= 30){
            throw new InvalidFuncionarioException("Password de funcionário inválido");
        }

        if(nomeFuncionario == null || nomeFuncionario.length() < 3 || nomeFuncionario.equals("") || nomeFuncionario.length() >= 20){
            throw new InvalidFuncionarioException("Nome de funcionário inválido");
        }

        this.idFuncionario = idFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.passwordFuncionario = passwordFuncionario;
        this.nomeFuncionario = nomeFuncionario;
    }

    public Integer getIdFuncionario() {return idFuncionario;}

    public void setIdFuncionario(Integer idFuncionario) {this.idFuncionario = idFuncionario;}

    public String getEmailFuncionario() {return emailFuncionario;}

    public void setEmailFuncionario(String emailFuncionario) {this.emailFuncionario = emailFuncionario;}

    public String getPasswordFuncionario() {return passwordFuncionario;}

    public void setPasswordFuncionario(String passwordFuncionario) {this.passwordFuncionario = passwordFuncionario;}

    public String getNomeFuncionario() {return nomeFuncionario;}

    public void setNomeFuncionario(String nomeFuncionario) {this.nomeFuncionario = nomeFuncionario;}
}
