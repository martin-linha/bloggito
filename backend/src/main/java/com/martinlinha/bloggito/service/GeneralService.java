package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.Certification;
import com.martinlinha.bloggito.persistance.entity.General;

/**
 * Created by martinlinha on 19.02.17.
 */
public interface GeneralService extends AbstractCrudService<General, Long> {

    General findFirst();
}
