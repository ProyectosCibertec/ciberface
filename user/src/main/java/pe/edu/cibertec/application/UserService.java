package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.ChangePasswordDTO;
import pe.edu.cibertec.domain.dto.EditUserInformationDTO;
import pe.edu.cibertec.domain.dto.GetBasicUserInformationDTO;
import pe.edu.cibertec.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO find(Long id);

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    void delete(Long userId);

    Integer changePassword(long userId, ChangePasswordDTO changePasswordDTO);

    Integer editUserInformation(long userId, EditUserInformationDTO editUserInformationDTO);

    GetBasicUserInformationDTO getBasicUserInformation(long userId);

    List<UserDTO> getFriendsByUser(long userId);

    List<UserDTO> getNoFriendsByUser(long userId);

    GetBasicUserInformationDTO findByUserName(String username);
}
