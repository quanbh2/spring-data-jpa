package net.friend.controller.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageOfItem<T> {

  @JsonProperty("content")
  private List<T> content;

  @JsonProperty("page")
  private CustomPage page;
}
