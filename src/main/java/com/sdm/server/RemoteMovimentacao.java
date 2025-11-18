package com.sdm.server;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMovimentacao extends Remote {

    boolean registrarMovimentacao(int produtoId, int quantidade, String tipo, String dataStr) throws RemoteException;
}
