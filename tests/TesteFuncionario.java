import ProjetoESII.Exceptions.InvalidFuncionarioException;
import ProjetoESII.Funcionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteFuncionario {
    private Funcionario funcionario = null;
    private Integer idFuncionario = 1;
    private String emailFuncionario = "Func1@funcionarios.com";
    private String passwordFuncionario = "Passw0rd";
    private String nomeFuncionario = "Tomas";

    @Test
    void CriarFuncionarioValido() throws InvalidFuncionarioException {
        funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertNotNull(funcionario);
    }

    @Test
    void CriarFuncionarioNull(){
        assertNull(funcionario);
    }

    @Test
    void CriarFuncionarioNullConstructor() {
        assertThrows(NullPointerException.class, () -> {
            funcionario = new Funcionario(null,null,null,null);
        });
    }

    @Test
    void CriarFuncionarioIdValido() throws InvalidFuncionarioException {
        funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertEquals(idFuncionario, funcionario.getIdFuncionario());
    }

    @Test
    void CriarFuncionarioIdMenorMax() throws InvalidFuncionarioException {
        funcionario = new Funcionario(999, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertEquals(999, funcionario.getIdFuncionario());
    }

    @Test
    void CriarFuncionarioIdIgualMax() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(1000, nomeFuncionario, emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioIdMaiorMax()  {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(2001, nomeFuncionario, emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionariocID0() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(0, nomeFuncionario, emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioIdMenor0() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(-1, nomeFuncionario, emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioIdMaior0() throws InvalidFuncionarioException {
        funcionario = new Funcionario(1, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertEquals(idFuncionario, funcionario.getIdFuncionario());
    }


    @Test
    void CriarFuncionarioNomeValido() throws InvalidFuncionarioException {
        funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertEquals(nomeFuncionario, funcionario.getNomeFuncionario());
    }

    @Test
    void CriarFuncionarioNomeNull() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, null, emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioNomeVazio() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, "", emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioTamNomeInvalido() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, "TESTESTESTETESTESTESTESTE", emailFuncionario, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioEmailValido() throws InvalidFuncionarioException {
        funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertEquals(emailFuncionario, funcionario.getEmailFuncionario());
    }


    @Test
    void CriarFuncionarioEmail_TamanhoMaiorMax() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, "testestestestestestestestestestestestesteste@teste.pt", passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioEmailVazio() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, "", passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioEmailNull() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, null, passwordFuncionario);
        });
    }

    @Test
    void CriarFuncionarioPasswordValida() throws InvalidFuncionarioException {
        funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, passwordFuncionario);
        assertEquals(passwordFuncionario, funcionario.getPasswordFuncionario());
    }

    @Test
    void CriarFuncionarioPasswordInvalida() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, "teste");
        });
    }

    @Test
    void CriarFuncionarioPasswordVazia() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, "");
        });
    }

    @Test
    void CriarFuncionarioPassword_TamanhoInsuficiente() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, "123");
        });
    }



    @Test
    void CriarFuncionarioPasswordDemasiadoGrande() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, "Passw0rdPassw0rdPassw0rdPassw0rd");
        });
    }

    @Test
    void CriarFuncionarioPasswordIgualMax() {
        assertThrows(InvalidFuncionarioException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, "Passw0rdPassw0rdPassw0rdPassw0");
        });
    }

    @Test
    void CriarFuncionarioPasswordNull() {
        assertThrows(NullPointerException.class, () -> {
            funcionario = new Funcionario(idFuncionario, nomeFuncionario, emailFuncionario, null);
        });
    }
}
