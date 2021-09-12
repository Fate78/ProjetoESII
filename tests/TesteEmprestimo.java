import ProjetoESII.*;
import ProjetoESII.Exceptions.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteEmprestimo {
    private Editora editora = new Editora(1,"Editora 1","rua da editora 1");
    private Emprestimo emprestimo = null;
    private Integer id_emprestimo = 1;
    private LocalDate dataEmp = LocalDate.now();
    private LocalDate FimdataEmp = LocalDate.now().plusMonths(1);
    private Utilizador user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
    private EBook eBook = new EBook(1, "Christopher Paolini", "pdf", "Eragon", "978-3-16-148410-0", "Signature Eragon", editora, "Portugues", 255.f);
    private CopiaEBook copiaEBook = new CopiaEBook(1, eBook);
    //private GestorReplicas gestorReplicas = new GestorReplicas();
    private ReplicaServidor replicaServidor_portugal = new ReplicaServidor(1,  "Portugal");
    private Utilizador user_desativado = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "inativo");

    public TesteEmprestimo() throws InvalidEditoraException, InvalidUtilizadorException, InvalidEbookException, InvalidCopiaEBookException, InvalidReplicaException {
    }

    @Test
    void CriarEmprestimoValido() throws EmprestimoException{
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
    }

    @Test
    void CriarEmprestimo_UserDesativado() throws InvalidUtilizadorException{
        user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "inativo");
        assertThrows(EmprestimoException.class, () -> {
            emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoNull(){
        assertThrows(NullPointerException.class, () ->{
            emprestimo = new Emprestimo(1, null, null, null, null, 1);
        });
    }

    @Test
    void CriarEmprestimo_IDEmp() throws EmprestimoException{
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook,1);
        assertEquals(id_emprestimo, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimo_DataEmp() throws EmprestimoException{
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
        assertEquals(dataEmp, emprestimo.getData_emprestimo());
    }

    @Test
    void CriarEmprestimo_FimData() throws EmprestimoException{
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
    }

    @Test
    void CriarEmprestimo_DataInicio_Igual_DataFim(){
        assertThrows(EmprestimoException.class, () ->{
            emprestimo=new Emprestimo(id_emprestimo, LocalDate.now(), LocalDate.now(), user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoDataInicio_Depois_DataFim(){
        assertThrows(EmprestimoException.class, () -> {
           emprestimo=new Emprestimo(id_emprestimo, LocalDate.now(), LocalDate.now().minusMonths(1), user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoDataInicio_EntreDataAtualeFinal() throws EmprestimoException{
        emprestimo=new Emprestimo(id_emprestimo, LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(2), user, copiaEBook, 1);
        LocalDate data = LocalDate.now().plusMonths(1);
        assertEquals(data, emprestimo.getData_emprestimo());
    }

    @Test
    void CriarEmprestimoDataInicial_Antes_DataAtual() throws  EmprestimoException{
        assertThrows(EmprestimoException.class, () -> {
           emprestimo=new Emprestimo(id_emprestimo, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoAssinado() throws EmprestimoException{
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
    }

    @Test
    void CriarEmprestimoNaoAssinado(){
        assertThrows(EmprestimoException.class, () ->{
               emprestimo=new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 0);
        });
    }

    @Test
    void CriarEmprestimoInvalido() {
        assertThrows(EmprestimoException.class, () ->{
            emprestimo=new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 2);
        });
    }

    @Test
    void CriarEmprestimoCopiaEbook() throws EmprestimoException {
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
        assertEquals(1, emprestimo.getCopiaEbook().getId_copia());
        assertEquals("Eragon", emprestimo.getCopiaEbook().geteBook().getTitulo());
    }

    @Test
    void CriarEmprestimoCopiaEbookNull() {
        assertThrows(EmprestimoException.class, () -> {
            emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, null, 1);
        });
    }

    @Test
    void CriarEmprestimoIdValido() throws EmprestimoException {
        emprestimo = new Emprestimo(1, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        assertEquals(1, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimoIdMenor0() {
        assertThrows(EmprestimoException.class, () -> {
            emprestimo = new Emprestimo(-1, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoId0() {
        assertThrows(EmprestimoException.class, () -> {
            emprestimo = new Emprestimo(0, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        });

    }

    @Test
    void CriarEmprestimoIDMaiorMax() {
        assertThrows(EmprestimoException.class, () -> {
            emprestimo = new Emprestimo(2001, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoIDMax() {
        assertThrows(EmprestimoException.class, () -> {
            emprestimo = new Emprestimo(2000, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        });
    }

    @Test
    void CriarEmprestimoIDMenorMax() throws EmprestimoException {
        emprestimo = new Emprestimo(1999, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1);
        assertEquals(1999, emprestimo.getId_emprestimo());
    }

    @Test
    void CriarEmprestimoReplica() throws EmprestimoException, InvalidReplicaException, InvalidUtilizadorException {
        replicaServidor_portugal = new ReplicaServidor(1,"Portugal");
        replicaServidor_portugal.addCopiaEBook(copiaEBook);
        ReplicaServidor replicaServidor_franca = new ReplicaServidor(2, "Franca");
        replicaServidor_franca.addCopiaEBook(copiaEBook);
        ReplicaServidor replicaServidor_Espanha = new ReplicaServidor(3, "Espanha");
        replicaServidor_Espanha.addCopiaEBook(copiaEBook);

        /*gestorReplicas.addReplica(replicaServidor_portugal);
        gestorReplicas.addReplica(replicaServidor_franca);
        gestorReplicas.addReplica(replicaServidor_Espanha);*/

        user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
        //ReplicaServidor replica = gestorReplicas.get_Replica_Proxima_Cliente(emp);

        //emprestimo.setReplicaServidor(replica);
        assertEquals("Portugal", emprestimo.getReplicaServidor().getLocalização_ReplicaServidor());
    }

    @Test
    void CriarEmprestimoReplicaNull() throws EmprestimoException{
        emprestimo = new Emprestimo(id_emprestimo, dataEmp, FimdataEmp, user, copiaEBook, 1);
        assertThrows(EmprestimoException.class, () -> {
           emprestimo.setReplicaServidor(null);
        });
    }
    //TODO Extensao_de_emprestimo
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
