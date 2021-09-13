import ProjetoESII.*;
import ProjetoESII.Exceptions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteReplicaServidor {
    private Editora editora = new Editora(1, "Editora 1", "rua da editora 1");
    private Utilizador user = new Utilizador(1, "The dude", "thedude@abides.com", "Passw0rd", "ativo");
    private EBook eBook = new EBook(1, "Christopher Paolini", "pdf", "Eragon", "978-3-16-148410-0", "Signature Eragon", editora, "Portugues", 15.0f);
    private CopiaEBook copiaEBook = new CopiaEBook(1, eBook);
    private ReplicaServidor replicaServidor = null;
    private int prolongacao_emprestimo = 0;
    private Emprestimo emprestimo = new Emprestimo(1, LocalDate.now(), LocalDate.now().plusMonths(1), user, copiaEBook, 1, prolongacao_emprestimo);

    public TesteReplicaServidor() throws InvalidEditoraException, InvalidUtilizadorException, InvalidEbookException, InvalidCopiaEBookException, InvalidEmprestimoException {
    }

    @Test
    void CriarReplicaServidorValida() throws InvalidReplicaException {
        replicaServidor = new ReplicaServidor(1, "Portugal");
        assertNotNull(replicaServidor);
    }

    @Test
    void CriarReplicaIdValido() throws InvalidReplicaException {
        replicaServidor = new ReplicaServidor(5, "Portugal");
        assertEquals(5, replicaServidor.getId_replicaServidor());
    }

    @Test
    void CriarReplicaIdInvalido() {
        assertThrows(InvalidReplicaException.class, () -> {
            replicaServidor = new ReplicaServidor(-5, "Portugal");
        });
    }

    @Test
    void CriarReplicaIdIgual0() {
        assertThrows(InvalidReplicaException.class, () -> {
            replicaServidor = new ReplicaServidor(0, "Portugal");
        });
    }

    @Test
    void CriarReplicaIdMaiorMax() {
        assertThrows(InvalidReplicaException.class, () -> {
            replicaServidor = new ReplicaServidor(2001, "Portugal");
        });
    }

    @Test
    void CriarReplicaIdIgualMax() {
        assertThrows(InvalidReplicaException.class, () -> {
            replicaServidor = new ReplicaServidor(2000, "Portugal");
        });
    }

    @Test
    void CriarReplicaIdMenorMax() throws InvalidReplicaException {
        replicaServidor = new ReplicaServidor(1999, "Portugal");
        assertEquals(1999, replicaServidor.getId_replicaServidor());
    }


    @Test
    void CriarReplicaLocalNull() {
        assertThrows(InvalidReplicaException.class, () -> {
            replicaServidor = new ReplicaServidor(1, null);
        });
    }

    @Test
    void CriarReplicaLocalEmpty() {
        assertThrows(InvalidReplicaException.class, () -> {
            replicaServidor = new ReplicaServidor(1, "");
        });
    }
}
