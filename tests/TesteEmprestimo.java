import ProjetoESII.*;
import ProjetoESII.Exceptions.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TesteEmprestimo {

    private Editora editora = new Editora(1,"Editora 1","rua da editora 1");
    private Emprestimo emprestimo = null;
    private int id_emprestimo = 1;
    private int prolongacao_emprestimo = 0;
    private LocalDate dataEmprestimo = LocalDate.now();
    private LocalDate fimEmprestimo = LocalDate.now().plusMonths(1);
    private Utilizador user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
    private EBook eBook = new EBook(1, "Paula Hawkins", "pdf", "Um Fogo Lento", "9789895644919", "UmFogoLentoPaulaHawkins", editora, "PT", 1.5f);
    private CopiaEBook copiaEBook = new CopiaEBook(1, eBook);

    private ReplicaServidor replicaServidor_portugal = new ReplicaServidor(1,  "Portugal");
    private Utilizador user_desativado = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "inativo");

    public TesteEmprestimo() throws InvalidEditoraException, InvalidUtilizadorException, InvalidEbookException, InvalidCopiaEBookException, InvalidReplicaException {
    }

    @Test
    void CriarEmprestimoValido() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
        assertEquals(1, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimo_UserDesativado() throws InvalidUtilizadorException{
        user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "inativo");
        assertThrows(InvalidEmprestimoException.class, () -> {
            emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoNull(){
        assertThrows(NullPointerException.class, () ->{
            emprestimo = new Emprestimo(1, null, null, null, null, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimo_IDEmp() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(1, dataEmprestimo, fimEmprestimo, user, copiaEBook,1, prolongacao_emprestimo);
        assertEquals(1, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimo_DataEmp() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
        assertEquals(dataEmprestimo, emprestimo.getData_emprestimo());
    }

    @Test
    void CriarEmprestimo_FimData() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
    }

    @Test
    void CriarEmprestimo_DataInicio_Igual_DataFim(){
        assertThrows(InvalidEmprestimoException.class, () ->{
            emprestimo=new Emprestimo(id_emprestimo, LocalDate.now(), LocalDate.now(), user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoDataInicio_Depois_DataFim(){
        assertThrows(InvalidEmprestimoException.class, () -> {
           emprestimo=new Emprestimo(id_emprestimo, LocalDate.now(), LocalDate.now().minusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoDataInicio_EntreDataAtualeFinal() throws InvalidEmprestimoException {
        emprestimo=new Emprestimo(id_emprestimo, LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(2), user, copiaEBook, 1, prolongacao_emprestimo);
        LocalDate data = LocalDate.now().plusMonths(1);
        assertEquals(data, emprestimo.getData_emprestimo());
    }

    @Test
    void CriarEmprestimoDataInicial_Antes_DataAtual() throws InvalidEmprestimoException {
        assertThrows(InvalidEmprestimoException.class, () -> {
           emprestimo=new Emprestimo(id_emprestimo, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoAssinado() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
    }

    @Test
    void CriarEmprestimoNaoAssinado(){
        assertThrows(InvalidEmprestimoException.class, () ->{
               emprestimo=new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 0, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoInvalido() {
        assertThrows(InvalidEmprestimoException.class, () ->{
            emprestimo=new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 2, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoCopiaEbook() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
        assertEquals(1, emprestimo.getCopiaEbook().getId_copia());
        assertEquals("Um Fogo Lento", emprestimo.getCopiaEbook().geteBook().getTitulo());
    }

    @Test
    void CriarEmprestimoCopiaEbookNull() {
        assertThrows(InvalidEmprestimoException.class, () -> {
            emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, null, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoIdValido() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(1, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        assertEquals(1, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimoIdMenor0() {
        assertThrows(InvalidEmprestimoException.class, () -> {
            emprestimo = new Emprestimo(-1, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoId0() {
        assertThrows(InvalidEmprestimoException.class, () -> {
            emprestimo = new Emprestimo(0, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        });

    }

    @Test
    void CriarEmprestimoIDMaiorMax() {
        assertThrows(InvalidEmprestimoException.class, () -> {
            emprestimo = new Emprestimo(2001, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoIDMax() {
        assertThrows(InvalidEmprestimoException.class, () -> {
            emprestimo = new Emprestimo(2000, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        });
    }

    @Test
    void CriarEmprestimoIDMenorMax() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(1999, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);
        assertEquals(1999, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimoReplicaNull() throws InvalidEmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmprestimo, fimEmprestimo, user, copiaEBook, 1, prolongacao_emprestimo);
        assertThrows(InvalidEmprestimoException.class, () -> {
           emprestimo.setReplicaServidor(null);
        });
    }


    @BeforeAll
    static void set() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown1() {
    }

    @AfterAll
    static void tearDown() {
    }
}
