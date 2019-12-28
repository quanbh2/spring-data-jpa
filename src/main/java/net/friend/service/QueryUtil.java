package net.friend.service;

import static net.friend.specification.SearchTypeEnum.EQUAL;
import static net.friend.specification.SearchTypeEnum.LIKE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.friend.controller.util.CustomPage;
import net.friend.controller.util.PageOfItem;
import net.friend.specification.CustomSpecification;
import net.friend.specification.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface QueryUtil<T> {

  default CustomSpecification getSpecification(Map<String, String> requestParams) {

    List<SearchCriteria> criteriaList = new ArrayList<>();
    requestParams.forEach(
        (key, value) -> {
          switch (key) {
            case "sort":
            case "page":
            case "size":
              break;
            default:
              if (key.contains("Like")) {
                criteriaList.add(new SearchCriteria(key.replace("Like", ""), LIKE, value));
              } else {
                criteriaList.add(new SearchCriteria(key, EQUAL, value));
              }
              break;
          }
        });

    return new CustomSpecification<T>(criteriaList);
  }

  default PageOfItem toPageOfItem(Page page, List listItem) {

    CustomPage customPage =
        CustomPage.builder()
            .totalElements(page.getTotalElements())
            .pageNumber(page.getNumber() + 1)
            .pageSize(page.getSize())
            .totalPages(page.getTotalPages())
            .numberOfElements(page.getNumberOfElements())
            .build();

    return new PageOfItem(listItem, customPage);
  }

  default PageRequest convertPageRequest(Pageable pageable) {
    return PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(), pageable.getSort());
  }
}
