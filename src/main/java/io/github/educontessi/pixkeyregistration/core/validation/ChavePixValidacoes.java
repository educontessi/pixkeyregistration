package io.github.educontessi.pixkeyregistration.core.validation;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio.*;
import io.github.educontessi.pixkeyregistration.ports.out.ValidacoesPort;

import java.util.ArrayList;
import java.util.List;

public class ChavePixValidacoes {

    private final ValidacoesPort validacoesPort;

    public ChavePixValidacoes(ValidacoesPort validacoesPort) {
        this.validacoesPort = validacoesPort;
    }

    public List<Validator> validationsOnSave(ChavePix chavePix) {
        List<Validator> validators = new ArrayList<>();

        validators.add(new ObjectNotNull(chavePix));

        validators.add(validacoesPort.validarChaveExistente(chavePix));
        validators.add(validacoesPort.validarQuantidadeChaves(chavePix));

        switch (chavePix.getTipoChave()) {
            case EMAIL -> validators.add(new ValidacaoChavePixTipoEmail(chavePix.getValorChave()));
            case CPF -> validators.add(new ValidacaoChavePixTipoCPF(chavePix.getValorChave()));
            case CNPJ -> validators.add(new ValidacaoChavePixTipoCNPJ(chavePix.getValorChave()));
            case ALEATORIO -> validators.add(new ValidacaoChavePixTipoAleatorio()); // não implementado
            case CELULAR -> validators.add(new ValidacaoChavePixTipoCelular()); // não implementado
        }

        return validators;
    }

    public static List<Validator> validationsOnDelete() {
        return new ArrayList<>();
    }

}
