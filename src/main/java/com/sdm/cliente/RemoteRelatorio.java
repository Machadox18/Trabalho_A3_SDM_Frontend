package com.sdm.cliente;

import com.sdm.model.Produto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface RemoteRelatorio extends Remote {

    List<Produto> produtosAbaixoMinimo() throws RemoteException;

    List<Produto> produtosAcimaMaximo() throws RemoteException;

    List<Produto> relatorioMovimentacoes() throws RemoteException;

    Map<String, Object> relatorioBalanco() throws RemoteException;
}
