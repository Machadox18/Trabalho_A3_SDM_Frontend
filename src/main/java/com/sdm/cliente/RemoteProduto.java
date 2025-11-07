package com.sdm.cliente;

import com.sdm.model.Produto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteProduto extends Remote {

    List<Produto> listarProdutos() throws RemoteException;
    Produto buscarProdutoPorId(int id) throws RemoteException;
    void inserirProduto(Produto p) throws RemoteException;
    void atualizarProduto(Produto p) throws RemoteException;
    boolean excluirProduto(int id) throws RemoteException;

}
