package io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository.customquery;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;

import java.util.List;

public interface ChavePixRepositoryQuery {

    List<ChavePixEntity> search(ChavePixFilter filter);

}
