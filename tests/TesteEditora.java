import ProjetoESII.Editora;
import ProjetoESII.Exceptions.InvalidEditoraException;
import ProjetoESII.Exceptions.InvalidUtilizadorException;
import ProjetoESII.Utilizador;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TesteEditora {

    private int idEditora = 1;
    private String nomeEditora = "TopSeller";
    private String morada = "Rua dos Combatentes, Porto";
    private Editora editora;

    //Criar uma editora null
    @Test
    void criarEditoraNull() {
        assertNull(editora);
    }

    //Teste Editora Funcional
    @Test
    void criarEditoraFuncional() throws InvalidEditoraException{
        editora = new Editora(idEditora, nomeEditora, morada);
        assertNotNull(editora);
    }

    @Test
    void criarEditoraIDNegativo() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(-5, nomeEditora, morada);
        });
    }

    //Teste Editora com ID Zero. Não pode acontecer
    @Test
    void criarEditoraIDZero() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(0, nomeEditora, morada);
        });
    }

    //Teste Editora com ID Zero.
    @Test
    void criarEditora0(){
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(0, nomeEditora, morada);
        });
    }

    //Teste Editora c/ ID maior que 1000. Não pode acontecer
    @Test
    void criarEditoraIDMaior1000() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(1005, nomeEditora, morada);
        });
    }

    @Test
    void criarEditoraIDEbookMaior0() throws InvalidEditoraException {
        editora = new Editora(10, nomeEditora, morada);
        assertEquals(10, editora.getIdEditora());
    }

    @Test
    //Teste com os valores limite
    void criarEditoraIDIgual1000() throws InvalidEditoraException {
        editora = new Editora(1000, nomeEditora, morada);
        assertEquals(1000, editora.getIdEditora());
    }

    @Test
    void criarEditoraPrimeiroID() throws InvalidEditoraException {
        editora = new Editora(1, nomeEditora, morada);
        assertEquals(1, editora.getIdEditora());
    }

    //Fim teste IDs
    //Teste Nome

    @Test
    void criarEditoraNomeNull(){
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(idEditora, null, morada);
        });
    }

    @Test
    void criarEditoraNomeVazio() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(idEditora, "", morada);
        });
    }

    @Test
    void criarEditoraNomeLengthMaior() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(idEditora, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE", morada);
        });
    }

    @Test
    void criarEditoraNomeCorreto() throws InvalidEditoraException {
        editora = new Editora(idEditora, "TESTE TESTE", morada);
        assertEquals("TESTE TESTE", editora.getNomeEditora());
    }

    //Fim testes Nome
    //Testes Morada

    @Test
    void criarEditoraMoradaCorreta() throws InvalidEditoraException {
        editora = new Editora(idEditora, nomeEditora, "Rua Professor Elisio");
        assertEquals("Rua Professor Elisio", editora.getMorada());
    }

    @Test
    void criarEditoraMoradaNull(){
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(idEditora, nomeEditora, null);
        });
    }

    @Test
    void criarEditoraMoradaVazia() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(idEditora, nomeEditora, "");
        });
    }

    @Test
    void criarEditoraMoradaLengthMaior() {
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(idEditora, nomeEditora, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE");
        });
    }

}
