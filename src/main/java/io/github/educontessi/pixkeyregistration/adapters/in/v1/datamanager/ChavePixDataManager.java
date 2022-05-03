package io.github.educontessi.pixkeyregistration.adapters.in.v1.datamanager;

import io.github.educontessi.pixkeyregistration.adapters.in.v1.dataconverter.ChavePixInDataConverter;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.dto.ChavePixDto;
import io.github.educontessi.pixkeyregistration.core.enums.TipoPessoa;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.ports.in.ChavePixUseCasePort;
import org.springframework.stereotype.Component;

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

    public ChavePixDto path(String valorChave, ChavePixDto dto, String tipoPessoaPathVariable) {
        TipoPessoa tipoPessoa = TipoPessoa.valueOfPathVariable(tipoPessoaPathVariable);
        var model = chavePixUseCasePort.path(dto.getId(), valorChave);
        model = chavePixUseCasePort.save(model);
        return dataConverter.convertToDto(dto, model);
    }

    public ChavePixDto delete(UUID id, String tipoPessoaPathVariable) {
        TipoPessoa tipoPessoa = TipoPessoa.valueOfPathVariable(tipoPessoaPathVariable);
        var model = chavePixUseCasePort.delete(id);
        return dataConverter.convertToDto(model);
    }

}
