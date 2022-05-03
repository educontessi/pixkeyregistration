package io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.EntityNotFoundException;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

import java.util.List;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoPesquisaListaVazia implements Validator {

    private final List<ChavePix> lista;

    public ValidacaoPesquisaListaVazia(List<ChavePix> lista) {
        this.lista = lista;
    }

    @Override
    public void validate() {
        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Não encontrado");
        }
    }

}
