package net.friend.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
    name = "roles",
    indexes = {
      @Index(name = "IDX_name", columnList = "name", unique = true),
    })
public class Role {

  @Id private Integer id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "role")
  private List<RolePrivilege> rolePrivileges;
}
