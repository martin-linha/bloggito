package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.UserDetail;
import com.martinlinha.bloggito.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by martinlinha on 20.02.17.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDetail userDetail) {
        UserDetail fromDb = userService.findByEmail(userDetail.getEmail());

        if (fromDb != null
                && userDetail.getPassword() != null
                && userDetail.getEmail() != null
                && BCrypt.checkpw(userDetail.getPassword(), fromDb.getPassword())) {
            return new ResponseEntity<>(new LoginResponse(Jwts.builder()
                    .setSubject(userDetail.getEmail())
                    .signWith(SignatureAlgorithm.HS512, "secretkey")
                    .setIssuedAt(new Date())
                    .compact()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
