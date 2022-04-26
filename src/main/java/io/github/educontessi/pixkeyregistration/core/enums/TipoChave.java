package io.github.educontessi.pixkeyregistration.core.enums;

public enum TipoChave {

    CELULAR("Celular"),
    EMAIL("E-mail"),
    CPF("CPF"),
    CNPJ("CNPJ"),
    ALEATORIO("Chave aleatória");

    private final String descricao;

    TipoChave(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
