package net.friend.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.friend.controller.util.PageOfItem;
import net.friend.dto.UserDto;
import net.friend.model.User;
import net.friend.repository.UserRepository;
import net.friend.service.QueryUtil;
import net.friend.service.UserService;
import net.friend.specification.CustomSpecification;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService, QueryUtil<User> {

  @Autowired UserRepository userRepository;

  @Autowired DozerBeanMapper mapper;

  @Override
  public PageOfItem<UserDto> getList(Pageable pageable, Map<String, String> requestParams) {

    CustomSpecification userSpecification = getSpecification(requestParams);
    PageRequest pageRequest = convertPageRequest(pageable);

    Page<User> userPage = userRepository.findAll(userSpecification, pageRequest);

    List<UserDto> userDTOList =
        userPage.getContent().stream()
            .map(user -> mapper.map(user, UserDto.class))
            .collect(Collectors.toList());

    return toPageOfItem(userPage, userDTOList);
  }
}
