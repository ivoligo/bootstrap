package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> allRoles() {
        return em.createNamedQuery(Role.ROLE_FIND_ALL, Role.class).getResultList();
    }

    @Override
    public void add(Role role) {
        if(role.getId() == null){
            em.persist(role);
        } else {
            em.merge(role);
        }
    }

    @Override
    public List<Role> findRoleListByName(List<String> name) {
        return em.createNamedQuery(Role.FIND_BY_NAME_LIST, Role.class).getResultList();
    }

    @Override
    public Role findRoleByName(String name) {
            return em.createNamedQuery(Role.FIND_BY_NAME, Role.class).setParameter("rolesName", name).getSingleResult();
    }
    @Override
    public Optional<Role> findRoleByNameOpt(String name) {
        return em.createNamedQuery(Role.FIND_BY_NAME, Role.class).setParameter("rolesName", name).getResultList().stream().findFirst();
    }
}
