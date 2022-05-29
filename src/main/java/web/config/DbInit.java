package web.config;

import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit {

    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void createDefaultusers() {
        Set<Role> rolesadmin = new HashSet<>();
        Set<Role> rolesuser = new HashSet<>();
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));
        rolesadmin.add(roleService.getRoleById(1L));
        rolesuser.add(roleService.getRoleById(2L));

        User admin = new User("admin", "lastname", "admin", "1234", Collections.emptySet());
        admin.setRoles(rolesadmin);
        userService.saveUser(admin);

        User user = new User("user", "lastname", "user", "1234", Collections.emptySet());
        user.setRoles(rolesuser);
        userService.saveUser(user);
    }

}