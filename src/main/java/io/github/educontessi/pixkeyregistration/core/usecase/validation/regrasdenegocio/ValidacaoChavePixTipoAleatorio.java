package io.github.educontessi.pixkeyregistration.core.usecase.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixTipoAleatorio implements Validator {

    @Override
    public void validate() {
        throw new ValidacaoChavePixException("Tipo de chave não implementada");
    }

}
