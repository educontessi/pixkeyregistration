package io.github.educontessi.pixkeyregistration.adapters.out.persistence.dataconverter;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChavePixOutDataConverter implements DataConverter<ChavePixEntity, ChavePix> {

    @Override
    public void modelToEntity(ChavePixEntity entity, ChavePix model) {
        BeanUtils.copyProperties(model, entity);
    }

    @Override
    public ChavePix entityToModel(ChavePixEntity entity, String expand) {
        ChavePix model = new ChavePix(entity.getTipoPessoa());
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public ChavePix entityToModel(ChavePixEntity entity) {
        return entityToModel(entity, null);
    }

}
