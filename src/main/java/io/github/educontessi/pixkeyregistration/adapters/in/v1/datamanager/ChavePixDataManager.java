package io.github.educontessi.pixkeyregistration.adapters.in.v1.datamanager;

import io.github.educontessi.pixkeyregistration.adapters.in.v1.dataconverter.ChavePixInDataConverter;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.dto.ChavePixDto;
import io.github.educontessi.pixkeyregistration.core.enums.TipoPessoa;
import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.ports.in.ChavePixUseCasePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ChavePixDataManager {

    private final ChavePixUseCasePort chavePixUseCasePort;
    private final ChavePixInDataConverter dataConverter;

    public ChavePixDataManager(ChavePixUseCasePort chavePixUseCasePort,
                               ChavePixInDataConverter dataConverter) {
        this.chavePixUseCasePort = chavePixUseCasePort;
        this.dataConverter = dataConverter;
    }

    public ChavePixDto save(ChavePixDto dto, String tipoPessoaPathVariable) {
        TipoPessoa tipoPessoa = TipoPessoa.valueOfPathVariable(tipoPessoaPathVariable);
        var model = new ChavePix(tipoPessoa);
        dataConverter.copyToModel(model, dto);
        model = chavePixUseCasePort.save(model);
        return dataConverter.convertToDto(dto, model);
    }

    public ChavePixDto path(String valorChave, ChavePixDto dto) {
        var model = chavePixUseCasePort.path(dto.getId(), valorChave);
        model = chavePixUseCasePort.save(model);
        return dataConverter.convertToDto(dto, model);
    }

    public ChavePixDto delete(UUID id) {
        var model = chavePixUseCasePort.delete(id);
        return dataConverter.convertToDto(model);
    }

    public ChavePixDto findById(UUID id) {
        var model = chavePixUseCasePort.findById(id);
        return dataConverter.convertToDto(model);
    }

    public List<ChavePixDto> search(ChavePixFilter chavePixFilter) {
        List<ChavePix> lista = chavePixUseCasePort.search(chavePixFilter);
        return lista.stream().map(dataConverter::convertToDto).toList();
    }
}
