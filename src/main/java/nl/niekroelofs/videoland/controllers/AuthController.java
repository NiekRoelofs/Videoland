package nl.niekroelofs.videoland.controllers;

import nl.niekroelofs.videoland.DTO.LoginDTO;
import nl.niekroelofs.videoland.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login (@RequestBody LoginDTO login) {
        return userService.login(login.getUsername(), login.getPassword());
    }
}
