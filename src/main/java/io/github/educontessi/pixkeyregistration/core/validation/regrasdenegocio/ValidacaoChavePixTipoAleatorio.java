package io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixTipoAleatorio implements Validator {

    @Override
    public void validate() {
        throw new ValidacaoChavePixException("Tipo de chave não implementada");
    }

}
