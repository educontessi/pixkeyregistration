package io.github.educontessi.pixkeyregistration.adapters.in.v1.dataconverter;

import io.github.educontessi.pixkeyregistration.adapters.in.v1.dto.BaseDto;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.web.exception.DtoInvalidoException;
import io.github.educontessi.pixkeyregistration.core.model.BaseModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public abstract class DataConverter<M extends BaseModel, D extends BaseDto> {

    public abstract void copyToModel(M model, D dto);

    public abstract D convertToDto(D dto, M model);

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
