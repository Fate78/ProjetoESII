import ProjetoESII.Editora;
import ProjetoESII.Exceptions.InvalidEditoraException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TesteEditora {

    private int idEditora = 1;
    private String nomeEditora = "TopSeller";
    private String morada = "Rua dos Combatentes, Porto";
    private Editora editora;

    //Teste Editora Funcional
    @Test
    void criarEditoraFuncional() throws InvalidEditoraException{
        editora = new Editora(idEditora, nomeEditora, morada);
        assertNotNull(editora);
    }

    //Teste aos IDS
    //Teste Editora com ID Negativo. Não pode acontecer
    //Não percebo se o teste é suposto falhar e mostrar o erro, ou arranjarmos forma de passar
    @Test
    void criarEditoraIDNegativo() throws InvalidEditoraException {
        editora = new Editora(-5, nomeEditora, morada);
        assertNotNull(editora);
    }

    //Teste Editora com ID Zero. Não pode acontecer
    @Test
    void criarEditoraIDZero() throws InvalidEditoraException {
        editora = new Editora(0, nomeEditora, morada);
        assertNotNull(editora);
    }

    //Teste Editora com ID Zero. Não pode acontecer (Feito de outra forma do de cima)
    @Test
    void criarEditora0(){
        assertThrows(InvalidEditoraException.class, () -> {
            editora = new Editora(0, nomeEditora, morada);
        });
    }

    //Teste Editora c/ ID maior que 1000. Não pode acontecer
    @Test
    void criarEditoraIDMaior1000() throws InvalidEditoraException {
        editora = new Editora(1005, nomeEditora, morada);
        assertNotNull(editora);
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
    void criarEditoraNomeNull() throws InvalidEditoraException{
        editora = new Editora(100, null, morada);
    }

    @Test
    void criarEditoraNomeVazio() throws InvalidEditoraException {
        editora = new Editora(100, "", morada);
    }

    @Test
    void criarEditoraNomeLengthMaior() throws InvalidEditoraException {
        editora = new Editora(100, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE", morada);
    }

    @Test
    void criarEditoraNomeCorreto() throws InvalidEditoraException {
        editora = new Editora(100, "TESTE TESTE", morada);
    }

    //Fim testes Nome
    //Testes Morada

    @Test
    void criarEditoraMoradaCorreta() throws InvalidEditoraException {
        editora = new Editora(100, nomeEditora, "Rua Professor Elisio");
    }

    @Test
    void criarEditoraMoradaNull() throws InvalidEditoraException {
        editora = new Editora(100, nomeEditora, null);
    }

    @Test
    void criarEditoraMoradaVazia() throws InvalidEditoraException {
        editora = new Editora(100, nomeEditora, "");
    }

    @Test
    void criarEditoraMoradaLengthMaior() throws InvalidEditoraException {
        editora = new Editora(100, nomeEditora, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE");
    }

}
