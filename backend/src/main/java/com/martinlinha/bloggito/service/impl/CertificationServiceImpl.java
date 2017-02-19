package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.CertificationDao;
import com.martinlinha.bloggito.persistance.entity.Certification;
import com.martinlinha.bloggito.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by martinlinha on 19.02.17.
 */
@Service
public class CertificationServiceImpl implements CertificationService {

    @Autowired
    private CertificationDao certificationDao;

    @Override
    public Certification save(Certification certification) {
        return certificationDao.save(certification);
    }

    @Override
    public Iterable<Certification> getCertifications() {
        return certificationDao.findAll();
    }
}
