package io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.ChavePixService;
import io.github.educontessi.pixkeyregistration.core.enums.TipoPessoa;
import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;
import org.springframework.stereotype.Component;

/**
 * @author Eduardo Possamai Contessi
 */
@Component
public class ValidacaoQuantidadeChaves implements Validator {

    private final ChavePixService service;

    public ValidacaoQuantidadeChaves(ChavePixService service) {
        this.service = service;
    }

    private ChavePix chavePix;

    @Override
    public void validate() {
        long quantidadeChaves = service.countByNumeroAgenciaAndNumeroConta(chavePix.getNumeroAgencia(), chavePix.getNumeroConta());

        if (TipoPessoa.FISICA.equals(chavePix.getTipoPessoa()) && quantidadeChaves == 5) {
            throw new ValidacaoChavePixException("Quantidade de chaves excedido (5)");
        }

        if (TipoPessoa.JURIDICA.equals(chavePix.getTipoPessoa()) && quantidadeChaves == 20
        ) {
            throw new ValidacaoChavePixException("Quantidade de chaves excedido (20)");
        }
    }

    public void setChavePix(ChavePix chavePix) {
        this.chavePix = chavePix;
    }
}
