package io.github.educontessi.pixkeyregistration.core.ports.out;

import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChavePixRepositoryPort {

    ChavePix save(ChavePix model);

    Optional<ChavePix> findById(UUID id);

    ChavePix delete(ChavePix saved);

    List<ChavePix> search(ChavePixFilter filter);

    boolean existeChavePix(String valorChavePix);

    long countByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta);

}
