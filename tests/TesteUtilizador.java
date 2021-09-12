import ProjetoESII.Exceptions.InvalidEbookException;
import ProjetoESII.Exceptions.InvalidUtilizadorException;
import ProjetoESII.Utilizador;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUtilizador {

    private int idUtilizador = 1;
    private String nomeUtilizador = "UtilizadorES2";
    private String emailUtilizador = "utilizadorES2@teste.com";
    private String passwordUtilizador = "trabalhofinales2";
    private String estadoUtilizador = "ativo";
    private Utilizador utilizador;

    @Test
    void criarUtilizadorValido() throws InvalidUtilizadorException{
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    //Testes ao idUtilizador
    @Test
    void criarUtilizadorIdValido() throws InvalidUtilizadorException{
        utilizador = new Utilizador(5, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorIdNegativo() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(-5, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorIdMaior1000() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(1005, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorIdIgual1000() throws InvalidUtilizadorException {
        utilizador = new Utilizador(1000, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertEquals(1000, utilizador.getIdUtilizador());
    }

    @Test
    void criarUtilizadorIdIgual1() throws  InvalidUtilizadorException {
        utilizador = new Utilizador(1, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertEquals(1, utilizador.getIdUtilizador());
    }


    //Fim testes ID
    //Testes nomeUtilizador

    @Test
    void criarUtilizadorNomeValido() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, "Teste Teste", emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorNomeNull() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, null, emailUtilizador, passwordUtilizador, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorNomeVazio() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, "", emailUtilizador, passwordUtilizador, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorNomeMaior20(){
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, "TESTE TESTE TESTE TESTE TESTE", emailUtilizador, passwordUtilizador, estadoUtilizador);
        });
    }

    //Fim testes nomeUtilizador

    //Testes emailUtilizador

    @Test
    void criarUtilizadorEmailValido() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, "projetoes2@teste.com", passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorEmailNull(){
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, null, passwordUtilizador, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorEmailVazio() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, "", passwordUtilizador, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorEmailMaior30() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE", passwordUtilizador, estadoUtilizador);
        });
    }

    //Fim testes emailUtilizador

    //Testes passwordUtilizador
    @Test
    void criarUtilizadorPasswordValida() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "PasswordTeste", estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorPasswordNull() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, null, estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorPasswordVazia(){
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "", estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorPasswordMenor6() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "teste", estadoUtilizador);
        });
    }

    @Test
    void criarUtilizadorPasswordMaior35() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE", estadoUtilizador);
        });
    }

    //Fim teste passwordUtilizador

    //Teste Estado Utilizador

    @Test
    void criarUtilizadorEstadoAtivo() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, passwordUtilizador, "ativo");
        assertEquals("ativo", utilizador.getEstadoUtilizador());
    }

    @Test
    void criarUtilizadorEstadoInativo() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, passwordUtilizador, "inativo");
        assertEquals("inativo", utilizador.getEstadoUtilizador());
    }

    @Test
    void criarUtilizadorEstadoErro() {
        assertThrows(InvalidUtilizadorException.class, () -> {
            utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, passwordUtilizador, "TESTE");
        });
    }
}
