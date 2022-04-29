package io.github.educontessi.pixkeyregistration.core.usecase;

import io.github.educontessi.pixkeyregistration.core.exception.EntityNotFoundException;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;
import io.github.educontessi.pixkeyregistration.ports.in.ChavePixUseCasePort;
import io.github.educontessi.pixkeyregistration.ports.out.ChavePixRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ChavePixUseCaseImpl implements ChavePixUseCasePort {

    private final ChavePixRepositoryPort repository;

    public ChavePixUseCaseImpl(ChavePixRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChavePix save(ChavePix model, List<Validator> validators) {
        validators.forEach(Validator::validate);
        return repository.save(model);
    }

    @Override
    public List<ChavePix> findAll() {
        return repository.findAll();
    }

    @Override
    public ChavePix findById(Long id) {
        Optional<ChavePix> optionalSaved = repository.findById(id);
        return optionalSaved.orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public ChavePix update(Long id, ChavePix model, List<Validator> validators) {
        validators.forEach(Validator::validate);
        ChavePix saved = findById(id);
        return repository.update(model, saved);
    }

    @Override
    public void delete(Long id, List<Validator> validators) {
        validators.forEach(Validator::validate);
        ChavePix saved = findById(id);
        repository.delete(saved);
    }

}
