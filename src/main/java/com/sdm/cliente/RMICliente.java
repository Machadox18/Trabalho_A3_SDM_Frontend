package com.sdm.cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe de inicialização do cliente RMI.
 * Responsável por conectar ao servidor remoto e fornecer acesso ao serviço EstoqueRemote.
 */
public class RMICliente {

    private static RemoteEstoque service;

    /**
     * Inicia a conexão com o servidor RMI.
     * @param host IP ou nome do servidor (ex: "192.168.0.10")
     * @param port Porta do serviço (padrão 1099)
     * @throws Exception se houver erro de conexão
     */
    public static void start(String host, int port) throws Exception {
        Registry registry = LocateRegistry.getRegistry(host, port);
        service = (RemoteEstoque) registry.lookup("EstoqueService");
        System.out.println("Conectado ao servidor RMI em " + host + ":" + port);
    }

    /**
     * Retorna a instância remota do serviço de estoque.
     * Pode ser chamada em qualquer lugar do cliente.
     */
    public static RemoteEstoque getService() {
        return service;
    }

    // Teste rápido (opcional)
    public static void main(String[] args) {
        String host = (args.length > 0) ? args[0] : "localhost";
        int port = 1099;

        try {
            RMICliente.start(host, port);

            // Teste simples: listar produtos
            System.out.println("Produtos no estoque:");
            RMICliente.getService().listarProdutos()
                .forEach(p -> System.out.println(" - " + p.getNome()));

        } catch (Exception e) {
            System.err.println("Erro ao conectar ao servidor RMI:");
            e.printStackTrace();
        }
    }
}