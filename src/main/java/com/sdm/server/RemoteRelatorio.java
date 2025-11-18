package com.sdm.server;

import com.sdm.model.Categoria;
import com.sdm.model.Produto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteRelatorio extends Remote {

    List<Produto> produtosAbaixoMinimo() throws RemoteException;

    List<Produto> produtosAcimaMaximo() throws RemoteException;

    List<Produto> relatorioMovimentacoes() throws RemoteException;

    List<Produto> relatorioBalanco() throws RemoteException;
    
    List<Produto> listarPrecos() throws RemoteException;
    
    List<Categoria> produtosPorCategoria() throws RemoteException;
}
