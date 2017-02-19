package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.General;
import com.martinlinha.bloggito.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martinlinha on 19.02.17.
 */
@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @GetMapping("/general")
    public General getGeneral() {
        return generalService.findFirst();
    }
}
