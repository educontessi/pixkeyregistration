package io.github.educontessi.pixkeyregistration.ports.out;

import io.github.educontessi.pixkeyregistration.core.exception.EntityInUseException;
import io.github.educontessi.pixkeyregistration.core.exception.EntityNotFoundException;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;

import java.util.List;
import java.util.Optional;

public interface ChavePixRepositoryPort {

    ChavePix save(ChavePix model);

    List<ChavePix> findAll();

    Optional<ChavePix> findById(Long id);

    ChavePix update(ChavePix model, ChavePix saved);

    void delete(ChavePix saved) throws EntityNotFoundException, EntityInUseException;

    boolean existeChavePix(String valorChavePix);

}
