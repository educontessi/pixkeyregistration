package io.github.educontessi.pixkeyregistration.core.ports.out;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

/**
 * @author Eduardo Possamai Contessi
 */
public interface ValidacoesPort {

    Validator validarChaveExistente(ChavePix model);

    Validator validarQuantidadeChaves(ChavePix model);
}
