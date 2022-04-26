package io.github.educontessi.pixkeyregistration.ports.in;

import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;
import io.github.educontessi.pixkeyregistration.core.usecase.validation.Validator;

import java.util.List;

public interface ChavePixUseCasePort {

    List<ChavePix> findAll();

    ChavePix findById(Long id);

    ChavePix save(ChavePix model, List<Validator> validators);

    ChavePix update(Long id, ChavePix model, List<Validator> validators);

    void delete(Long id, List<Validator> validators);
}
