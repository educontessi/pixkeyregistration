package io.github.educontessi.pixkeyregistration.core.usecase.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.NegocioException;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.Validator;

public class ObjectNotNull implements Validator {

    private final Object object;

    public ObjectNotNull(Object object) {
        this.object = object;
    }

    @Override
    public void validate() {

        if(object == null){
            throw new NegocioException("Objeto não pode ser nulo");
        }
    }
}
