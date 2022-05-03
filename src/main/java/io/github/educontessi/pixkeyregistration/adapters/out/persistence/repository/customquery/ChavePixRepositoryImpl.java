package io.github.educontessi.pixkeyregistration.adapters.out.persistence.repository.customquery;

import io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity.ChavePixEntity;
import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ChavePixRepositoryImpl implements ChavePixRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<ChavePixEntity> search(ChavePixFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ChavePixEntity> criteria = builder.createQuery(ChavePixEntity.class);
        Root<ChavePixEntity> root = criteria.from(ChavePixEntity.class);

        Predicate[] predicates = createRestrictions(filter, builder, root);
        criteria.where(predicates);

        TypedQuery<ChavePixEntity> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] createRestrictions(ChavePixFilter filter, CriteriaBuilder builder, Root<ChavePixEntity> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter != null && !StringUtils.isEmpty(filter.getNomeCorrentista())) {
            predicates.add(builder.like(root.get("nomeCorrentista"), "%" + filter.getNomeCorrentista().toLowerCase() + "%"));
        }

        if (filter != null && filter.getTipoChave() != null) {
            predicates.add(builder.equal(root.get("tipoChave"), filter.getTipoChave()));
        }

        return predicates.toArray(new Predicate[0]);
    }

}
