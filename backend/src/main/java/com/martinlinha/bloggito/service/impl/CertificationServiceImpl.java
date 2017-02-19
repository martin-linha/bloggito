package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.CertificationDao;
import com.martinlinha.bloggito.persistance.entity.Certification;
import com.martinlinha.bloggito.service.AbstractCrudService;
import com.martinlinha.bloggito.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by martinlinha on 19.02.17.
 */
@Service
public class CertificationServiceImpl extends AbstractCrudServiceImpl<Certification, Long> implements CertificationService {

    @Autowired
    private CertificationDao certificationDao;

    @Override
    CrudRepository<Certification, Long> getRepository() {
        return certificationDao;
    }
}
