package io.github.educontessi.pixkeyregistration.adapters.in.web.exception;


import io.github.educontessi.pixkeyregistration.core.exception.NegocioException;

public class DtoInvalidoException extends NegocioException {

    public DtoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public DtoInvalidoException(StringBuilder builder) {
        this(builder.toString().replaceFirst("\\|", ""));
    }

}