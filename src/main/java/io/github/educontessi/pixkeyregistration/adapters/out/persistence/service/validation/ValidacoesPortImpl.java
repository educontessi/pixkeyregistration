package io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation;

import io.github.educontessi.pixkeyregistration.adapters.out.spring.SpringContext;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;
import io.github.educontessi.pixkeyregistration.core.ports.out.ValidacoesPort;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacoesPortImpl implements ValidacoesPort {

    @Override
    public Validator validarChaveExistente(ChavePix model) {
        ValidacaoChavePixExistente validacaoChavePixExistente = SpringContext.getBean(ValidacaoChavePixExistente.class);
        validacaoChavePixExistente.setValorChave(model.getValorChave());
        return validacaoChavePixExistente;
    }

    @Override
    public Validator validarQuantidadeChaves(ChavePix model) {
        ValidacaoQuantidadeChaves validacaoQuantidadeChaves = SpringContext.getBean(ValidacaoQuantidadeChaves.class);
        validacaoQuantidadeChaves.setChavePix(model);
        return validacaoQuantidadeChaves;
    }
}
