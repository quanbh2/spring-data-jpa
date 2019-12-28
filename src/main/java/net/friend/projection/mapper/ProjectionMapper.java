package net.friend.projection.mapper;

import java.util.List;
import java.util.stream.Collectors;
import net.friend.dto.RoleDto;
import net.friend.projection.RoleProjection;

public class ProjectionMapper {

  public static RoleDto toRoleDto(List<RoleProjection> roleProjections) {

    return RoleDto.builder()
        .name(roleProjections.get(0).getRoleName())
        .listPrivileges(
            roleProjections.stream()
                .map(RoleProjection::getPrivilegeName)
                .collect(Collectors.toList()))
        .build();
  }
}
