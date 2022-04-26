package io.github.educontessi.pixkeyregistration.core.usecase.validation;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.businessrule.ObjectNotNull;

import java.util.ArrayList;
import java.util.List;

public class ChavePixValidacoes {

    private ChavePixValidacoes() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Validator> validationsOnSave(ChavePix chavePix) {
        List<Validator> validators = new ArrayList<>();
        validators.add(new ObjectNotNull(chavePix));
        return validators;
    }

    public static List<Validator> validationsOnDelete() {
        return new ArrayList<>();
    }
}
