package com.sdm.cliente;

import com.sdm.model.Categoria;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteCategoria extends Remote {

    List<Categoria> listarCategorias() throws RemoteException;
    Categoria buscarCategoriaPorId(int id) throws RemoteException;
    void inserirCategoria(Categoria c) throws RemoteException;
    boolean atualizarCategoria(Categoria c) throws RemoteException;
    boolean excluirCategoria(int id) throws RemoteException;
}
