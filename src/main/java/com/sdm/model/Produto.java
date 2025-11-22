package com.sdm.model;

import java.io.Serializable;

/**
 * Representa um produto no sistema de controle de estoque.
 *
 * A classe armazena informações como nome, preço, unidade de medida,
 * quantidade em estoque, limites mínimo e máximo, categoria associada
 * e totais de movimentações (entradas e saídas).
 *
 * Implementa {@link Serializable} para permitir a serialização do objeto,
 * necessária para persistência e transmissão de dados.
 *
 */
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Identificador único do produto. */
    private int id;
    /** Nome do produto. */
    private String nome;
    /** Preço unitário do produto. */
    private double precoUnitario;
    /** Valor total do produto (preço unitário * quantidade em estoque). */
    private double precoTotalProduto;
    /** Valor total do estoque considerando todos os produtos. */
    private double precoTotalEstoque;
    /** Unidade de medida do produto (ex.: "Kg", "L"). */
    private String unidade;
    /** Quantidade atual em estoque. */
    private int quantidadeEstoque;
    /** Quantidade mínima permitida em estoque. */
    private int quantidadeMinima;
    /** Quantidade máxima permitida em estoque. */
    private int quantidadeMaxima;
    /** Total de saídas do produto registradas. */
    private int totalSaidas;
    /** Total de entradas do produto registradas. */
    private int totalEntradas;
    /** Categoria associada ao produto. */
    private Categoria categoria;

    /** Construtor padrão. */
    public Produto() {
    }

    /**
     * Construtor para relatório de movimentação.
     *
     * @param nome         Nome do produto
     * @param totalSaidas  Total de saídas
     * @param totalEntradas Total de entradas
     */
    public Produto(String nome, int totalSaidas, int totalEntradas) {
        this.nome = nome;
        this.totalSaidas = totalSaidas;
        this.totalEntradas = totalEntradas;
    }

    /**
     * Construtor completo para cadastro de produto.
     *
     * @param id                ID do produto
     * @param nome              Nome do produto
     * @param precoUnitario     Preço unitário
     * @param unidade           Unidade de medida
     * @param quantidadeEstoque Quantidade em estoque
     * @param quantidadeMinima  Quantidade mínima
     * @param quantidadeMaxima  Quantidade máxima
     * @param categoria         Categoria associada
     */
    public Produto(int id, String nome, double precoUnitario, String unidade, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.categoria = categoria;
    }

    /**
     * Construtor para lista de preços.
     *
     * @param nome          Nome do produto
     * @param precoUnitario Preço unitário
     * @param unidade       Unidade de medida
     */
    public Produto(String nome, double precoUnitario, String unidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    /**
     * Construtor para valor total do estoque.
     *
     * @param precoTotalEstoque Valor total do estoque
     */
    public Produto(double precoTotalEstoque) {
        this.precoTotalEstoque = precoTotalEstoque;
    }

    /**
     * Construtor para balanço de estoque.
     *
     * @param nome               Nome do produto
     * @param quantidadeEstoque  Quantidade em estoque
     * @param precoTotalProduto  Valor total do produto
     */
    public Produto(String nome, int quantidadeEstoque, double precoTotalProduto) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoTotalProduto = precoTotalProduto;
    }
    /** @return o ID do produto */
    public int getId() {
        return id;
    }

    /** @param id define o ID do produto */
    public void setId(int id) {
        this.id = id;
    }

    /** @return o nome do produto */
    public String getNome() {
        return nome;
    }

    /** @param nome define o nome do produto */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return o preço unitário do produto */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /** @param precoUnitario define o preço unitário do produto */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /** @return o valor total do produto (preço * quantidade) */
    public double getPrecoTotalProduto() {
        return precoTotalProduto;
    }

    /** @param precoTotalProduto define o valor total do produto */
    public void setPrecoTotalProduto(double precoTotalProduto) {
        this.precoTotalProduto = precoTotalProduto;
    }

    /** @return o valor total do estoque */
    public double getPrecoTotalEstoque() {
        return precoTotalEstoque;
    }

    /** @param precoTotalEstoque define o valor total do estoque */
    public void setPrecoTotalEstoque(double precoTotalEstoque) {
        this.precoTotalEstoque = precoTotalEstoque;
    }

    /** @return a unidade de medida do produto */
    public String getUnidade() {
        return unidade;
    }

    /** @param unidade define a unidade de medida do produto */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /** @return a quantidade em estoque */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /** @param quantidadeEstoque define a quantidade em estoque */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /** @return a quantidade mínima permitida */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /** @param quantidadeMinima define a quantidade mínima */
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    /** @return a quantidade máxima permitida */
    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    /** @param quantidadeMaxima define a quantidade máxima */
    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    /** @return o total de saídas registradas */
    public int getTotalSaidas() {
        return totalSaidas;
    }

    /** @param totalSaidas define o total de saídas */
    public void setTotalSaidas(int totalSaidas) {
        this.totalSaidas = totalSaidas;
    }

    /** @return o total de entradas registradas */
    public int getTotalEntradas() {
        return totalEntradas;
    }

    /** @param totalEntradas define o total de entradas */
    public void setTotalEntradas(int totalEntradas) {
        this.totalEntradas = totalEntradas;
    }

    /** @return a categoria associada ao produto */
    public Categoria getCategoria() {
        return categoria;
    }

    /** @param categoria define a categoria associada ao produto */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna uma representação textual do produto.
     *
     * @return string com informações do produto
     */
    // Método para imprimir o produto como texto
    public String toString() {
        return "Id:" + id + "Nome:" + nome + "Preço por unidade" + precoUnitario + unidade;
    }
}
