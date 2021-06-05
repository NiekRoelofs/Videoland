package nl.niekroelofs.videoland.configuration;

import nl.niekroelofs.videoland.models.Role;
import nl.niekroelofs.videoland.models.User;
import nl.niekroelofs.videoland.repository.MovieRepository;
import nl.niekroelofs.videoland.repository.UserRepository;
import nl.niekroelofs.videoland.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setUsername("Niek");
        user.setPassword("welkom");
        user.setRoles(Arrays.asList(Role.ROLE_ADMIN));

        userService.add(user);
    }
}
