package com.sdm.server;

import com.sdm.model.Produto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteProduto extends Remote {

    List<Produto> listar() throws RemoteException;
    Produto buscarPorId(int id) throws RemoteException;
    void inserir(Produto p) throws RemoteException;
    void atualizar(Produto p) throws RemoteException;
    boolean deletar(int id) throws RemoteException;

}
