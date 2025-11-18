package com.sdm.server;

import com.sdm.model.Categoria;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteCategoria extends Remote {

    List<Categoria> listar() throws RemoteException;
    Categoria buscarPorId(int id) throws RemoteException;
    void inserir(Categoria c) throws RemoteException;
    boolean atualizar(Categoria c) throws RemoteException;
    boolean deletar(int id) throws RemoteException;
}
