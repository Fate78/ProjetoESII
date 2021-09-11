/*
import ProjetoESII.Editora;
import ProjetoESII.Exceptions.InvalidEbookException;
import ProjetoESII.Exceptions.InvalidEditoraException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TesteEbook {

    private Editora editora = new Editora(1, "TopSeller");
    private Ebook ebook = null;

    private int idEbook = 1;
    private String autor = "Paula Hawkins";
    private String formato = "pdf";
    private String titulo = "Um Fogo Lento";
    private String ISBN = "9789895644919";
    private String hash = "UmFogoLentoPaulaHawkins";
    private float tamanhoFicheiro = 1.5f;
    public TesteEbook() throws InvalidEditoraException { }


    @BeforeEach
    void setUp() {
    }

    //O primeiro teste passa por criar um ebook que corresponda a tudo o que é pedido
    @Test
    void criarEbookFuncional() throws InvalidEbookException {
        ebook = new Ebook(idEbook, autor, formato, titulo, ISBN, hash, editora, tamanhoFicheiro);
        assertNotNull(ebook);
    }

    @AfterEach
    void tearDown1() {
    }

    @AfterAll
    static void tearDown() {
    }


}
*/
