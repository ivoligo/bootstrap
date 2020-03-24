package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }

    @Override
    public void add(Role role) {
        Role roleAdmin = new Role( "admin");
        Role roleUser = new Role("user");
        Role roleWebUser = new Role("webUser");
        Role roleOtherUser = new Role("otherUser");
        roleDao.add(roleAdmin);
        roleDao.add(roleUser);
        roleDao.add(roleWebUser);
        roleDao.add(roleOtherUser);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }

    @Override
    public List<Role> findRoleListByName(List<String> name) {
        return roleDao.findRoleListByName(name);
    }

    @Override
    public Optional<Role> findRoleByNameOpt(String name) {
        return roleDao.findRoleByNameOpt(name);
    }
}
