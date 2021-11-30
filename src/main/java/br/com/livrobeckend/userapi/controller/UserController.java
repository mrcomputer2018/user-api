package br.com.livrobeckend.userapi.controller;

import br.com.livrobeckend.userapi.dto.UserDTO;
import br.com.livrobeckend.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMensagem(){
        return "Spring boot esta funcionando";
    }

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(
            @RequestParam(name="nome", required = true)
                    String nome) {
        return userService.queryByName(nome);
    }
}
