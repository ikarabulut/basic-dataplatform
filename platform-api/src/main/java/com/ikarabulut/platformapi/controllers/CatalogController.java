package com.ikarabulut.platformapi.controllers;

import com.ikarabulut.platformapi.common.ResourceNotFoundException;
import com.ikarabulut.platformapi.models.CatalogDetails;
import com.ikarabulut.platformapi.repository.CatalogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class CatalogController {
    @Autowired
    public CatalogRepository repository;

    @PostMapping("/catalog/create")
    public ResponseEntity<CatalogDetails> createDataProduct(@RequestBody CatalogDetails requestBody) {
        var createResponse = this.repository.save(requestBody);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/catalog/{id}")
                .buildAndExpand(createResponse.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/catalog/{id}")
    public ResponseEntity<CatalogDetails> getDataProduct(@PathVariable String id) {
        var item = this.repository.findById(Long.parseLong(id)).orElseThrow(() -> new ResourceNotFoundException("No data product found with Id: " + id));

        return ResponseEntity.ok(item);
    }
}

