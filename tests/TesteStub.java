import ProjetoESII.*;
import ProjetoESII.Exceptions.*;
import ProjetoESII.stubDB.Database;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TesteStub {

    private final Database db = new Database();
    private LocalDate dataEmprestimo = LocalDate.now();
    private LocalDate fimEmprestimo = LocalDate.now().plusMonths(1);
    private Editora editora = new Editora(1, "TopSeller", "Rua 1.º de Maio, 226");
    private EBook eBook = new EBook(1, "Paula Hawkins", "pdf", "Um Fogo Lento", "9789895644919", "UmFogoLentoPaulaHawkins", editora, "PT", 1.5f);
    private CopiaEBook copiaEBook = new CopiaEBook(1, eBook);
    private Utilizador utilizador = new Utilizador(1, "UtilizadorES2", "utilizadorES2@teste.com", "trabalhofinales2", "ativo");
    private Funcionario funcionario = new Funcionario(1, "Tomas", "Func1@funcionarios.com", "Passw0rd");
    private ReplicaServidor replicaServidor = new ReplicaServidor(1, "Portugal");
    private Emprestimo emprestimo = new Emprestimo(1, dataEmprestimo, fimEmprestimo, utilizador, copiaEBook, 1, 0);


    public TesteStub() throws InvalidEditoraException, InvalidEbookException, InvalidCopiaEBookException, InvalidUtilizadorException, InvalidFuncionarioException, InvalidReplicaException, InvalidEmprestimoException {
    }


    //EBOOK
    @Test
    void addEbookStubValido() {
        assertEquals(1, db.addEbook(eBook));
    }

    @Test
    void addEbookStubInvalido() {
        assertEquals(-1, db.addEbook(null));
    }

    @Test
    void removerEbookValido() {
        db.addEbook(eBook);
        assertEquals(1, db.removeEbook(eBook));
    }

    @Test
    void removerEbookInvalido() {
        db.addEbook(eBook);
        assertEquals(0, db.removeEbook(null));
    }

    @Test
    void updateEbookValido() {
        db.addEbook(eBook);
        assertEquals(1, db.updateEbook(eBook, "Teste", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(null, "Teste", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookAutorNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, null, "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookAutorVazio() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookFormatoNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", null, "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookFormatoVazio() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookTituloNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", null, "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookTituloVazio() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "", "213321321", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookISBNNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", null, "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookISBNVazio() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "", "TESTEASSINATURA", editora, "PT", 1f));
    }

    @Test
    void updateEbookAssinaturaNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "213321321", null, editora, "PT", 1f));
    }

    @Test
    void updateEbookAssinaturaVazio() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "213321321", "", editora, "PT", 1f));
    }

    @Test
    void updateEbookEditoraNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", null, "PT", 1f));
    }

    @Test
    void updateEbookIdiomaNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, null, 1f));
    }

    @Test
    void updateEbookIdiomaVazio() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "", 1f));
    }

    @Test
    void updateEbookTamanhoNull() {
        db.addEbook(eBook);
        assertEquals(0, db.updateEbook(eBook, "TESTE", "pdf", "Teste Titulo", "213321321", "TESTEASSINATURA", editora, "PT", null));
    }

    @Test
    void getEbookValido() {
        db.addEbook(eBook);
        assertEquals(eBook, db.getEbook(1));
    }

    @Test
    void getEbookInvalido() {
        assertNull(db.getEbook(-100));
    }

    //USER
    @Test
    void addUserStubValido() {
        assertEquals(1, db.addUser(utilizador));
    }

    @Test
    void addUserStubInvalido() {
        assertEquals(-1, db.addUser(null));
    }

    @Test
    void removerUserStubValido() {
        db.addUser(utilizador);
        assertEquals(1, db.removeUser(utilizador));
    }

    @Test
    void removerUserStubInvalido() {
        db.addUser(utilizador);
        assertEquals(0, db.removeUser(null));
    }

    @Test
    void UpdateUserStubValido() {
        db.addUser(utilizador);
        assertEquals(1, db.updateUser(utilizador, "TESTE", "TESTE@TESTE.COM", "TESTE", "ATIVO"));
    }

    @Test
    void UpdateUserStubUserNull() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(null, "TESTE", "TESTE@TESTE.COM", "TESTE", "ATIVO"));
    }

    @Test
    void UpdateUserStubNomeNull() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, null, "TESTE@TESTE.COM", "TESTE", "ATIVO"));
    }

    @Test
    void UpdateUserStubNomeVazio() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "", "TESTE@TESTE.COM", "TESTE", "ATIVO"));
    }

    @Test
    void UpdateUserStubEmailNull() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "TESTE", null, "TESTE", "ATIVO"));
    }

    @Test
    void UpdateUserStubEmailVazio() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "TESTE", "", "TESTE", "ATIVO"));
    }

    @Test
    void UpdateUserStubPasswordNull() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "TESTE", "TESTE@TESTE.COM", null, "ATIVO"));
    }

    @Test
    void UpdateUserStubPasswordVazio() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "TESTE", "TESTE@TESTE.COM", "", "ATIVO"));
    }

    @Test
    void UpdateUserStubEstadoNull() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "TESTE", "TESTE@TESTE.COM", "TESTE", null));
    }

    @Test
    void UpdateUserStubEstadoVazio() {
        db.addUser(utilizador);
        assertEquals(0, db.updateUser(utilizador, "TESTE", "TESTE@TESTE.COM", "TESTE", ""));
    }

    @Test
    void getUserValido() {
        db.addUser(utilizador);
        assertEquals(utilizador, db.getUser(1));
    }

    @Test
    void getUserInvalido() {
        assertNull(db.getUser(-100));
    }

    //Emprestimo

    @Test
    void addEmprestimoStubValido() {
        assertEquals(1, db.addEmprestimo(emprestimo));
    }

    @Test
    void addEmprestimoStubInvalido() {
        assertEquals(-1, db.addEmprestimo(null));
    }

    @Test
    void removerEmprestimoStubValido() {
        db.addEmprestimo(emprestimo);
        assertEquals(1, db.removeEmprestimo(emprestimo));
    }

    @Test
    void removerEmprestimoStubInvalido() {
        db.addEmprestimo(emprestimo);
        assertEquals(0, db.removeEmprestimo(null));
    }

    @Test
    void getEmprestimoValido() {
        db.addEmprestimo(emprestimo);
        assertEquals(emprestimo, db.getEmprestimo(1));
    }

    @Test
    void getEmprestimoInvalido() {
        assertNull(db.getEmprestimo(-100));
    }

    @Test
    void getEbookEmprestimoValido() {
        db.addEmprestimo(emprestimo);
        assertEquals(eBook, db.getEbookFromEmprestimo(1));
    }

    @Test
    void getEbookEmprestimoInvalido() {
        assertNull(db.getEbookFromEmprestimo(-100));
    }

    @Test
    void getUserEmprestimoValido() {
        db.addEmprestimo(emprestimo);
        assertEquals(utilizador, db.getUtilizadorFromEmprestimo(1));
    }

    @Test
    void getUserEmprestimoInvalido() {
        assertNull(db.getUtilizadorFromEmprestimo(-100));
    }


    //Editora
    @Test
    void addEditoraStubValido() {
        assertEquals(1, db.addEditora(editora));
    }

    @Test
    void addEditoraStubInvalido() {
        assertEquals(-1, db.addEditora(null));
    }

    @Test
    void removerEditoraStubValido(){
        db.addEditora(editora);
        assertEquals(1, db.removeEditora(editora));
    }

    @Test
    void removerEditoraStubInvalido(){
        db.addEditora(editora);
        assertEquals(0, db.removeEditora(null));
    }

    @Test
    void updateEditoraValido() {
        db.addEditora(editora);
        assertEquals(1, db.updateEditora(editora, "TESTE", "TESTE"));
    }

    @Test
    void updateEditoraEditoraNull() {
        db.addEditora(editora);
        assertEquals(0, db.updateEditora(null, "TESTE", "TESTE"));
    }

    @Test
    void updateEditoraNomeNull() {
        db.addEditora(editora);
        assertEquals(0, db.updateEditora(editora, null, "TESTE"));
    }

    @Test
    void updateEditoraNomeVazio() {
        db.addEditora(editora);
        assertEquals(0, db.updateEditora(editora, "", "TESTE"));
    }

    @Test
    void updateEditoraMoradaNull() {
        db.addEditora(editora);
        assertEquals(0, db.updateEditora(editora, "TESTE", null));
    }

    @Test
    void updateEditoraMoradaVazio() {
        db.addEditora(editora);
        assertEquals(0, db.updateEditora(editora, "TESTE", ""));
    }

    @Test
    void getEditoraValido() {
        db.addEditora(editora);
        assertEquals(editora, db.getEditora(1));
    }

    @Test
    void getEditoraInvalido() {
        assertNull(db.getEditora(-100));
    }

    //Funcionario
    @Test
    void addFuncionarioStubValido() {
        assertEquals(1, db.addFuncionario(funcionario));

    }

    @Test
    void addFuncionarioStubInvalido() {
        assertEquals(-1, db.addFuncionario(null));
    }

    @Test
    void removeFuncionarioStubValido() {
        db.addFuncionario(funcionario);
        assertEquals(1, db.removeFuncionario(funcionario));
    }

    @Test
    void removeFuncionarioStubInvalido() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.removeFuncionario(null));
    }

    @Test
    void updateFuncionarioStubValido() {
        db.addFuncionario(funcionario);
        assertEquals(1, db.updateFuncionario(funcionario, "TESTE@TESTE.COM", "PASSW0RD", "TESTE"));
    }

    @Test
    void updateFuncionarioStubFuncNull() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(null, "TESTE@TESTE.COM", "PASSW0RD", "TESTE"));
    }

    @Test
    void updateFuncionarioStubEmailNull() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(funcionario, null, "PASSW0RD", "TESTE"));
    }

    @Test
    void updateFuncionarioStubEmailVazio() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(funcionario, "", "PASSW0RD", "TESTE"));
    }

    @Test
    void updateFuncionarioStubPassNull() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(funcionario, "TESTE@TESTE.COM", null, "TESTE"));
    }

    @Test
    void updateFuncionarioStubPassVazio() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(funcionario, "TESTE@TESTE.COM", "", "TESTE"));
    }

    @Test
    void updateFuncionarioStubNomeNull() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(funcionario, "TESTE@TESTE.COM", "PASSW0RD", null));
    }

    @Test
    void updateFuncionarioStubNomeVazio() {
        db.addFuncionario(funcionario);
        assertEquals(0, db.updateFuncionario(funcionario, "TESTE@TESTE.COM", "PASSW0RD", ""));
    }

    @Test
    void getFuncionarioValido() {
        db.addFuncionario(funcionario);
        assertEquals(funcionario, db.getFuncionario(1));
    }

    @Test
    void getFuncionarioInvalido() {
        assertNull(db.getFuncionario(-100));
    }

    //Replica Servidor
    @Test
    void addReplicaStubValido() {
        assertEquals(1, db.addReplica(replicaServidor));
    }

    @Test
    void addReplicaStubInvalido() {
        assertEquals(-1, db.addReplica(null));
    }

    @Test
    void removerReplicaStubValido() {
        db.addReplica(replicaServidor);
        assertEquals(1, db.removeReplica(replicaServidor));
    }

    @Test
    void removerReplicaStubInvalido() {
        db.addReplica(replicaServidor);
        assertEquals(0, db.removeReplica(null));
    }

    @Test
    void updateReplicaStubValido() throws InvalidReplicaException {
         db.addReplica(replicaServidor);
         assertEquals(1, db.updateReplica(replicaServidor, "Viseu"));
    }

    @Test
    void updateReplicaStubInvalido() throws InvalidReplicaException {
        db.addReplica(replicaServidor);
        assertEquals(0, db.updateReplica(null, "Viseu"));
    }

    @Test
    void updateReplicaStubLocalizacaoNull() throws InvalidReplicaException {
        db.addReplica(replicaServidor);
        assertEquals(0, db.updateReplica(replicaServidor, null));
    }

    @Test
    void updateReplicaStubLocalizacaoVazio() throws InvalidReplicaException {
        db.addReplica(replicaServidor);
        assertEquals(0, db.updateReplica(replicaServidor, ""));
    }

    @Test
    void getReplicaValido() {
        db.addReplica(replicaServidor);
        assertEquals(replicaServidor, db.getReplica(1));
    }

    @Test
    void getReplicaInvalido() {
        assertNull(db.getReplica(-100));
    }
}
