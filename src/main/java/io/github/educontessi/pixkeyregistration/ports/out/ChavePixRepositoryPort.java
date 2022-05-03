package io.github.educontessi.pixkeyregistration.ports.out;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChavePixRepositoryPort {

    ChavePix save(ChavePix model);

    Optional<ChavePix> findById(UUID id);

    ChavePix delete(ChavePix saved);

    List<ChavePix> findAll();

    boolean existeChavePix(String valorChavePix);

    long countByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta);

}
