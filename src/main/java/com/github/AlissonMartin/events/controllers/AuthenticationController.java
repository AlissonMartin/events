package com.github.AlissonMartin.events.controllers;

import com.github.AlissonMartin.events.domain.user.User;
import com.github.AlissonMartin.events.dto.LoginRequestDTO;
import com.github.AlissonMartin.events.dto.LoginResponseDTO;
import com.github.AlissonMartin.events.dto.RegisterRequestDTO;
import com.github.AlissonMartin.events.dto.RegisterResponseDTO;
import com.github.AlissonMartin.events.repositories.UserRepository;
import com.github.AlissonMartin.events.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = this.userRepository.findByEmail(body.email());
        if (user.isPresent()) { return ResponseEntity.badRequest().body("Email já cadastrado"); }
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        newUser.setPassword(passwordEncoder.encode(body.password()));

        this.userRepository.save(newUser);

        String token = this.tokenService.generateToken(newUser);

        return ResponseEntity.ok(new RegisterResponseDTO(newUser.getName(), token));
    }
}
