package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.Certification;
import com.martinlinha.bloggito.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martinlinha on 19.02.17.
 */
@RestController
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @PostMapping("/certifications")
    @ResponseStatus(HttpStatus.OK)
    public void addPost(@RequestBody Certification certification) {
        certificationService.save(certification);
    }

    @GetMapping("/certifications")
    public Iterable<Certification> getAllCertifications() {
        return certificationService.findAll();
    }
}
