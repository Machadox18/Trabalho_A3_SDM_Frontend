package com.sdm.model;

/**
 * Representa os tipos de embalagem que um produto pode ter.
 *
 * Cada valor do enum possui uma representação textual amigável para exibição
 * (método {@link #toString()}) e permite conversão de string para enum
 * com {@link #fromString(String)}.
 */
public enum EmbalagemProduto {

    /** Produto embalado em lata. */
    LATA,

    /** Produto embalado em vidro. */
    VIDRO,

    /** Produto embalado em plástico. */
    PLASTICO;

    /**
     * Retorna uma representação textual amigável do tipo de embalagem.
     *
     * Por exemplo, {@code LATA} retorna "Lata", {@code PLASTICO} retorna "Plástico".
     *
     * @return nome amigável da embalagem
     */
    @Override
    public String toString() {
        switch (this) {
            case LATA: return "Lata";
            case VIDRO: return "Vidro";
            case PLASTICO: return "Plástico";
            default: return super.toString();
        }
    }

    /**
     * Converte uma string em um valor do enum {@link EmbalagemProduto}.
     *
     * A conversão é feita comparando a string com a versão amigável (toString)
     * ou com o nome do enum (LATA, VIDRO, PLASTICO), ignorando maiúsculas/minúsculas.
     *
     * @param text string a ser convertida
     * @return valor correspondente do enum
     * @throws IllegalArgumentException se a string não corresponder a nenhum valor válido
     */
    public static EmbalagemProduto fromString(String text) {
        if (text == null) return null;

        for (EmbalagemProduto e : EmbalagemProduto.values()) {
            // Compara com a versão "bonita" (toString)
            if (e.toString().equalsIgnoreCase(text)) {
                return e;
            }

            // Compara com o nome do enum original (LATA, VIDRO...)
            if (e.name().equalsIgnoreCase(text)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Embalagem inválida: " + text);
    }
}
