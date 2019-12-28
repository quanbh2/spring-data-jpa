package net.friend.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Data
@Slf4j
@AllArgsConstructor
public class CustomSpecification<Object> implements Specification<Object> {

  private List<SearchCriteria> criterion;

  @Override
  public Predicate toPredicate(
      Root<Object> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {

    List<Predicate> predicates = new ArrayList<>();

    criterion.forEach(
        criteria -> {
          Predicate predicate;
          switch (criteria.getOperation()) {
            case LIKE:
              predicate =
                  builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
              break;
            case GREATER_THAN:
              predicate =
                  builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
              break;
            case LESS_THAN:
              predicate =
                  builder.equal(root.get(criteria.getKey()), criteria.getValue().toString());
              break;
            default: // EQUAL
              predicate = builder.equal(root.get(criteria.getKey()), criteria.getValue());
          }

          predicates.add(predicate);
        });

    return builder.and(predicates.toArray(new Predicate[0]));
  }
}
