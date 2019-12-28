package net.friend.controller.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseBody<T> {

  @JsonProperty("data")
  T data;

  String message = "OK";
}
