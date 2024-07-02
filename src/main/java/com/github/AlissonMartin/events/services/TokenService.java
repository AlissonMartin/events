package com.github.AlissonMartin.events.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.AlissonMartin.events.domain.user.User;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create().withIssuer("events-api").withSubject(user.getEmail()).withExpiresAt(this.generateExpirationDate()).sign(algorithm);

            return token;
        } catch (Exception exception) {
            throw new RuntimeException("Error while authenticating");
        }
    }

    public String decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm).withIssuer("events-api").build().verify(token).getSubject();
    }

    public Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
    }
}
