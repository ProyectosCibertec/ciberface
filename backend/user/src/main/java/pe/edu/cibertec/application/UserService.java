package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.ChangePasswordDTO;
import pe.edu.cibertec.domain.dto.UserDTO;
import pe.edu.cibertec.domain.entity.User;

import java.util.List;

public interface UserService {
    UserDTO find(Long id);
    List<UserDTO> findAll();
    UserDTO save(UserDTO userDTO);
    void delete(Long userId);
    Integer changePassword(long userId, ChangePasswordDTO changePasswordDTO);
}
