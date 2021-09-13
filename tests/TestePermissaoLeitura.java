import ProjetoESII.*;
import ProjetoESII.Exceptions.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class TestePermissaoLeitura {

    private Editora editora = new Editora(1,"Editora 1","rua da editora 1");
    private int id_emprestimo = 1;
    private LocalDate dataEmp = LocalDate.now();
    private LocalDate FimdataEmp = LocalDate.now().plusMonths(1);
    private int prolongacao_emprestimo = 0;
    private Utilizador user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
    private Utilizador userInativo = new Utilizador(2, "The dude Inactive", "thedudeInactive@abides.com", "Passw0rd", "inativo");
    private EBook eBook = new EBook(1, "Paula Hawkins", "pdf", "Um Fogo Lento", "9789895644919", "UmFogoLentoPaulaHawkins", editora, "PT", 1.5f);
    private Utilizador utilizador = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
    private CopiaEBook copiaEBook = new CopiaEBook(1, eBook);
    private Emprestimo emprestimo = new Emprestimo(1, dataEmp, FimdataEmp, user, copiaEBook, 1, prolongacao_emprestimo);
    private PermissaoLeitura permissaoLeitura = new PermissaoLeitura();





    public TestePermissaoLeitura() throws InvalidUtilizadorException, InvalidEbookException, InvalidEditoraException, InvalidEmprestimoException, InvalidCopiaEBookException, InvalidPermissaoLeituraException {}

    @Test
    void CriarPermissaoLeituraValida() throws InvalidPermissaoLeituraException{
        assertTrue(permissaoLeitura.validarLeitura(emprestimo, dataEmp));
    }

    @Test
    void CriarPermissaoLeituraUtilizadorInativo() throws  InvalidUtilizadorException, InvalidEmprestimoException {
        Utilizador utilizadorTeste = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
        Emprestimo emprestimo = new Emprestimo(1, dataEmp, FimdataEmp, utilizadorTeste, copiaEBook, 1, prolongacao_emprestimo);
        PermissaoLeitura permissaoLeitura = new PermissaoLeitura();

        assertThrows(InvalidPermissaoLeituraException.class, () -> {
            emprestimo.getUtilizador().setEstadoUtilizador("inativo");
            permissaoLeitura.validarLeitura(emprestimo, emprestimo.getData_emprestimo());
        });
    }

    @Test
    void CriarPermissaoLeituraDataSuperior()  throws  InvalidUtilizadorException, InvalidEmprestimoException {
        Utilizador utilizadorTeste = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
        Emprestimo emprestimo = new Emprestimo(1, dataEmp, FimdataEmp, utilizadorTeste, copiaEBook, 1, prolongacao_emprestimo);
        PermissaoLeitura permissaoLeitura = new PermissaoLeitura();

        assertThrows(InvalidPermissaoLeituraException.class, () -> {
            permissaoLeitura.validarLeitura(emprestimo, emprestimo.getData_emprestimo().plusMonths(3));
        });
    }

}
