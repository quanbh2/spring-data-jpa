package net.friend.specification;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchCriteria {

  private String key;

  private SearchTypeEnum operation;

  private Object value;
}
