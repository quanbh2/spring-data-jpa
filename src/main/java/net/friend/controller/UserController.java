package net.friend.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.friend.controller.util.PageOfItem;
import net.friend.controller.util.ResponseBody;
import net.friend.dto.UserDto;
import net.friend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userService;

  //localhost:8080/api/users/list?page=1&size=10&sort=id,desc
  @GetMapping("/list")
  public ResponseEntity<ResponseBody> findUser(
      Pageable pageable, @RequestParam Map<String, String> requestParams) {

    PageOfItem<UserDto> userDtoPage = userService.getList(pageable, requestParams);

    ResponseBody responseBody = new ResponseBody<Page<UserDto>>();
    responseBody.setData(userDtoPage);
    responseBody.setMessage("OK");

    return new ResponseEntity<>(responseBody, HttpStatus.OK);


  }
}
