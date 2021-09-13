import ProjetoESII.*;
import ProjetoESII.Exceptions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class TesteFraude {

    private Editora editora = new Editora(1,"Editora 1","rua da editora 1");
    private LocalDate dataEmp = LocalDate.now();
    private LocalDate fimDataEmp = LocalDate.now().plusMonths(1);
    private int prolongacao_emprestimo = 0;
    private Utilizador user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
    private EBook eBook = new EBook(1, "Paula Hawkins", "pdf", "Um Fogo Lento", "9789895644919", "UmFogoLentoPaulaHawkins", editora, "PT", 1.5f);
    private CopiaEBook copiaEBook = new CopiaEBook(1, eBook);
    private Emprestimo emprestimo = new Emprestimo(1, dataEmp, fimDataEmp, user, copiaEBook, 1, prolongacao_emprestimo);
    private Funcionario funcionario = new Funcionario(1, "Artur", "artur@teste.com", "Passw0rd");
    private int id_fraude = 1;
    private Fraude fraude = new Fraude(id_fraude, emprestimo, funcionario);

    public TesteFraude() throws InvalidFraudeException, InvalidEbookException, InvalidCopiaEBookException, InvalidEmprestimoException, InvalidFuncionarioException, InvalidEditoraException, InvalidUtilizadorException{}

    @Test
    void criarFraudeValida() {
        assertNotNull(fraude);
    }

    @Test
    void criarFraudeId0() {
        assertThrows(InvalidFraudeException.class, () -> {
            fraude = new Fraude(0, emprestimo, funcionario);
        });
    }

    @Test
    void criarFraudeIdMinimo() throws InvalidFraudeException{
        fraude = new Fraude(1, emprestimo, funcionario);
        assertEquals(1, fraude.getId_fraude());
    }

    @Test
    void criarFraudeIdMaximo() throws InvalidFraudeException{
        fraude = new Fraude(999, emprestimo, funcionario);
        assertEquals(999, fraude.getId_fraude());
    }

    @Test
    void criarFraudeId1000() {
        assertThrows(InvalidFraudeException.class, () -> {
            fraude = new Fraude(1000, emprestimo, funcionario);
        });
    }

    //Testar a partir daqui
    @Test
    void criarFraudeIdNegativo() {
        assertThrows(InvalidFraudeException.class, () -> {
            fraude = new Fraude(-1, emprestimo, funcionario);
        });
    }

    @Test
    void criarFraudeEmprestimoNull() {
        assertThrows(InvalidFraudeException.class, () -> {
            fraude = new Fraude(id_fraude, null, funcionario);
        });
    }


    @Test
    void criarFraudeFuncionarioNull() {
        assertThrows(InvalidFraudeException.class, () -> {
            fraude = new Fraude(id_fraude, emprestimo, null);
        });
    }


    @Test
    void criarFraudeNull(){
        fraude = null;
        assertNull(fraude);
    }

}
