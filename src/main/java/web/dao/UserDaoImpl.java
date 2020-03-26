package web.dao;

//import org.hibernate.annotations.NamedQueries;
//import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createNamedQuery(User.FIND_ALL, User.class).getResultList();
    }

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return em.createNamedQuery(User.FIND_BY_EMAIL, User.class).setParameter("email", email).getResultList().stream().findFirst();
    }

    @Override
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findUserByEmail1(String email) {
        return em.createNamedQuery(User.FIND_BY_EMAIL, User.class).setParameter("email", email).getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        return em.createNamedQuery(User.FIND_BY_EMAIL, User.class).setParameter("email", username).getSingleResult();
    }
}
