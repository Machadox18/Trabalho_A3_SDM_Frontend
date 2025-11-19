package com.sdm.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.sdm.model.Movimentacao;
import java.util.List;

public interface RemoteMovimentacao extends Remote {
    
    public boolean inserir(Movimentacao movimentacao) throws RemoteException;
    
    public List<Movimentacao> listar() throws RemoteException;

    boolean registrarMovimentacao(int produtoId, int quantidade, String tipo, String dataStr) throws RemoteException;
}