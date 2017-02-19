package com.martinlinha.bloggito.persistance.dao;

import com.martinlinha.bloggito.persistance.entity.Certification;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by martinlinha on 19.02.17.
 */
public interface CertificationDao extends CrudRepository<Certification, Long> {
}
