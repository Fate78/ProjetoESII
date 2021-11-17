import ProjetoESII.Editora;
import ProjetoESII.EBook;
import ProjetoESII.Exceptions.InvalidEbookException;
import ProjetoESII.Exceptions.InvalidEditoraException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TesteEbook {

    private Editora editora = new Editora(1, "TopSeller", "Rua 1.º de Maio, 226");
    private EBook ebook;

    private int idEbook = 1;
    private String autor = "Paula Hawkins";
    private String formato = "pdf";
    private String titulo = "Um Fogo Lento";
    private String ISBN = "9789895644919";
    private String hash = "UmFogoLentoPaulaHawkins";
    private String idioma = "PT";
    private float tamanhoFicheiro = 1.5f;

    public TesteEbook() throws InvalidEditoraException {
    }


    //O primeiro teste passa por criar um ebook que corresponda a tudo o que é pedido
    @Test
    void criarEbookFuncional() throws InvalidEbookException {
        ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertNotNull(ebook);
    }

    @Test
    void criarEbookFuncional2() throws InvalidEbookException {
        ebook = new EBook(1, "Christopher Paolini", "pdf", "Eragon", "978-3-16-148410-0", "Signature Eragon", editora, "Portugues", 15.0f);
        assertNotNull(ebook);
    }


    //Teste ID Ebook
    @Test
    void criarEbookIDValido() throws InvalidEbookException {
        ebook = new EBook(5, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertNotNull(ebook);
    }

    @Test
    void criarEbookIdNegativo() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(-5, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookIdMaior2000() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(2005, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookId0() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(0, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookIdLimiteMaximo() throws InvalidEbookException{
        ebook = new EBook(1999, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertEquals(1999, ebook.getIdEbook());
    }

    @Test
    void criarEbookIdLimiteMinimo() throws InvalidEbookException{
        ebook = new EBook(1, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertEquals(1, ebook.getIdEbook());
    }


    //Fim testes ID

    //Testes autor

    @Test
    void criarEbookAutorValido() throws InvalidEbookException {
        ebook = new EBook(idEbook, "TESTE TESTE TESTE", formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertNotNull(ebook);
    }

    @Test
    void criarEbookAutorNull() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, null, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookAutorVazio() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, "", formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookAutorMenos3() {
            assertThrows(InvalidEbookException.class, () -> {
                ebook = new EBook(idEbook, "Ze", formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
            });
    }

    @Test
    void criarEbookAutorMaior20() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, "TESTE TESTE TESTE TESTE TESTE", formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    //Fim testes autor

    //Testes formato - pdf e epub

    @Test
    void criarEbookFormatoPDF() throws InvalidEbookException{
        ebook = new EBook(idEbook, autor, "pdf", titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertEquals("pdf", ebook.getFormato());
    }

    @Test
    void criarEbookFormatoEPUB() throws InvalidEbookException{
        ebook = new EBook(idEbook, autor, "epub", titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertEquals("epub", ebook.getFormato());
    }

    @Test
    void criarEbookFormatoNull() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, null, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookFormatoVazio() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, "", titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookFormatoDiferente() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, "FormatoTeste", titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    //Fim teste formato

    //Teste titulo - Serve de igual forma para isbn, hash, editora e idioma
    @Test
    void criarEbookTituloValido() throws InvalidEbookException{
        ebook = new EBook(idEbook, autor, formato, "TESTE TESTE", ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertEquals("TESTE TESTE", ebook.getTitulo());
    }

    @Test
    void criarEbookTituloNull() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, formato, null, ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookTituloVazio() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, formato, "", ISBN, hash, editora, idioma, tamanhoFicheiro);
        });
    }

    //Fim teste titulo - Serve de igual forma para isbn, hash, editora e idioma

    //Teste tamanhoFicheiro
    @Test
    void criarEbookTamanhoValido() throws InvalidEbookException{
        ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, 15.0f);
        assertEquals(15.0f, ebook.getTamanhoFicheiro());
    }

    @Test
    void criarEbookTamanhoSuperior(){
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, 100f);
        });
    }

    @Test
    void criarEbookTamanhoNegativo() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, -5f);
        });
    }

    @Test
    void criarEbookTamanhoZero() throws InvalidEbookException{
        ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, 0f);
        assertEquals(0f, ebook.getTamanhoFicheiro());
    }

    @Test
    void criarEbookTamanhoMaximo() throws InvalidEbookException{
        ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, 30f);
        assertEquals(30f, ebook.getTamanhoFicheiro());
    }

    //Fim testes tamanho

    //Criar um ebook null
    @Test
    void createEbookNull() {
        assertNull(ebook);
    }


    //Assinaturas
    @Test
    void criarEbookAssinaturaNull() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, formato, titulo, ISBN, null, editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookAssinaturaVazio() {
        assertThrows(InvalidEbookException.class, () -> {
            ebook = new EBook(idEbook, autor, formato, titulo, ISBN, "", editora, idioma, tamanhoFicheiro);
        });
    }

    @Test
    void criarEbookAssinaturaOk() throws InvalidEbookException {
        ebook = new EBook(idEbook, autor, formato, titulo, ISBN, hash, editora, idioma, tamanhoFicheiro);
        assertEquals("UmFogoLentoPaulaHawkins", ebook.getHash());
    }
}
