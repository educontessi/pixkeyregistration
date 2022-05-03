package io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.ChavePixService;
import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;
import org.springframework.stereotype.Component;

/**
 * @author Eduardo Possamai Contessi
 */
@Component
public class ValidacaoChavePixExistente implements Validator {

    private final ChavePixService service;

    public ValidacaoChavePixExistente(ChavePixService service) {
        this.service = service;
    }

    private String valorChave;

    @Override
    public void validate() {
        if (service.existeChavePix(valorChave)) {
            throw new ValidacaoChavePixException("Chave pix já existe: " + valorChave);
        }
    }

    public void setValorChave(String valorChave) {
        this.valorChave = valorChave;
    }
}
