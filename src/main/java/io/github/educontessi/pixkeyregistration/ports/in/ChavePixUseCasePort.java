package io.github.educontessi.pixkeyregistration.ports.in;

import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import io.github.educontessi.pixkeyregistration.core.model.ChavePix;

import java.util.List;
import java.util.UUID;

public interface ChavePixUseCasePort {

    ChavePix save(ChavePix model);

    ChavePix path(UUID id, String valorChave);

    ChavePix findById(UUID id);

    ChavePix delete(UUID id);

    List<ChavePix> search(ChavePixFilter filter);
}
