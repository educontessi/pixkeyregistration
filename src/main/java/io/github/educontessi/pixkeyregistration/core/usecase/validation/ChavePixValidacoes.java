package io.github.educontessi.pixkeyregistration.core.usecase.validation;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.regrasdenegocio.*;

import java.util.ArrayList;
import java.util.List;

public class ChavePixValidacoes {

    private ChavePixValidacoes() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Validator> validationsOnSave(ChavePix chavePix) {
        List<Validator> validators = new ArrayList<>();

        validators.add(new ObjectNotNull(chavePix));

        // todo: adicionar validacao de chave existente para não deixar validando pela chave unica no banco

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
