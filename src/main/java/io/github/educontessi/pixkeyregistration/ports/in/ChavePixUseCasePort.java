package io.github.educontessi.pixkeyregistration.ports.in;

import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

import java.util.List;

public interface ChavePixUseCasePort {

    ChavePix save(ChavePix model, List<Validator> validators);

    List<ChavePix> findAll();

    ChavePix findById(Long id);

    ChavePix update(Long id, ChavePix model, List<Validator> validators);

    void delete(Long id, List<Validator> validators);
}
