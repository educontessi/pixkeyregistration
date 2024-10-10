package io.github.educontessi.pixkeyregistration.adapters.out.persistence.service;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.dataconverter.ChavePixOutDataConverter;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository.ChavePixRepository;
import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.ports.out.ChavePixRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChavePixService implements ChavePixRepositoryPort {

    private final ChavePixRepository repository;
    private final ChavePixOutDataConverter mapper;

    public ChavePixService(ChavePixRepository repository, ChavePixOutDataConverter mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChavePix save(ChavePix model) {
        ChavePixEntity entity = new ChavePixEntity();
        mapper.modelToEntity(entity, model);
        repository.save(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    public Optional<ChavePix> findById(UUID id) {
        Optional<ChavePixEntity> optionalSaved = repository.findById(id);
        return optionalSaved.map(mapper::entityToModel);
    }

    @Override
    public ChavePix delete(ChavePix saved) {
        ChavePixEntity entity = new ChavePixEntity();
        mapper.modelToEntity(entity, saved);
        entity = paranoidDelete(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    public List<ChavePix> search(ChavePixFilter filter) {
        List<ChavePixEntity> list = repository.search(filter);
        return list.stream().map(mapper::entityToModel).toList();
    }

    @Override
    public boolean existeChavePix(String valorChavePix) {
        return repository.existsByValorChave(valorChavePix);
    }

    @Override
    public long countByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta) {
        return repository.countByNumeroAgenciaAndNumeroContaAndDataHoraInativacaoIsNull(numeroAgencia, numeroConta);
    }

    protected ChavePixEntity paranoidDelete(ChavePixEntity saved) {
        saved.setDataHoraInativacao(LocalDateTime.now());
        return repository.saveAndFlush(saved);
    }

}
