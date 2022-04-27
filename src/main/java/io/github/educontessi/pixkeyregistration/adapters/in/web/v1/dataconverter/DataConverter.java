package io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dataconverter;


import io.github.educontessi.pixkeyregistration.adapters.in.web.exception.DtoInvalidoException;
import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dto.BaseDto;
import io.github.educontessi.pixkeyregistration.core.model.BaseModel;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;

public abstract class DataConverter<M extends BaseModel, D extends BaseDto> {

    public abstract void copyToModel(M model, D dto);

    public abstract D convertToDto(D dto, M model);

    protected String[] getIgnoreProperties() { // todo: rever isso
        Set<String> list = new HashSet<>();
        //list.add("created");
        //list.add("changed");
        return list.toArray(new String[0]);
    }

    protected void isValid(M model) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<M>> violacoes = validator.validate(model);
        if (!violacoes.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<M> violacao : violacoes) {
                builder.append("|");
                builder.append(violacao.getMessage().replace("{0}", violacao.getPropertyPath().toString()));
            }
            throw new DtoInvalidoException(builder);
        }
    }
}
