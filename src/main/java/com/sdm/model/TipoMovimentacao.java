package com.sdm.model;

/**
 * Enumeração que representa os tipos possíveis de movimentação de estoque.
 * <p>
 * Os tipos disponíveis são:
 * <ul>
 *   <li>ENTRADA - Representa a entrada de produtos no estoque.</li>
 *   <li>SAIDA - Representa a saída de produtos do estoque.</li>
 * </ul>
 * </p>
 */
public enum TipoMovimentacao {

    /** Entrada de produtos no estoque. */
    ENTRADA,

    /** Saída de produtos do estoque. */
    SAIDA
}