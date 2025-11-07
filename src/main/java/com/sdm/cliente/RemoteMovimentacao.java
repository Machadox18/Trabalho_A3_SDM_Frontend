package com.sdm.cliente;

import com.sdm.model.Movimentacao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMovimentacao extends Remote {

    boolean registrarMovimentacao(Movimentacao m) throws RemoteException;
}
