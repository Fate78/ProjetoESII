package ProjetoESII;

import ProjetoESII.Exceptions.InvalidReplicaException;

import java.util.ArrayList;

public class ReplicaServidor {

    private int id_replicaServidor;
    private String localização_ReplicaServidor;
    private ArrayList<CopiaEBook> copiaEBookArrayList = new ArrayList<>();

    public ReplicaServidor(int id_replicaServidor, String localização_ReplicaServidor) throws InvalidReplicaException{
        if (id_replicaServidor<=0 || id_replicaServidor>=10000) //
            throw new InvalidReplicaException("Servidor Inválido");
        if (localização_ReplicaServidor==null || localização_ReplicaServidor.equals(""))
            throw new InvalidReplicaException("Servidor Inválido");

        this.id_replicaServidor=id_replicaServidor;
        this.localização_ReplicaServidor=localização_ReplicaServidor;
    }

    public int getId_replicaServidor(){return id_replicaServidor;}

    public void setId_replicaServidor(int id_replicaServidor) throws InvalidReplicaException{
        if (id_replicaServidor<=0 || id_replicaServidor>=2000)
            throw new InvalidReplicaException("Servidor Inválido");
        this.id_replicaServidor=id_replicaServidor;
    }

    public int getCopiasEBookArraySize(){return this.copiaEBookArrayList.size();}

    public String getLocalização_ReplicaServidor(){return localização_ReplicaServidor;}

    public void setLocalização_ReplicaServidor(String localização_ReplicaServidor) throws InvalidReplicaException{
        if (localização_ReplicaServidor==null || localização_ReplicaServidor.equals(""))
            throw new InvalidReplicaException("Servidor Inválido");
        this.localização_ReplicaServidor=localização_ReplicaServidor;
    }

    public void addCopiaEBook(CopiaEBook copiaEBook){copiaEBookArrayList.add(copiaEBook);}

    public void removeCopiaEbook(CopiaEBook copiaEBook){copiaEBookArrayList.remove(copiaEBook);}

    public ArrayList<CopiaEBook> getCopiaEBookArrayList(){return copiaEBookArrayList;}
}



