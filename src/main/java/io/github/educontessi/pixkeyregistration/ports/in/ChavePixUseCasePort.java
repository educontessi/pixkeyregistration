package io.github.educontessi.pixkeyregistration.ports.in;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

import java.util.List;
import java.util.UUID;

public interface ChavePixUseCasePort {

    ChavePix save(ChavePix model);

    ChavePix path(UUID id, String valorChave);

    ChavePix findById(UUID id);

    List<ChavePix> findAll();

    void delete(UUID id, List<Validator> validators);
}
