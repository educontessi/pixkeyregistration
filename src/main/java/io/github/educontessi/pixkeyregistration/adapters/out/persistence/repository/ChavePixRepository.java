package io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository.customquery.ChavePixRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePixEntity, UUID>, ChavePixRepositoryQuery {

    boolean existsByValorChave(String valorChave);

    long countByNumeroAgenciaAndNumeroContaAndDataHoraInativacaoIsNull(Integer numeroAgencia, Integer numeroConta);

}
