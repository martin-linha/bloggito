package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.Certification;
import com.martinlinha.bloggito.service.CertificationService;
import com.martinlinha.bloggito.service.auth.annotation.JwtSecured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martinlinha on 19.02.17.
 */
@RestController
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @PostMapping("/certifications")
    @ResponseStatus(HttpStatus.OK)
    @JwtSecured
    public void addCertification(@RequestBody Certification certification) {
        certificationService.save(certification);
    }

    @GetMapping("/certifications")
    public Iterable<Certification> getAllCertifications() {
        return certificationService.findAll();
    }
}
