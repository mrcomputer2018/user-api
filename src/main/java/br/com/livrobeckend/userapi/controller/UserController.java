package br.com.livrobeckend.userapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public String getMensagem(){
        return "Spring boot esta funcionando";
    }
}
