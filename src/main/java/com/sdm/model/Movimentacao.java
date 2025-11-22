package com.sdm.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representa uma movimentação de produto no estoque.
 *
 * Cada movimentação pode ser do tipo ENTRADA ou SAÍDA, registrando
 * a quantidade alterada, a data da operação e o produto relacionado.
 */
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Identificador único da movimentação. */
    private int id;

    /** ID do produto associado à movimentação. */
    private int produtoId;

    /** Quantidade de produtos movimentados. */
    private int quantidade;

    /** Tipo da movimentação: "ENTRADA" ou "SAIDA". */
    private String tipo;

    /** Data e hora da movimentação. */
    private LocalDateTime data;

    /**
     * Construtor padrão.
     *
     * Inicializa a data da movimentação com a data/hora atual.
     *
     */
    public Movimentacao() {
        this.data = LocalDateTime.now();
    }

    /**
     * Construtor completo.
     *
     * @param id         Identificador da movimentação
     * @param produtoId  ID do produto
     * @param quantidade Quantidade movimentada
     * @param tipo       Tipo da movimentação ("ENTRADA" ou "SAIDA")
     * @param data       Data e hora da movimentação
     */
    public Movimentacao(int id,int produtoId, int quantidade, String tipo, LocalDateTime data) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.data = data;
    }

    /** @return o ID da movimentação */
    public int getId() { return id; }

    /** @param id define o ID da movimentação */
    public void setId(int id) { this.id = id; }

    /** @return o ID do produto associado */
    public int getProdutoId() { return produtoId; }

    /** @param produtoId define o ID do produto associado */
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }

    /** @return a quantidade movimentada */
    public int getQuantidade() { return quantidade; }

    /** @param quantidade define a quantidade movimentada */
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    /** @return o tipo da movimentação ("ENTRADA" ou "SAIDA") */
    public String getTipo() { return tipo; }

    /** @param tipo define o tipo da movimentação ("ENTRADA" ou "SAIDA") */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /** @return a data e hora da movimentação */
    public LocalDateTime getData() { return data; }

    /** @param data define a data e hora da movimentação */
    public void setData(LocalDateTime data) { this.data = data; }
}