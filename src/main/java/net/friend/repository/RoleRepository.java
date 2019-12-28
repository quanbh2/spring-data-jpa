package net.friend.repository;

import java.util.List;
import java.util.Optional;
import net.friend.model.Role;
import net.friend.projection.RoleProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  @EntityGraph(attributePaths = { "rolePrivileges" })
  Optional<Role> findById(Integer integer);

  String query =
      "SELECT\n"
          + "\tr.NAME AS roleName,\n"
          + "\tp.NAME AS privilegeName \n"
          + "FROM\n"
          + "\troles r\n"
          + "\tJOIN role_privilege AS rp ON rp.role_id = r.id\n"
          + "\tJOIN `privileges` AS p ON rp.privilege_id = p.id \n"
          + "WHERE\n"
          + "\tr.id = ?1";

  @Query(nativeQuery = true, value = query)
  List<RoleProjection> getPrivilegeProjection(Integer roleId);
}
