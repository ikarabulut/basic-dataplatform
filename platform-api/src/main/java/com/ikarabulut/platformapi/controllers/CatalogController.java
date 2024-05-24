package com.ikarabulut.platformapi.controllers;

import com.ikarabulut.platformapi.models.CatalogDetails;
import com.ikarabulut.platformapi.repository.CatalogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class CatalogController {
    @Autowired
    public CatalogRepository repository;

    @PostMapping("/catalog/create")
    public ResponseEntity<CatalogDetails> createDataProduct(@RequestBody CatalogDetails requestBody) {
        var createResponse = repository.save(requestBody);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/catalog/{id}")
                .buildAndExpand(createResponse.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

