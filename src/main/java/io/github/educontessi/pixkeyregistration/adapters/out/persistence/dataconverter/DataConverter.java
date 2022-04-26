package io.github.educontessi.pixkeyregistration.adapters.out.persistence.dataconverter;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.BaseEntity;
import io.github.educontessi.pixkeyregistration.core.model.BaseModel;

public interface DataConverter<E extends BaseEntity, M extends BaseModel> {

    void modelToEntity(E entity, M model);

    M entityToModel(E entity, String expand);

}
