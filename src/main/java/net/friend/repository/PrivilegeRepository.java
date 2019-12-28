package net.friend.repository;

import java.util.List;
import net.friend.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

  List<Privilege> findByIdIn(List<Integer> ids);

}
