package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUsers();
    void create(User user);
    void update(User user);
    void delete(User user);

    Optional<User> findUserByEmail(String email);
    User findUserById(Long id);
    User findUserByEmail1(String email);

    User findByUsername(String username);
}
