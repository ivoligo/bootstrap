package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface RoleService {
    List<Role> allRoles();
    void add(Role role);
    Role findRoleByName(String name);
    List<Role> findRoleListByName(List<String> name);
}
