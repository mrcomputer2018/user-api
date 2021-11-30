package br.com.livrobeckend.userapi.service;

import br.com.livrobeckend.userapi.dto.UserDTO;
import br.com.livrobeckend.userapi.model.Users;
import br.com.livrobeckend.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<Users> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<Users> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            return UserDTO.convert(usuario.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        Users users = userRepository.save(Users.convert(userDTO));
        return UserDTO.convert(users);
    }

    public UserDTO delete(long userId) {
        Optional<Users> users = userRepository.findById(userId);
        if (users.isPresent()) {
            userRepository.delete(users.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        Users users = userRepository.findByCpf(cpf);
        if (users != null) {
            return UserDTO.convert(users);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<Users> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

}
