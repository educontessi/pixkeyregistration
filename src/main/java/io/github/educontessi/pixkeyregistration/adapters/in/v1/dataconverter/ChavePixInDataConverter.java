package io.github.educontessi.pixkeyregistration.adapters.in.v1.dataconverter;

import io.github.educontessi.pixkeyregistration.adapters.in.v1.dto.ChavePixDto;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChavePixInDataConverter extends DataConverter<ChavePix, ChavePixDto> {

    @Override
    public void copyToModel(ChavePix model, ChavePixDto dto) {
        BeanUtils.copyProperties(dto, model, getIgnoreProperties());
        isValid(model);
    }

    @Override
    public ChavePixDto convertToDto(ChavePixDto dto, ChavePix model) {
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public ChavePixDto convertToDto(ChavePix model) {
        return convertToDto(new ChavePixDto(), model);
    }

}
