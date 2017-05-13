package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.UserDetail;
import com.martinlinha.bloggito.service.UserService;
import com.martinlinha.bloggito.service.auth.annotation.JwtSecured;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Created by martinlinha on 20.02.17.
 */
@RestController
public class UserController {

    @Value("${bloggito.session-ttl}")
    private Long sessionTtl;
    @Value("${bloggito.jwt.secretkey}")
    private String secretkey;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{email:.+}")
    public UserDetail findUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/user")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDetail userDetail) {
        UserDetail fromDb = userService.findByEmail(userDetail.getEmail());
        if (fromDb != null
                && userDetail.getPassword() != null
                && userDetail.getEmail() != null
                && BCrypt.checkpw(userDetail.getPassword(), fromDb.getPassword())) {

            ZonedDateTime createdDate = ZonedDateTime.now();

            String jwtToken = Jwts.builder()
                    .setSubject(userDetail.getEmail())
                    .signWith(SignatureAlgorithm.HS512, secretkey)
                    .setIssuedAt(Date.from(createdDate.toInstant()))
                    .setExpiration(Date.from(createdDate.plusMinutes(sessionTtl).toInstant()))
                    .compact();
            return new ResponseEntity<>(new LoginResponse(jwtToken), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @JwtSecured
    @GetMapping("/user/logged")
    public HttpStatus isUserAuthenticated() {
        // If user is not logged in, method returns 401
        return HttpStatus.OK;
    }

    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
