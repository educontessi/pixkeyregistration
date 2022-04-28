package io.github.educontessi.pixkeyregistration.adapters.in.web.v1.datamanager;

import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dataconverter.ChavePixInDataConverter;
import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dto.ChavePixDto;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.service.validation.ValidacaoChavePixExistente;
import io.github.educontessi.pixkeyregistration.adapters.out.spring.SpringContext;
import io.github.educontessi.pixkeyregistration.core.enums.TipoPessoa;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.ChavePixValidacoes;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.Validator;
import io.github.educontessi.pixkeyregistration.ports.in.ChavePixUseCasePort;
import org.springframework.stereotype.Component;

import java.util.List;

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
        model = chavePixUseCasePort.save(model, getValidatorsOnSave(model));
        return dataConverter.convertToDto(dto, model);
    }

    // todo: melhorar a validação de chave existente: mudar para o core utilizar porta
    private List<Validator> getValidatorsOnSave(ChavePix model) {
        List<Validator> validators = ChavePixValidacoes.validationsOnSave(model); //validacoes core

        ValidacaoChavePixExistente validacaoChavePixExistente = SpringContext.getBean(ValidacaoChavePixExistente.class); // validacoes adapter
        validacaoChavePixExistente.setValorChave(model.getValorChave());
        validators.add(validacaoChavePixExistente);

        return validators;
    }

}
