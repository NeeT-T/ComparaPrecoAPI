package com.comparapreco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comparapreco.services.CachingService;

@RestController
public class CachingController {
	
    @Autowired
    CachingService cachingService;
	
    @GetMapping("clearAllCaches")
    public void clearAllCaches() {
        cachingService.evictAllCaches();
    }
}
