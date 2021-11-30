package br.com.livrobeckend.userapi.controller;

import br.com.livrobeckend.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static br.com.livrobeckend.userapi.dto.UserDTO.usuarios;

@RestController
public class UserController {
    @GetMapping("/")
    public String getMensagem(){
        return "Spring boot esta funcionando";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        for (UserDTO userFiler: usuarios) {
            if (userFiler.getCpf().equals(cpf)) {
                return userFiler;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    public UserDTO inserir(@RequestBody UserDTO userDTO){
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("user/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        for (UserDTO userFilter: usuarios) {
            if (userFilter.getCpf().equals(cpf)){
                usuarios.remove(userFilter);
                return true;
            }
        }
        return false;
    }

}
