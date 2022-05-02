package io.github.educontessi.pixkeyregistration.ports.out;

import io.github.educontessi.pixkeyregistration.core.exception.EntityInUseException;
import io.github.educontessi.pixkeyregistration.core.exception.EntityNotFoundException;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChavePixRepositoryPort {

    ChavePix save(ChavePix model);

    List<ChavePix> findAll();

    Optional<ChavePix> findById(UUID id);

    void delete(ChavePix saved) throws EntityNotFoundException, EntityInUseException;

    boolean existeChavePix(String valorChavePix);

    long countByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta);

}
