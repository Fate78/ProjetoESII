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
    void criarUtilizadorIdNegativo() throws InvalidUtilizadorException {
        utilizador = new Utilizador(-5, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorIdMaior1000() throws InvalidUtilizadorException {
        utilizador = new Utilizador(1005, nomeUtilizador, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
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
    void criarUtilizadorNomeNull() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, null, emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorNomeVazio() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, "", emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorNomeMaior20() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, "TESTE TESTE TESTE TESTE TESTE", emailUtilizador, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    //Fim testes nomeUtilizador

    //Testes emailUtilizador

    @Test
    void criarUtilizadorEmailValido() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, "projetoes2@teste.com", passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorEmailNull() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, null, passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorEmailVazio() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, "", passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorEmailMaior30() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE", passwordUtilizador, estadoUtilizador);
        assertNotNull(utilizador);
    }

    //Fim testes emailUtilizador

    //Testes passwordUtilizador
    @Test
    void criarUtilizadorPasswordValida() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "PasswordTeste", estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorPasswordNull() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, null, estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorPasswordVazia() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "", estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorPasswordMenor6() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "teste", estadoUtilizador);
        assertNotNull(utilizador);
    }

    @Test
    void criarUtilizadorPasswordMaior35() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE", estadoUtilizador);
        assertNotNull(utilizador);
    }

    //Fim teste passwordUtilizador

    //Teste Estado Utilizador

    @Test
    void criarUtilizadorEstadoAtivo() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, passwordUtilizador, "ativo");
        assertEquals("ativo", utilizador.getEstadoUtilizador());
    }

    @Test
    void criarUtilizadorEstadoIna~d6tfyrygfhtivo() throws InvalidUtilizadorException {
        utilizador = new Utilizador(idUtilizador, nomeUtilizador, emailUtilizador, passwordUtilizador, "inativo");
        assertEquals("inativo", utilizador.getEstadoUtilizador());
    }
}
