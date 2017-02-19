package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.GeneralDao;
import com.martinlinha.bloggito.persistance.entity.General;
import com.martinlinha.bloggito.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by martinlinha on 19.02.17.
 */
@Service
public class GeneralServiceImpl extends AbstractCrudServiceImpl<General, Long> implements GeneralService {

    @Autowired
    private GeneralDao generalDao;

    @Override
    CrudRepository<General, Long> getRepository() {
        return generalDao;
    }

    @Override
    public General findFirst() {
        return generalDao.findFirstByOrderByCreatedOnDesc();
    }
}
