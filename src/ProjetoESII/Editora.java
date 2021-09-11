package ProjetoESII;

import ProjetoESII.Exceptions.InvalidEditoraException;

public class Editora {

    private int idEditora;
    private String nomeEditora;
    private String morada;

    public Editora(int idEditora, String nomeEditora, String morada) throws InvalidEditoraException{

        if (idEditora < 1 || idEditora > 1000) {
            throw new InvalidEditoraException("Id de editora inválido");
        }

        if (nomeEditora == null || nomeEditora.length() <= 5 || nomeEditora.length() >= 25 || nomeEditora.equals("")){
            throw new InvalidEditoraException("Nome de editora inválido");
        }

        if (morada == null || morada.length() <= 15 || morada.equals("") || morada.length() >= 35){
            throw new InvalidEditoraException("Morada da editora inválida");
        }

        this.idEditora = idEditora;
        this.nomeEditora = nomeEditora;
        this.morada = morada;
    }

    public int getIdEditora() { return idEditora; }

    public void setIdEditora(Integer idEditora) { this.idEditora = idEditora; }

    public String getNomeEditora() { return nomeEditora; }

    public void setNomeEditora(String nomeEditora) { this.nomeEditora = nomeEditora; }

    public String getMorada() { return morada; }

    public void setMorada(String morada) { this.nomeEditora = nomeEditora; }
}
