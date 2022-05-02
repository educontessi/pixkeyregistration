package io.github.educontessi.pixkeyregistration.adapters.out.persistence.service;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.dataconverter.ChavePixOutDataConverter;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository.CountryRepository;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.ports.out.ChavePixRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChavePixService implements ChavePixRepositoryPort {

    private final CountryRepository repository;
    private final ChavePixOutDataConverter mapper;

    public ChavePixService(CountryRepository repository, ChavePixOutDataConverter mapper) {
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
    public List<ChavePix> findAll() {
        List<ChavePixEntity> list = repository.findAll();
        return list.stream().map(mapper::entityToModel).toList();
    }

    @Override
    public Optional<ChavePix> findById(UUID id) {
        Optional<ChavePixEntity> optionalSaved = repository.findById(id);
        return optionalSaved.map(mapper::entityToModel);
    }

    @Override
    public void delete(ChavePix saved) {
        ChavePixEntity entity = new ChavePixEntity();
        mapper.modelToEntity(entity, saved);
        paranoidDelete(entity);
    }

    @Override
    public boolean existeChavePix(String valorChavePix) {
        return repository.existsByValorChave(valorChavePix);
    }

    @Override
    public long countByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta) {
        return repository.countByNumeroAgenciaAndNumeroContaAndDataExclusaoIsNull(numeroAgencia, numeroConta);
    }

    protected void paranoidDelete(ChavePixEntity saved) {
        saved.setDataExclusao(LocalDateTime.now());
        repository.saveAndFlush(saved);
    }

}
