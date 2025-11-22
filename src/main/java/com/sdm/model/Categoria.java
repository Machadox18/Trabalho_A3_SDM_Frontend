package com.sdm.model;

import java.io.Serializable;

/**
 * Representa uma categoria de produto.
 *
 * Esta classe armazena informações sobre a categoria, incluindo nome,
 * tamanho do produto, tipo de embalagem e quantidade de produtos associados.
 *
 * Implementa {@link Serializable} para permitir que objetos desta classe
 * possam ser serializados, necessário para algumas operações de persistência
 * ou transmissão em rede.
 *
 */
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Identificador único da categoria. */
    private int id;

    /** Nome da categoria. */
    private String nome;

    /** Tamanho do produto (enum {@link TamanhoProduto}). */
    private TamanhoProduto tamanho;

    /** Tipo de embalagem do produto (enum {@link EmbalagemProduto}). */
    private EmbalagemProduto embalagem;

    /** Quantidade de produtos associados a esta categoria. */
    private int qtd_produtoPorCategoria;

    /**
     * Construtor vazio.
     *
     * Necessário para frameworks que exigem instância sem inicialização de campos.
     */
    public Categoria() {
    }

    /**
     * Construtor completo.
     *
     * @param id        Identificador da categoria
     * @param nome      Nome da categoria
     * @param tamanho   Tamanho do produto
     * @param embalagem Tipo de embalagem do produto
     */
    public Categoria(int id, String nome, TamanhoProduto tamanho, EmbalagemProduto embalagem) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    /**
     * Construtor simplificado com ID e nome.
     *
     * @param idCategoria   Identificador da categoria
     * @param nomeCategoria Nome da categoria
     */
    public Categoria(int idCategoria, String nomeCategoria) {
        this.id = idCategoria;
        this.nome = nomeCategoria;
    }

    /**
     * Construtor com apenas o nome da categoria.
     *
     * @param nome Nome da categoria
     */
    public Categoria(String nome) {
        this.nome = nome;
    }

    /**
     * Construtor com nome e quantidade de produtos associados.
     *
     * @param nome                     Nome da categoria
     * @param qtd_produtoPorCategoria   Quantidade de produtos nesta categoria
     */
    public Categoria(String nome, int qtd_produtoPorCategoria) {
        this.nome = nome;
        this.qtd_produtoPorCategoria = qtd_produtoPorCategoria;
    }

    /** @return o ID da categoria */
    public int getId() {
        return id;
    }

    /** @param id o ID a ser definido para a categoria */
    public void setId(int id) {
        this.id = id;
    }

    /** @return o nome da categoria */
    public String getNome() {
        return nome;
    }

    /** @param nome o nome a ser definido para a categoria */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return o tamanho do produto associado à categoria */
    public TamanhoProduto getTamanho() {
        return tamanho;
    }

    /** @param tamanho o tamanho do produto a ser definido */
    public void setTamanho(TamanhoProduto tamanho) {
        this.tamanho = tamanho;
    }

    /** @return a embalagem do produto associado à categoria */
    public EmbalagemProduto getEmbalagem() {
        return embalagem;
    }

    /** @param embalagem a embalagem a ser definida para a categoria */
    public void setEmbalagem(EmbalagemProduto embalagem) {
        this.embalagem = embalagem;
    }

    /** @return quantidade de produtos associados à categoria */
    public int getQtd_produtoPorCategoria() {
        return qtd_produtoPorCategoria;
    }

    /** @param qtd_produtoPorCategoria define a quantidade de produtos associados */
    public void setQtd_produtoPorCategoria(int qtd_produtoPorCategoria) {
        this.qtd_produtoPorCategoria = qtd_produtoPorCategoria;
    }

    /**
     * Retorna uma representação em string da categoria.
     *
     * @return String no formato "id - nome"
     */
    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
