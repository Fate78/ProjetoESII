import ProjetoESII.Exceptions.InvalidFuncionarioException;
import ProjetoESII.Funcionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteFuncionario {
    private Funcionario func = null;
    private Integer id_func = 1;
    private String email_func= "Func1@funcionarios.com";
    private String pwd_func = "Passw0rd";
    private String nome_func = "Tomas";

    @Test
    void CriarFuncValido() throws InvalidFuncionarioException {
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertNotNull(func);
    }

    @Test
    void CriarFuncNull(){
        assertNull(func);
    }

    @Test
    void CriarfuncNullConstructor() {
        assertThrows(NullPointerException.class, () -> {
            func = new Funcionario(null,null,null,null);
        });
    }

    @Test
    void CriarfuncIdValido() throws InvalidFuncionarioException {
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertEquals(id_func,func.getIdFuncionario());
    }

    @Test
    void CriarfuncIdMenorMax() throws InvalidFuncionarioException {
        id_func = 1999;
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertEquals(id_func,func.getIdFuncionario());
    }

    @Test
    void CriarfuncIdIgualMax() {
        id_func = 2000;
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncIdMaiorMax()  {
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(2001,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncID0() {
        id_func = 0;
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncIdMenor0() {
        id_func = -1;
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncIdMaior0() throws InvalidFuncionarioException {
        id_func = 1;
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertEquals(id_func,func.getIdFuncionario());
    }


    @Test
    void CriarfuncNomeValido() throws InvalidFuncionarioException {
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertEquals(nome_func,func.getNomeFuncionario());
    }

    @Test
    void CriarfuncNomeNull() {
        nome_func = null;
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncNomeVazio() {
        nome_func = "";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarFuncTamNomeInvalido() {
        nome_func = "InêsJustrianaPereira";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncNomeInvalidoNumero() {
        nome_func = "12345";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncEmailValido() throws InvalidFuncionarioException {
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertEquals(email_func,func.getEmailFuncionario());
    }

    @Test
    void CriarfuncEmailInvalido() {
        email_func = "tomas.pt";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarFuncEmail_TamanhoMaiorMax() {
        email_func = "tomasmaskmdksakdmaskmdskamdkamsdkmaskmdkasdkmaskdmaksmdkamsdkmdkasm@pt.pt";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarFuncEmailVazio() {
        email_func = "";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarFuncEmailNull() {
        email_func = null;
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncPwValida() throws InvalidFuncionarioException {
        func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        assertEquals(pwd_func,func.getPasswordFuncionario());
    }

    @Test
    void CriarfuncPwInvalida() {
        pwd_func = "tomas";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarFuncPwVazia() {
        pwd_func = "";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncPw_TamanhoInsuficiente() {
        pwd_func = "123";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    //TODO Onde é criado o critério?
    @Test
    void CriarfuncWithInvalidPwdLenghLessEqualsToMinimum() {
        pwd_func = "Abc1abC";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncPw_DemasiadoGrande() {
        pwd_func = "Abc1aBAbc1aBAbc1aBAbc1aB";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncPwIgualMax() {
        pwd_func = "Abc1abCabCabCabCabCabC";
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }

    @Test
    void CriarfuncPwNull() {
        pwd_func = null;
        assertThrows(InvalidFuncionarioException.class, () -> {
            func = new Funcionario(id_func,nome_func,email_func,pwd_func);
        });
    }
}
