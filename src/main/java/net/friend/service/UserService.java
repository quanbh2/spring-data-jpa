package net.friend.service;

import java.util.Map;
import net.friend.controller.util.PageOfItem;
import net.friend.dto.UserDto;
import org.springframework.data.domain.Pageable;

public interface UserService {

  PageOfItem<UserDto> getList(Pageable pageable, Map<String, String> requestParams);
}
