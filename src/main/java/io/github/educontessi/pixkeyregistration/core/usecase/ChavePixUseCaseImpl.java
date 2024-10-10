package io.github.educontessi.pixkeyregistration.core.usecase;

import io.github.educontessi.pixkeyregistration.core.exception.EntityNotFoundException;
import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.ChavePixValidacoes;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;
import io.github.educontessi.pixkeyregistration.core.ports.in.ChavePixUseCasePort;
import io.github.educontessi.pixkeyregistration.core.ports.out.ChavePixRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ChavePixUseCaseImpl implements ChavePixUseCasePort {

    private final ChavePixRepositoryPort repository;
    private final ChavePixValidacoes chavePixValidacoes;

    public ChavePixUseCaseImpl(ChavePixRepositoryPort repository, ChavePixValidacoes chavePixValidacoes) {
        this.repository = repository;
        this.chavePixValidacoes = chavePixValidacoes;
    }

    @Override
    public ChavePix save(ChavePix model) {
        chavePixValidacoes.validationsOnSave(model).forEach(Validator::validate);
        return repository.save(model);
    }

    @Override
    public ChavePix path(UUID id, String valorChave) {
        ChavePix saved = findById(id);
        chavePixValidacoes.validationsOnPatch(saved).forEach(Validator::validate);

        saved.setValorChave(valorChave);
        return saved;
    }

    @Override
    public ChavePix findById(UUID id) {
        Optional<ChavePix> optionalSaved = repository.findById(id);
        return optionalSaved.orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public List<ChavePix> search(ChavePixFilter filter) {
        List<ChavePix> lista = repository.search(filter);
        chavePixValidacoes.validationsOnSearch(lista).forEach(Validator::validate);
        return lista;
    }

    @Override
    public ChavePix delete(UUID id) {
        ChavePix saved = findById(id);
        chavePixValidacoes.validationsOnDelete(saved).forEach(Validator::validate);
        return repository.delete(saved);
    }

}
