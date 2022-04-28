package io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<ChavePixEntity, Long> {

    boolean existsByValorChave(String valorChave);

}
