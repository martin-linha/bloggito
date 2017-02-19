package com.martinlinha.bloggito.persistance.dao;

import com.martinlinha.bloggito.persistance.entity.General;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by martinlinha on 19.02.17.
 */
public interface GeneralDao extends CrudRepository<General, Long> {

    General findFirstByOrderByCreatedOnDesc();
}
