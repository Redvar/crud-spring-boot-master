package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;

@Repository
public interface RoleDao {
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    void addRole(Role role);
}
