package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Role;
import ua.lviv.iot.model.RolePK;

public interface RoleRepository extends JpaRepository<Role, RolePK> {
}
