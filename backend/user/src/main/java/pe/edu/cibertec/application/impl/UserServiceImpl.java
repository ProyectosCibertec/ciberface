package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.UserService;
import pe.edu.cibertec.domain.dto.ChangePasswordDTO;
import pe.edu.cibertec.domain.dto.EditUserInformationDTO;
import pe.edu.cibertec.domain.dto.GetBasicUserInformationDTO;
import pe.edu.cibertec.domain.dto.UserDTO;
import pe.edu.cibertec.domain.entity.User;
import pe.edu.cibertec.domain.mapper.UserMapper;
import pe.edu.cibertec.infrastructure.out.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDTO find(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return userMapper.userToUserDTO(user.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.listUserToUserDTO(userRepository.findAll());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Integer changePassword(long userId, ChangePasswordDTO bean) {
        if (!isOldPasswordValid(userId, bean.getOldPassword())) {
            throw new RuntimeException("Las contraseñas no son iguales");
        }
        return userRepository.updateOldPassword(userId, bean.getNewPassword());
    }

    @Override
    public Integer editUserInformation(long userId, EditUserInformationDTO editUserInformationDTO) {
        return userRepository.editUserInformation(
                userId,
                editUserInformationDTO.getUserName(),
                editUserInformationDTO.getFirstName(),
                editUserInformationDTO.getLastName(),
                editUserInformationDTO.getEmail(),
                editUserInformationDTO.getBiography(),
                editUserInformationDTO.getPhotoUrl());
    }

    @Override
    public GetBasicUserInformationDTO getBasicUserInformation(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            GetBasicUserInformationDTO getBasicUserInformationDTO = userMapper.userToGetBasicUserInformationDTO(user.get());
            getBasicUserInformationDTO.setFriendshipsAmount(userRepository.getFriendsAmountByUser(userId));
            return getBasicUserInformationDTO;
        }
        throw new RuntimeException();
    }

    @Override
    public List<UserDTO> getFriendsByUser(long userId) {
        return userMapper.listUserToUserDTO(userRepository.getFriendsByUser(userId));
    }

    private boolean isOldPasswordValid(long userId, String oldPasswordExpected) {
        String oldPassword = userRepository.getOldPassword(userId);
        return oldPassword.equals(oldPasswordExpected);
    }
}
