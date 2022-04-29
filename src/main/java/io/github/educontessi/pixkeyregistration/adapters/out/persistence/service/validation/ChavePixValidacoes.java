package io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation.regradenegocio.ValidacaoChavePixExistente;
import io.github.educontessi.pixkeyregistration.adapters.out.spring.SpringContext;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;
import io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio.*;

import java.util.ArrayList;
import java.util.List;

public class ChavePixValidacoes {

    private ChavePixValidacoes() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Validator> validationsOnSave(ChavePix chavePix) {
        List<Validator> validators = new ArrayList<>();

        validators.add(new ObjectNotNull(chavePix));
        validators.add(getValidacaoChavePixExistente(chavePix));

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

    protected static ValidacaoChavePixExistente getValidacaoChavePixExistente(ChavePix chavePix) {
        ValidacaoChavePixExistente validacaoChavePixExistente = SpringContext.getBean(ValidacaoChavePixExistente.class);
        validacaoChavePixExistente.setValorChave(chavePix.getValorChave());
        return validacaoChavePixExistente;
    }

}
