package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
//    List<User> getAllUsersWithRole();
    void create(User user);
    void update(User user);
    void delete(User user);

    Optional<User> findUserByEmail(String email);
    User findUserByEmail1(String email);
    User findUserById(Long id);
    User findByUsername(String username);
}
