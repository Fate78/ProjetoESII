package ProjetoESII.stubDB;

import ProjetoESII.*;
import ProjetoESII.Exceptions.InvalidUtilizadorException;

import java.util.ArrayList;

public class DBAdapterStub implements{
    private ArrayList<Emprestimo> emprestimoArrayList = new ArrayList<>();
    private ArrayList<EBook> ebookArrayList = new ArrayList<>();
    private ArrayList<Utilizador> utilizadorArrayList = new ArrayList<>();
    private ArrayList<ReplicaServidor> replicaServidorArrayList = new ArrayList<>();
    private ArrayList<Funcionario> funcionarioArrayList = new ArrayList<>();
    private ArrayList<Editora> editoraArrayList = new ArrayList<>();


    @Override
    public int saveUser(Utilizador u) {
        if (u != null) {
            utilizadorArrayList.add(u);
            return u.getIdUtilizador();
        }

        return -1;
    }

    @Override
    public int removeUser(int id_user) {
        for (int i = 0; i < utilizadorArrayList.size(); i++) {
            if (utilizadorArrayList.get(i).getIdUtilizador().equals(id_user)) {
                utilizadorArrayList.remove(i);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Utilizador getUser(int id_user) {
        for (int i = 0; i < utilizadorArrayList.size(); i++) {
            if (utilizadorArrayList.get(i).getIdUtilizador().equals(id_user))
                return utilizadorArrayList.get(i);
        }
        return null;
    }

    @Override
    public int updateUser(int id_user, String pwd, String telefone) throws InvalidUtilizadorException {
        if (pwd == null || pwd == "" || telefone == null || telefone == ""){
            return 0;
        }
        for (int i = 0; i < utilizadorArrayList.size(); i++) {
            if (utilizadorArrayList.get(i).getIdUtilizador().equals(id_user)){
                utilizadorArrayList.get(i).setPasswordUtilizador(pwd);
                return utilizadorArrayList.get(i).getIdUtilizador();
            }
        }
        return 0;
    }

    @Override
    public Utilizador Login(String email, String pwd) {
        if (email == null || pwd == null)
            return null;

        for (int i = 0; i < utilizadorArrayList.size(); i++) {
            if (utilizadorArrayList.get(i).getEmailUtilizador().equals(email) && utilizadorArrayList.get(i).getPasswordUtilizador().equals(pwd))
                return utilizadorArrayList.get(i);
        }
        return null;
    }

    @Override
    public JSONObject listaOfUsers() {
        String message;
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        int key = 0;
        String nome = null, email = null, morada = null, contacto = null, estado = null;
        for (int i = 0; i < utilizadorArrayList.size(); i++) {
            key = utilizadorArrayList.get(i).getIdUtilizador();
            nome = utilizadorArrayList.get(i).getNomeUtilizador();
            email = utilizadorArrayList.get(i).getEmailUtilizador();
            estado = utilizadorArrayList.get(i).getEstadoUtilizador();
            item.put("Nome",nome);
            item.put("Email",email);
            item.put("Estado",estado);
            array.put(item);
            json.put(String.valueOf(key), array);
            array = new JSONArray();
        }
        message = json.toString();
        System.out.println(message);

        return json;
    }

    @Override
    public int saveEBook(EBook eBook) {
        if (eBook != null) {
            ebookArrayList.add(eBook);
            return eBook.getIdEbook();
        }

        return -1;
    }

    @Override
    public EBook getEBook(int idEBook) {
        for (int i = 0; i < ebookArrayList.size(); i++) {
            if (ebookArrayList.get(i).getIdEbook() == idEBook)
                return ebookArrayList.get(i);
        }
        return null;
    }

    @Override
    public JSONObject ListarEBooks() {
        String message;
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        int key = 0;
        String isbn = null, autor = null, titulo = null, editora = null, formato = null, hash = null;
        for (int i = 0; i < ebookArrayList.size(); i++) {
            key = ebookArrayList.get(i).getIdEbook();
            isbn = ebookArrayList.get(i).getISBN();
            autor = ebookArrayList.get(i).getAutor();
            titulo = ebookArrayList.get(i).getTitulo();
            editora = ebookArrayList.get(i).getEditora().getNomeEditora();
            formato = ebookArrayList.get(i).getFormato();
            hash = ebookArrayList.get(i).getHash();

            item.put("ISBN",isbn);
            item.put("Autor",autor);
            item.put("Titulo",titulo);
            item.put("Editora",editora);
            item.put("Formato",formato);
            item.put("Hash",hash);
            array.put(item);
            json.put(String.valueOf(key), array);
            array = new JSONArray();
        }
        message = json.toString();
        System.out.println(message);

        return json;
    }

    @Override
    public int removeEBook(int idEBook) {
        for (int i = 0; i < ebookArrayList.size(); i++) {
            if (ebookArrayList.get(i).getIdEbook() == idEBook) {
                ebookArrayList.remove(i);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int saveEmprestimo(Emprestimo emp) {
        if (emp != null) {
            emprestimoArrayList.add(emp);
            return emp.getId_emprestimo();
        }
        return -1;
    }

    @Override
    public Emprestimo getEmprestimo(int id_emp) {
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getId_emprestimo() == id_emp) {
                return emprestimoArrayList.get(i);
            }
        }
        return null;
    }

    @Override
    public EBook getEBookFromEmprestimo(int id_emp) {
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getId_emprestimo() == id_emp) {
                return emprestimoArrayList.get(i).getCopiaEbook().geteBook();
            }
        }
        return null;
    }

    @Override
    public Utilizador getUtilizadorFromEmprestimo(int id_emp) {
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getId_emprestimo() == id_emp) {
                return emprestimoArrayList.get(i).getUtilizador();
            }
        }
        return null;
    }

    @Override
    public ReplicaServidor getReplicaFromEmprestimo(int id_emp) {
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getId_emprestimo() == id_emp) {
                return emprestimoArrayList.get(i).getReplicaServidor();
            }
        }
        return null;
    }

    @Override
    public int getAssinaturaTR(int id_emp) {
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getId_emprestimo() == id_emp) {
                return emprestimoArrayList.get(i).getAssinatura();
            }
        }
        return -1;
    }

    @Override
    public int removeEmprestimo(int id_emp) {
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getId_emprestimo() == id_emp) {
                emprestimoArrayList.remove(i);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public JSONObject ListarEmprestimoByUser(int id_user) {

        String message;
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        int key = 0;
        String nome_user = null, data_inicio = null, data_fim = null, ebook = null, assinatura = null;
        for (int i = 0; i < emprestimoArrayList.size(); i++) {
            if (emprestimoArrayList.get(i).getUtilizador().getIdUtilizador() == id_user){
                key = emprestimoArrayList.get(i).getId_emprestimo();
                nome_user = emprestimoArrayList.get(i).getUtilizador().getNomeUtilizador();
                data_inicio = String.valueOf(emprestimoArrayList.get(i).getData_emprestimo());
                data_fim = String.valueOf(emprestimoArrayList.get(i).getFim_emprestimo());
                ebook = emprestimoArrayList.get(i).getCopiaEbook().geteBook().getTitulo();
                assinatura = String.valueOf(emprestimoArrayList.get(i).getAssinatura());
                item.put("Utilizador",nome_user);
                item.put("data_inicio",data_inicio);
                item.put("data_fim",data_fim);
                item.put("ebook",ebook);
                item.put("assinatura",assinatura);
                array.put(item);
                json.put(String.valueOf(key), array);
                array = new JSONArray();
            }
        }
        message = json.toString();
        System.out.println(message);

        return json;
    }

    @Override
    public int saveFuncionario(Funcionario f) {
        if (f != null) {
            funcionarioArrayList.add(f);
            return f.getIdFuncionario();
        }

        return -1;
    }

    @Override
    public int removeFuncionario(int id_func) {
        for (int i = 0; i < funcionarioArrayList.size(); i++) {
            if (funcionarioArrayList.get(i).getIdFuncionario().equals(id_func)) {
                funcionarioArrayList.remove(i);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Funcionario getFuncionario(int id_func) {
        for (int i = 0; i < funcionarioArrayList.size(); i++) {
            if (funcionarioArrayList.get(i).getIdFuncionario().equals(id_func))
                return funcionarioArrayList.get(i);
        }
        return null;
    }

    @Override
    public Funcionario LoginFuncionario(String email, String pwd) {
        if (email == null || pwd == null)
            return null;

        for (int i = 0; i < funcionarioArrayList.size(); i++) {
            if (funcionarioArrayList.get(i).getEmailFuncionario().equals(email) && funcionarioArrayList.get(i).getPasswordFuncionario().equals(pwd))
                return funcionarioArrayList.get(i);
        }
        return null;
    }

    @Override
    public int saveReplica(ReplicaServidor rp) {
        if (rp != null) {
            replicaServidorArrayList.add(rp);
            return rp.getId_replicaServidor();
        }
        return -1;
    }

    @Override
    public int removeReplica(int id_replica) {
        for (int i = 0; i < replicaServidorArrayList.size(); i++) {
            if (replicaServidorArrayList.get(i).getId_replicaServidor() == id_replica) {
                replicaServidorArrayList.remove(i);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public ReplicaServidor getReplica(int id_replica) {
        for (int i = 0; i < replicaServidorArrayList.size(); i++) {
            if (replicaServidorArrayList.get(i).getId_replicaServidor() == id_replica) {
                return replicaServidorArrayList.get(i);
            }
        }
        return null;
    }

    @Override
    public JSONObject getCopiaFromReplicas(int id_replica) {
        String message;
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        int key = 0;
        String titulo = null, autor = null, editora = null, formato = null;
        float filesize;
        StringBuilder s = new StringBuilder();
        for (ReplicaServidor replicaServidor : replicaServidorArrayList) {
            if (replicaServidor.getId_replicaServidor() == id_replica) {
                for (int j = 0; j < replicaServidor.getCopiaEBookArrayList().size(); j++) {
                    key = replicaServidor.getCopiaEBookArrayList().get(j).getId_copia();
                    titulo = replicaServidor.getCopiaEBookArrayList().get(j).geteBook().getTitulo();
                    autor = replicaServidor.getCopiaEBookArrayList().get(j).geteBook().getAutor();
                    editora = replicaServidor.getCopiaEBookArrayList().get(j).geteBook().getEditora().getNomeEditora();
                    formato = replicaServidor.getCopiaEBookArrayList().get(j).geteBook().getFormato();
                    filesize = replicaServidor.getCopiaEBookArrayList().get(j).geteBook().getFileSize();
                    item.put("Titulo",titulo);
                    item.put("Autor",autor);
                    item.put("Editora",editora);
                    item.put("Formato",formato);
                    item.put("FileSize",filesize);
                    array.put(item);
                    json.put(String.valueOf(key), array);
                    array = new JSONArray();
                }
            }
        }
        message = json.toString();
        System.out.println(message);
        return json;
    }

    @Override
    public int addEditora(Editora editora) {
        this.editoraArrayList.add(editora);
        return 1;
    }

    @Override
    public Editora getEditorabyId(int idEditora) {
        for (int i = 0; i < editoraArrayList.size(); i++) {
            if (editoraArrayList.get(i).getIdEditora() == idEditora)
                return editoraArrayList.get(i);
        }
        return null;
    }
}
