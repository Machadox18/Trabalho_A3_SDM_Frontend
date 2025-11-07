package com.sdm.cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe de inicialização do cliente RMI.
 * Responsável por conectar ao servidor remoto e fornecer acesso ao serviço EstoqueRemote.
 */
public class RMICliente {

    private static RemoteProduto produtoService;
    private static RemoteCategoria categoriaService;
    private static RemoteMovimentacao movimentacaoService;

    /**
     * Inicia a conexão com o servidor RMI.
     * @param host IP ou nome do servidor (ex: "192.168.0.10")
     * @param port Porta do serviço (padrão 1099)
     * @throws Exception se houver erro de conexão
     */
    public static void start(String host, int port) throws Exception {
        Registry registry = LocateRegistry.getRegistry(host, port);

        produtoService = (RemoteProduto) registry.lookup("ProdutoService");
        categoriaService = (RemoteCategoria) registry.lookup("CategoriaService");
        movimentacaoService = (RemoteMovimentacao) registry.lookup("MovimentacaoService");

        System.out.println("Conectado ao servidor RMI em " + host + ":" + port);
    }

    /**
     * Retorna a instância remota do serviço de estoque.
     * Pode ser chamada em qualquer lugar do cliente.
     */
    public static RemoteProduto getProdutoService() {
        return produtoService;
    }

    public static RemoteCategoria getCategoriaService() {
        return categoriaService;
    }

    public static RemoteMovimentacao getMovimentacaoService() {
        return movimentacaoService;
    }

    // Teste rápido (opcional)
    public static void main(String[] args) {
    try {
        // Conecta ao servidor RMI
        RMICliente.start("localhost", 1099);

        System.out.println("Produtos cadastrados:");

        // Chama o serviço remoto diretamente
        getProdutoService().listarProdutos().forEach(p ->
                System.out.println(" - " + p.getNome())
        );

    } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
