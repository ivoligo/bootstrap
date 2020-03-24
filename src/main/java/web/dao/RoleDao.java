package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> allRoles();
    void add(Role role);
    List<Role> findRoleListByName(List<String> name);
    Role findRoleByName(String name);
}
