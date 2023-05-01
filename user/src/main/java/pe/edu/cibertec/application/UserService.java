package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.User;

import java.util.List;

public interface UserService {
    User find(Long userId);
    List<User> findAll();
    User save(User user);
    void delete(Long userId);
}
