package net.friend;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.friend.dto.RoleDto;
import net.friend.dto.UserDto;
import net.friend.model.Privilege;
import net.friend.model.Role;
import net.friend.projection.RoleProjection;
import net.friend.projection.mapper.ProjectionMapper;
import net.friend.repository.PrivilegeRepository;
import net.friend.repository.RolePrivilegeRepository;
import net.friend.repository.RoleRepository;
import net.friend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringDataJPAApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(SpringDataJPAApplication.class, args);
  }

  @Autowired RoleRepository roleRepository;

  @Autowired RolePrivilegeRepository rolePrivilegeRepository;

  @Autowired PrivilegeRepository privilegeRepository;

  @Autowired
  UserService userService;

  @Override
  public void run(String... args) throws Exception {

    // How to get list privileges of a role and return RoleDTO to client

    // First way
    Role role = roleRepository.findById(1).orElseThrow(NullPointerException::new);

    List<Integer> privilegeIds =
        role.getRolePrivileges().stream()
            .map(value -> value.getPrivilege().getId())
            .collect(Collectors.toList());
    log.info("privilegeIds: {}", privilegeIds);

    List<String> privilegeNames =
        privilegeRepository.findByIdIn(privilegeIds).stream()
            .map(Privilege::getName)
            .collect(Collectors.toList());

    RoleDto roleDto1 = new RoleDto(role.getId(), role.getName(), privilegeNames);

    log.info("roleDto1: {}", roleDto1);

    // Second way

    List<RoleProjection> roleProjections = roleRepository.getPrivilegeProjection(1);

    RoleDto roleDto2 = ProjectionMapper.toRoleDto(roleProjections);

    log.info("roleDto2: {}", roleDto2);

  }
}
