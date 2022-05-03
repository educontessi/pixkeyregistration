package io.github.educontessi.pixkeyregistration.core.enums;

import io.github.educontessi.pixkeyregistration.core.exception.NegocioException;

import java.util.Objects;

public enum TipoPessoa {

    FISICA("pessoa-fisica"), JURIDICA("pessoa-juridica");

    private final String pathVariable;

    TipoPessoa(String pathVariable) {
        this.pathVariable = pathVariable;
    }

    public String getPathVariable() {
        return pathVariable;
    }

    public static TipoPessoa valueOfPathVariable(String pathVariable) {
        for (TipoPessoa tipoPessoa : TipoPessoa.values()) {
            if (Objects.equals(pathVariable, tipoPessoa.getPathVariable())) {
                return tipoPessoa;
            }
        }
        throw new NegocioException("Tipo pessoa inválido");
    }

}
