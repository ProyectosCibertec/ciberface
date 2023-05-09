package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.UserService;
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
}
