package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.Certification;

import java.util.List;

/**
 * Created by martinlinha on 19.02.17.
 */
public interface CertificationService {

    public Certification save(Certification certification);

    public Iterable<Certification> getCertifications();
}
