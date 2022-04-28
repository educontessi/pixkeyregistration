package io.github.educontessi.pixkeyregistration.core.usecase.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.Validator;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixTipoCelular implements Validator {

    @Override
    public void validate() {
        throw new ValidacaoChavePixException("Tipo de chave não implementada");
    }

}
