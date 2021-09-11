package ProjetoESII;

import ProjetoESII.Exceptions.InvalidUtilizadorException;


// Mudar nome para leitor (?) para ser diferente?
public class Utilizador {
    private int idUtilizador;
    private String nomeUtilizador;
    private String emailUtilizador;
    private String passwordUtilizador;
    private String estadoUtilizador;

    public Utilizador(int idUtilizador, String nomeUtilizador, String emailUtilizador, String passwordUtilizador, String estadoUtilizador) throws InvalidUtilizadorException {

        if (idUtilizador < 0 || idUtilizador > 1000){
            throw new InvalidUtilizadorException("ID de utilizador inválido");
        }

        if (nomeUtilizador == null || nomeUtilizador.length() >= 20 || nomeUtilizador.equals("")){
            throw new InvalidUtilizadorException("Nome de utilizador inválido");
        }

        if (emailUtilizador == null || emailUtilizador.length() >= 30 || emailUtilizador.equals("")){
            throw new InvalidUtilizadorException("Email de utilizador inválido");
        }

        if (passwordUtilizador == null || passwordUtilizador.length() <= 6 || passwordUtilizador.length() >= 35 || passwordUtilizador.equals("")){
            throw new InvalidUtilizadorException("Password de utilizador inválida");
        }

        if ((estadoUtilizador != "ativo" && estadoUtilizador != "inativo") || estadoUtilizador == null || estadoUtilizador.equals("")){
            throw new InvalidUtilizadorException("Estado de utilizador inválido");
        }


        this.idUtilizador = idUtilizador;
        this.nomeUtilizador = nomeUtilizador;
        this.emailUtilizador = emailUtilizador;
        this.passwordUtilizador = passwordUtilizador;
        this.estadoUtilizador = estadoUtilizador;
    }

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getEmailUtilizador() {
        return emailUtilizador;
    }

    public void setEmailUtilizador(String emailUtilizador) {
        this.emailUtilizador = emailUtilizador;
    }

    public String getPasswordUtilizador() {
        return passwordUtilizador;
    }

    public void setPasswordUtilizador(String passwordUtilizador) {
        this.passwordUtilizador = passwordUtilizador;
    }

    public String getEstadoUtilizador() {
        return estadoUtilizador;
    }

    public void setEstadoUtilizador(String estadoUtilizador) {
        this.estadoUtilizador = estadoUtilizador;
    }
}
