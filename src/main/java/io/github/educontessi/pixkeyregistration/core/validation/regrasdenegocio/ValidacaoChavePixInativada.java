package io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixInativada implements Validator {

    private final ChavePix chavePix;

    public ValidacaoChavePixInativada(ChavePix chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validate() {
        if (chavePix.estaExcluido()) {
            throw new ValidacaoChavePixException("A chave está inativada");
        }
    }

}
