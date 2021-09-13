package ProjetoESII;

import ProjetoESII.Exceptions.InvalidEbookException;

public class EBook {

    private int idEbook;
    private String autor;
    private String formato;
    private String titulo;
    private String ISBN;
    private String assinatura;
    private Editora editora;
    private String idioma;
    private float tamanhoFicheiro;

    public EBook(int idEbook, String autor, String formato, String titulo, String ISBN, String assinatura, Editora editora, String idioma, float tamanhoFicheiro) throws InvalidEbookException{

        if (idEbook <= 0 || idEbook > 2000) {
            throw new InvalidEbookException("Id do Ebook inválido");
        }

        if (autor == null || autor.equals("") || autor.length() < 3 || autor.length() >= 20){
            throw new InvalidEbookException("Autor do Ebook inválido");
        }

        if (formato != "pdf" && formato != "epub"){
            throw new InvalidEbookException("Formato do Ebook inválido");
        }

        if (titulo == null || titulo.equals("")){
            throw new InvalidEbookException("Titulo do Ebook nulo");
        }

        if (ISBN == null || ISBN.equals("")){
            throw new InvalidEbookException("ISBN do Ebook inválido");
        }

        if (assinatura == null || assinatura.equals("")){
            throw new InvalidEbookException("Assinatura do Ebook inválido");
        }

        if (editora == null || editora.equals("")){
            throw new InvalidEbookException("Editora do Ebook inválida");
        }

        if (idioma == null || idioma.equals("")) {
            throw new InvalidEbookException("Idioma do Ebook inválido");
        }

        if (tamanhoFicheiro < 0 || tamanhoFicheiro > 30.0f){
            throw new InvalidEbookException("Tamanho do ficheiro do Ebook inválido");
        }

        this.idEbook = idEbook;
        this.autor = autor;
        this.formato = formato;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.assinatura = assinatura;
        this.editora = editora;
        this.tamanhoFicheiro = tamanhoFicheiro;
        this.idioma = idioma;

    }

    public int getIdEbook() { return idEbook; }

    public void setIdEbook(int idEbook) { this.idEbook = idEbook; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getFormato() { return formato; }

    public void setFormato(String formato) { this.formato = formato; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getISBN() { return ISBN; }

    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public String getHash() { return assinatura; }

    public void setHash(String assinatura) { this.assinatura = assinatura; }

    public Editora getEditora() { return editora; }

    public void setEditora(Editora editora) { this.editora = editora; }

    public float getTamanhoFicheiro() { return tamanhoFicheiro; }

    public void setTamanhoFicheiro(float tamanhoFicheiro) { this.tamanhoFicheiro = tamanhoFicheiro; }

    public String getIdioma() { return idioma;}

    public void setIdioma(String idioma) { this.idioma = idioma; }

}
