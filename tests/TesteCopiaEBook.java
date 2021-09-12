import ProjetoESII.CopiaEBook;
import ProjetoESII.EBook;
import ProjetoESII.Editora;
import ProjetoESII.Exceptions.InvalidCopiaEBookException;
import ProjetoESII.Exceptions.InvalidEbookException;
import ProjetoESII.Exceptions.InvalidEditoraException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteCopiaEBook {
    private Editora editora = new Editora(1,"Editora 1","rua da editora 1");
    private String ISBN = "978-3-16-148410-0";
    private String autor = "Christopher Paolini";
    private String titulo = "Eragon";
    private String formato = "pdf";
    private float fileSize = 255.f;
    private String assinatura = "Signature Eragon";
    private String idioma = "portugues";
    private EBook eBook = new EBook(1, autor, formato, titulo, ISBN, assinatura, editora, idioma, fileSize);
    private int idCopia = 1;
    private CopiaEBook copiaEBook = null;

    public TesteCopiaEBook() throws InvalidEbookException, InvalidEditoraException {
    }

    @Test
    void CriarCopiaEBookNull() {
        assertNull(copiaEBook);
    }

    @Test
    void CriarCopiaEBookValida() throws InvalidCopiaEBookException {
        copiaEBook = new CopiaEBook(idCopia, eBook);
        assertNotNull(copiaEBook);
    }

    @Test
    void CriarCopiaEBookIdValido() throws InvalidCopiaEBookException {
        copiaEBook = new CopiaEBook(1, eBook);
        assertEquals(1,copiaEBook.getId_copia());
    }

    @Test
    void CriarCopiaEBookIdMaiorMax() {
        assertThrows(InvalidCopiaEBookException.class, () -> {
            copiaEBook = new CopiaEBook(2001, eBook);
        });
    }

    @Test
    void CriarCopiaEBookIdIgualMax() {
        assertThrows(InvalidCopiaEBookException.class, () -> {
            copiaEBook = new CopiaEBook(2001, eBook);
        });
    }

    @Test
    void CriarCopiaEBookIdMenorMax() throws InvalidCopiaEBookException {
        copiaEBook = new CopiaEBook(1999, eBook);
        assertEquals(1999,copiaEBook.getId_copia());
    }

    @Test
    void CriarCopiaEBookId0_EbookNull() {
        assertThrows(InvalidCopiaEBookException.class, () -> {
            copiaEBook = new CopiaEBook(0, null);
        });
    }

    @Test
    void CriarCopiaEBookId0_EBookValido() {
        assertThrows(InvalidCopiaEBookException.class, () -> {
            copiaEBook = new CopiaEBook(0, eBook);
        });
    }

    @Test
    void CriarCopiaEBookIdMenor0_EbookValido() {
        assertThrows(InvalidCopiaEBookException.class, () -> {
            copiaEBook = new CopiaEBook(-1, eBook);
        });
    }

    @Test
    void CriarCopiaEBookIdMenor0_EBookInvalido() {
        assertThrows(InvalidCopiaEBookException.class, () -> {
            copiaEBook = new CopiaEBook(-1, null);
        });
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void AfterEach() {
    }

    @AfterAll
    static void AfterAll() {
    }
}
