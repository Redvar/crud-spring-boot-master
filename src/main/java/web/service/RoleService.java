package web.service;

import web.models.Role;

public interface RoleService {
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    void addRole(Role role);
}
