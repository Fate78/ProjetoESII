package ProjetoESII;

import ProjetoESII.Exceptions.InvalidCopiaEBookException;

public class CopiaEBook {
    private int id_copia;
    private EBook eBook;

    public CopiaEBook(int id_copia, EBook eBook) throws InvalidCopiaEBookException{

        if (id_copia<=0 || id_copia>=2000)
            throw new InvalidCopiaEBookException("ID Copia Ebook Inválido");

        if (eBook==null)
            throw new InvalidCopiaEBookException("Copia Ebook Nula");

        this.id_copia=id_copia;
        this.eBook=eBook;
    }

    public int getId_copia(){return id_copia;}

    public EBook geteBook(){return eBook;}

    public void setId_copia(int id_copia) throws InvalidCopiaEBookException {
        if(id_copia<=0)
            throw new InvalidCopiaEBookException("ID Copia Ebook Inválido");
        this.id_copia=id_copia;
    }

    public void seteBook(EBook ebook) throws InvalidCopiaEBookException {
        if (eBook==null)
            throw new InvalidCopiaEBookException("ID Copia Ebook Inválido");
        this.eBook=eBook;
    }
}
