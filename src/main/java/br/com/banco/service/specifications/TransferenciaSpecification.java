package br.com.banco.service.specifications;

import br.com.banco.entity.Transferencia;
import br.com.banco.http.dto.TransferenciaFilterDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class TransferenciaSpecification {

    public Specification<Transferencia> getTransferencia(TransferenciaFilterDTO filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getNomeOperador() != null && !filter.getNomeOperador().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("nomeOperadorTransacao")), "%" + filter.getNomeOperador().toUpperCase() + "%"));
            }

            if (filter.getInitialDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataTransferencia"), filter.getInitialDate()));
            }

            if (filter.getEndDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataTransferencia"), filter.getEndDate()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
